import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Petr");
        $("#lastName").setValue("Petrovich");
        $("#userEmail").setValue("petrPetrovich@pp.ru");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("7999399999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").val("Computer Science").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("picture.png");
        $("#currentAddress").setValue("Some Address");
        $("#currentAddress").click();
        $("#react-select-3-input").val("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").val("Agra").pressEnter();
        $("#submit").click();
        
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text("Petr Petrovich"));
        $(".table-responsive").$(byText("Student Email"))
                .parent().shouldHave(text("petrPetrovich@pp.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("7999399999"));
        $(".table-responsive").$(byText("Date of Birth"))
                .parent().shouldHave(text("17 October,1995"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Computer Science"));
        $(".table-responsive").$(byText("Hobbies"))
                .parent().shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("picture.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Some Address"));
        $(".table-responsive").$(byText("State and City"))
                .parent().shouldHave(text("Uttar Pradesh Agra"));

    }

}
