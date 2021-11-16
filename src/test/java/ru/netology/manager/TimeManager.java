package ru.netology.manager;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

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

    public String[] plusDays(int plusDays) {
        LocalDate dtPlus = LocalDate.now().plusDays(plusDays);

        String day = String.valueOf(dtPlus.getDayOfMonth());
        String monthName = dtPlus.monthOfYear().getAsText();
        String year = String.valueOf(dtPlus.getYear());

        return new String[]{day, monthName, year};
    }

    public String currentDate() {
        String date = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println(date);
        return date;
    }


    public void calendarSelector(String[] date) {
//        String[] currentDate = currentDate();
        if (!Objects.equals(date[1], currentDate[1])) {
            $("[data-step='1']").click();
        }
        String theRightDay = date[0];
        $$("[role=gridcell]").find(exactText(theRightDay)).click();
    }

    public void endOfInsert() {
        $("[name='name']").setValue("Пореченков Михаил");
        $("[name='phone']").setValue("+79009009988");
        $("[class='checkbox__box']").click();
        $(withText("Забронировать")).click();
    }
}
