package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.netology.manager.TimeManager;

public class CardDeliveryTest {
    private WebDriver driver;

    @Test
    void print() {
        TimeManager manager = new TimeManager();
        String futureDate = manager.TimeConstructor();
        System.out.println(manager);
    }
//
//    @BeforeAll
////    Автоматическая установка ChromeDriver для операционной системы
//    static void setUpClass() {
//        WebDriverManager.chromedriver().setup();
//    }

//    @BeforeEach
//    void setupTest() {
//        ChromeOptions options = new ChromeOptions();
////        driver = new ChromeDriver(options);
//        open("http://localhost:9999");
//
//    }
//
//    @AfterEach
//    void teardown() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }

//
//    @Test
//    void shouldOrderCardDeliveryByText() {
//        $("[placeholder='Город']").setValue("Мурманск");
//        $("[placeholder='Дата встречи']").sendKeys(Keys.CONTROL+"a");
//        $("[placeholder='Дата встречи']").sendKeys(Keys.DELETE);
//        $("[placeholder='Дата встречи']").setValue(String.valueOf(dtPlus));
//        $("[name='name']").setValue("Пореченков Михаил");
//        $("[name='phone']").setValue("+79009009988");
//        $(withText("checkbox__box")).click();
//        $(withText("Забронировать")).click();
//
//        $(withText("Успешная регистрация! Вы будете перенаправлены в течение нескольких секунд.")).
//                shouldBe(visible, Duration.ofSeconds(6));
//        $(withText("Личный кабинет")).
//                shouldBe(visible, Duration.ofSeconds(6));
//    }
}
