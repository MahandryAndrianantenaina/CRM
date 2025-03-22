package itu.com.CRM.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumberFormatter {

    public static String formatNumberWithSpaces(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###", new DecimalFormatSymbols(Locale.FRENCH));
        decimalFormat.setGroupingSize(3); 
        decimalFormat.setGroupingUsed(true); 

        return decimalFormat.format(number);
    }

    public static String formatNumberWithSpaces(double number, int decimalPlaces) {
        StringBuilder pattern = new StringBuilder("#,###");
        if (decimalPlaces > 0) {
            pattern.append(".");
            for (int i = 0; i < decimalPlaces; i++) {
                pattern.append("#");
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat(pattern.toString(), new DecimalFormatSymbols(Locale.FRENCH));
        decimalFormat.setGroupingSize(3); 
        decimalFormat.setGroupingUsed(true); 

        return decimalFormat.format(number);
    }
}