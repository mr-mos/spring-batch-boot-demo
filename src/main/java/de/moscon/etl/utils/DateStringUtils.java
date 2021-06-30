package de.moscon.etl.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateStringUtils {

    public String newString(String oldDateString){

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
        Date d = null;
        try {
            d = sdf.parse(oldDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf.applyPattern("yyyy-MM-dd");
        String newDateString = sdf.format(d);
        return newDateString;
    }
}
