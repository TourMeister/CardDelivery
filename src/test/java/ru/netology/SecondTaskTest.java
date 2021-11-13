package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.manager.TimeManager;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SecondTaskTest {
        TimeManager manager = new TimeManager();
        String dateToInput = manager.timeConstructor();
        String[] currentDate = manager.currentDate();
        String[] date;

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

            endOfInsert();

            $(withText("Успешно!")).
                    shouldBe(visible, Duration.ofSeconds(15));
        }

        @Test
        void shouldSelectFromList() {
            $("[placeholder='Город']").setValue("Са");
            $(byText("Санкт-Петербург")).click();
            $("[placeholder='Дата встречи']").click(); // открытие календаря
            date = manager.plusDays(7);

            calendarSelector();
            endOfInsert();

            $(withText("Успешно!")).
                    shouldBe(visible, Duration.ofSeconds(15));
        }

        void calendarSelector() {
            if (!Objects.equals(date[1], currentDate[1])) {
                $("[data-step='1']").click();
            }
            String theRightDay = date[0];
            $$("[role=gridcell]").find(exactText(theRightDay)).click();
        }

        void endOfInsert() {
            $("[name='name']").setValue("Пореченков Михаил");
            $("[name='phone']").setValue("+79009009988");
            $("[class='checkbox__box']").click();
            $(withText("Забронировать")).click();
        }

    }

