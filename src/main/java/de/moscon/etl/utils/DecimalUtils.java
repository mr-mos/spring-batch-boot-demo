package de.moscon.etl.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class DecimalUtils {

    public Double newDouble(String oldString){
        NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);
        Number number = null;
        try {
            number = format.parse(oldString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double d = number.doubleValue();
        return d;
    }
}
