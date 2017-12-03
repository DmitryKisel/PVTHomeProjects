package by.itacademy.Lesson7.Task1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Task2 {
    public static void main(String[] args) {
        Date date = new Date();
        int day = date.getDate();


        String patern = "MMM.dd'" + getPostfix(day) + "' hh:mm a";
        //одинарная ковычка экранирует, выводит содержимое как есть без замены даты.
        // позволяет разорвать шаблон
        SimpleDateFormat sdf = new SimpleDateFormat(patern, Locale.ENGLISH);
        //sdf.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        //задает тайм зону
        String dataText = sdf.format(date);
        System.out.println(dataText);
    }

    private static String getPostfix(int day) {
        if (day >= 11 && day < 13) return "-th";

            switch (day % 10) {
                case 01: {
                    return "-st";
                }
                case 02: {
                    return "-nd";
                }
                case 03: {
                    return "-rd";
                }
                default: {
                    return "-th";
                }

            }
    }
}
