package br.com.juno.integration.api.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

public final class CalendarUtils {

    public static final String API_DATE_FORMAT = "yyyy-MM-dd";

    private CalendarUtils() {
        // Utility class
    }

    public static Calendar cal(Long timeInMillis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInMillis);
        return cal;
    }

    public static Calendar cal(String date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parse(date));
        return cal;
    }

    public static Date parse(String date) {
        try {
            if (date.indexOf(':') == -1) {
                return SDF.parse(date);
            }
            return DTDF.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static final FastDateFormat SDF = FastDateFormat.getInstance("dd/MM/yyyy");
    private static final FastDateFormat DTDF = FastDateFormat.getInstance("dd/MM/yyyy HH:mm:ss");

}
