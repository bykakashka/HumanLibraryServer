package com.byka.humanlibrary.helper;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    private static final String DATE_FORMAT = "dd.MM.yyyy";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    private static final String TIME_FORMAT = "HH:mm";
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);

    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat(DATE_FORMAT + " " + TIME_FORMAT);

    public static String convertToString(@NotNull final Date date) {
        return dateTimeFormat.format(date);
    }

    public static String convertToStringDate(@NotNull final Date date) {
        return dateFormat.format(date);
    }

    public static String convertToStringTime(@NotNull final Date date) {
        return timeFormat.format(date);
    }

    public static Date convertFromStringWithTime(@NotNull String date) throws ParseException {
        if (date.contains(" ")) {
            return dateTimeFormat.parse(date);
        } else {
            return dateFormat.parse(date);
        }
    }
}
