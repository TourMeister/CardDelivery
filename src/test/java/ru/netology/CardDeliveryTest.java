package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.joda.time.Instant;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    private WebDriver driver;

    Date date = new Date();
    DateTime dtOrg = new DateTime(date);
    DateTime dtPlus = dtOrg.plusDays(6);

    @BeforeAll
//    Автоматическая установка ChromeDriver для операционной системы
    static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        ChromeOptions options = new ChromeOptions();
//        driver = new ChromeDriver(options);
        open("http://localhost:9999");

    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @Test
    void date() {
        System.out.println("парам пам паm" + dtPlus);
    }


//    @Test
//    void shouldOrderCardDeliveryByText() {
////        open("http://localhost:9999");
//        $("[placeholder='Город']").setValue("Мурманск");
//        $("[placeholder='Дата встречи']").setValue(currentDate);
//        $("[name='phone']").setValue("+79009009988");
//        $(".input__control [type=tel]").setValue("+79009009988");
//        $(withText("Продолжить")).click();
//        $(withText("Успешная регистрация! Вы будете перенаправлены в течение нескольких секунд.")).
//                shouldBe(visible, Duration.ofSeconds(6));
//        $(withText("Личный кабинет")).
//                shouldBe(visible, Duration.ofSeconds(6));
//    }
}
