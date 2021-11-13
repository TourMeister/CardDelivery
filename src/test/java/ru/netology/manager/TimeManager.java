package ru.netology.manager;

import org.joda.time.DateTime;

import java.util.Date;

public class TimeManager {
    Date date = new Date();

    public String timeConstructor() {
        DateTime dtOrg = new DateTime(date);
        DateTime dtPlus = dtOrg.plusDays(5);

        String day = String.valueOf(dtPlus.getDayOfMonth());
        String month = String.valueOf(dtPlus.getMonthOfYear());
        String year = String.valueOf(dtPlus.getYear());

        return day + '.' + month + '.' + year;
    }

    public String[] plusDays(int plusDays) {
        DateTime dtOrg = new DateTime(date);
        DateTime dtPlus = dtOrg.plusDays(plusDays);

        String day = String.valueOf(dtPlus.getDayOfMonth());
        String monthName = dtPlus.monthOfYear().getAsText();
        String year = String.valueOf(dtPlus.getYear());

        return new String[]{day, monthName, year};
    }


    public String[] currentDate() {
        DateTime dtOrg = new DateTime(date);

        String day = String.valueOf(dtOrg.getDayOfMonth());
        String monthName = dtOrg.monthOfYear().getAsText();
        String year = String.valueOf(dtOrg.getYear());

        return new String[]{day, monthName, year};
    }
}
