package ru.netology;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.manager.TimeManager;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SecondTaskTest {
    TimeManager manager = new TimeManager();
    String dateToInput = manager.timeConstructor();

    @BeforeEach
    void setupTest() {
        open("http://localhost:9999");
    }

    @Test
    void shouldOrderCardDeliveryByText() {
        $("[placeholder='Город']").setValue("Мурманск");
        $("[placeholder='Дата встречи']").sendKeys(Keys.CONTROL + "a");
        $("[placeholder='Дата встречи']").sendKeys(Keys.DELETE);
        $("[placeholder='Дата встречи']").setValue(String.valueOf(dateToInput));

        manager.endOfInsert();

        $(withText(dateToInput)).
                shouldBe(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldSelectFromList() {
        $("[placeholder='Город']").setValue("Са");
        $(byText("Санкт-Петербург")).click();
        $("[placeholder='Дата встречи']").click(); // открытие календаря
        LocalDate date = LocalDate.now().plusDays(7);
//        LocalDate dateForCheck = LocalDate.now().plusDays(7);

        manager.calendarSelector(date);
        manager.endOfInsert();
        //TODO сделать проверку через timeConstructor()
        //TODO убрать  constructorNotificationContent(LocalDate date)
        String notificationContent = manager.constructorNotificationContent(date);

        $(withText(notificationContent)).
                shouldBe(visible, Duration.ofSeconds(15));
    }
}

