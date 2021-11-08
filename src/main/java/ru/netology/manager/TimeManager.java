package ru.netology.manager;

import org.joda.time.DateTime;

import java.util.Date;

public class TimeManager {

    public String TimeConstructor() {
        Date date = new Date();
        DateTime dtOrg = new DateTime(date);
        DateTime dtPlus = dtOrg.plusDays(6);

        String day = String.valueOf(dtPlus.getDayOfMonth());
        String month = String.valueOf(dtPlus.getMonthOfYear());
        String year = String.valueOf(dtPlus.getYear());

        return day + '.' + month + '.' + year;
    }
}
