package ru.netology.manager;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TimeManager {
    String[] date;

    public String timeConstructor() {
        DateTime dtOrg = new DateTime(date);
        DateTime dtPlus = dtOrg.plusDays(5);

        String day = String.valueOf(dtPlus.getDayOfMonth());
        String month = String.valueOf(dtPlus.getMonthOfYear());
        String year = String.valueOf(dtPlus.getYear());

        return day + '.' + month + '.' + year;
    }

    public String currentDate() {
        String date = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println(date);
        return date;
    }

    public void calendarSelector(LocalDate date) {
        int currentMonth = LocalDate.now().getMonthOfYear();
        int month = date.getMonthOfYear();

        if (!Objects.equals(month, currentMonth)) {
            $("[data-step='1']").click();
        }
        String theRightDay = String.valueOf(date.getDayOfMonth());
        $$("[role=gridcell]").find(exactText(theRightDay)).click();
    }

    public void endOfInsert() {
        $("[name='name']").setValue("Пореченков Михаил");
        $("[name='phone']").setValue("+79009009988");
        $("[class='checkbox__box']").click();
        $(withText("Забронировать")).click();
    }

    public String constructorNotificationContent(LocalDate date) {

        String day = String.valueOf(date.getDayOfMonth()) + '.';
        String month = String.valueOf(date.getMonthOfYear()) + '.';
        String year = String.valueOf(date.getYear());

        return day + month + year;
    }
}
