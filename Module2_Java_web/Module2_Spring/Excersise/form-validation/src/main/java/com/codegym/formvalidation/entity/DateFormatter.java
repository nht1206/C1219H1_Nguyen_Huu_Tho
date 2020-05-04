package com.codegym.formvalidation.entity;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.ParseException;
import java.util.Locale;

@Component
public class DateFormatter implements Formatter<Date> {
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        return Date.valueOf(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        return date.toString();
    }
}
