package org.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormating {
    public static Date format(String date) throws ParseException {
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
        return date1;
    }
}
