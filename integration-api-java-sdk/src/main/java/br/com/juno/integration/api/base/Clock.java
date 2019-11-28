package br.com.juno.integration.api.base;

import java.util.Calendar;

import br.com.juno.integration.api.utils.CalendarUtils;

public final class Clock {

    private Clock() {
        // Utility Class
    }

    public static Calendar getCalendar() {
        return fixedCalendar == null ? Calendar.getInstance() : fixedCalendar;
    }

    public static Long getTimeInMillis() {
        return getCalendar().getTimeInMillis();
    }

    public static void setFixedCalendar(Long timeInMillis) {
        fixedCalendar = CalendarUtils.cal(timeInMillis);
    }

    public static void setFixedCalendar(String date) {
        fixedCalendar = CalendarUtils.cal(date);
    }

    private static Calendar fixedCalendar;
}
