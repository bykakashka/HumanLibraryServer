package com.byka.humanlibrary.helper;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    private static final String DATE_FORMAT = "dd.MM.yyyy";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    private static final String TIME_FORMAT = "HH:mm";
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);

    public static String convertToString(@NotNull final Date date) {
        return dateFormat.format(date);
    }

    public static String convertToStringWithTime(@NotNull final Date date) {
        return timeFormat.format(date);
    }
}
