package com.example.rest;

import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Constants used throughout the project.
 *
 * @author pvosges
 */
public final class Constants {

    public static final String UTF_8_JSON = MediaType.APPLICATION_JSON + ";charset=UTF-8";

    /**
     * Date format used by the API in JSON serializations and following the ISO 8601 standard.
     * It is compatible with SimpleDateFormat using the UTC time zone.
     */
    public static final String ISO8601_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    private static final DateFormat JSON_DATE_FORMAT_MODEL = new SimpleDateFormat(ISO8601_DATETIME_FORMAT, Locale.ROOT);

    static {
        JSON_DATE_FORMAT_MODEL.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /**
     * Returns a DateFormat that can be used during JSON serializations.
     * The resulting DateFormat is not thread-safe; however as this method does not return the same instance to
     * different threads, it can be used without synchronization.
     */
    public static DateFormat getJsonDateFormat() {
        // Cloning is actually more efficient (and more scalable) than synchronizing around usages.
        return (DateFormat) JSON_DATE_FORMAT_MODEL.clone();
    }
}
