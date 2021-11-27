package com.vhry.mapper;

import org.mapstruct.Mapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateStringMapper {

    //STRING
    public static String asString(Date date) {
        return date.toString();
    }

    public static String asString(LocalDate date) {
        return date.toString();
    }

    public static String asString(LocalDateTime dateTime) {
        return dateTime.toString();
    }


    //DATE / LOCAL_DATE / LOCAL_DATE_TIME
    public static Date asDate(String string) {
        return Date.from(Instant.parse(string));
    }

    public static LocalDate asLocalDate(String string) {
        return LocalDate.parse(string);
    }

    public static LocalDate asLocalDate(String string, String formatTemplate) {
        return LocalDate.parse(string, DateTimeFormatter.ofPattern(formatTemplate));
    }

    public static LocalDateTime asDateTime(String string) {
        return LocalDateTime.parse(string);
    }

    public static LocalDateTime asDateTime(String string, String formatTemplate) {
        return LocalDateTime.parse(string, DateTimeFormatter.ofPattern(formatTemplate));
    }

}
