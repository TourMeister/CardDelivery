package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.manager.TimeManager;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {
    TimeManager manager = new TimeManager();
    String dateToInput = manager.timeConstructor();

    @BeforeEach
    void setupTest() {
        open("http://localhost:9999");
    }


    @Test
    void shouldOrderCardDeliveryByText() {
        $("[placeholder='Город']").setValue("Мурманск");
        $("[placeholder='Дата встречи']").sendKeys(Keys.CONTROL+"a");
        $("[placeholder='Дата встречи']").sendKeys(Keys.DELETE);
        $("[placeholder='Дата встречи']").setValue(String.valueOf(dateToInput));

        manager.endOfInsert();

        $(withText(dateToInput)).
                shouldBe(visible, Duration.ofSeconds(15));
    }
}
