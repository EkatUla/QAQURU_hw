package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestForm{

    @BeforeAll
    static void SetUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void FillFormTest() {
        // тестовые данные
        String name = "Ivan";
        String Last_Name = "Ivanov";
        String Email = "Ivanov@qaz.ru";
        String Number = "9999999999";
        String Subject = "Maths";
        int data = 31;
        String Adder = "My Address";


        open("/automation-practice-form");
        //executeJavaScript("$('footer').remote()");
        //executeJavaScript("$('#fixedban').remote()");
        $("#firstName").setValue(name);
        $("#lastName").setValue(Last_Name);
        $("#userEmail").setValue(Email);
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue(Number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--0" + data).click();
        $("#subjectsInput").setValue(Subject).pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/test.txt"));
        $("#currentAddress").setValue(Adder);
        $("#state").click();
        $("#state").$(byText("NCR")).doubleClick();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();
        $(".table-responsive").shouldHave(Condition.text(name + " " + Last_Name));
        $(".table-responsive").shouldHave(text(Email));
        $(".table-responsive").shouldHave(text(Number));
        $(".table-responsive").shouldHave(Condition.text(data + " " + "December" + "," + "2000"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("NCR"));
        $(".table-responsive").shouldHave(text("Delhi"));
        $(".table-responsive").shouldHave(text(Adder));
        $(".table-responsive").shouldHave(text("test.txt"));
        $(".table-responsive").shouldHave(text("Other"));
    }
}
// Новыйаываывавыаваываываываыва

