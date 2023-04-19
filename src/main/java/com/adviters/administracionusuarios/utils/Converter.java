package com.adviters.administracionusuarios.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Converter {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static String dateToString(Date date) {
        LocalDate localDate = date.toLocalDate();
        return localDate.format(formatter);
    }

    public static Date stringToDate(String dateString) {
        LocalDate fechaLocal = LocalDate.parse(dateString, formatter);
        Date fechaSql = java.sql.Date.valueOf(fechaLocal);
        return fechaSql;
    }
}
