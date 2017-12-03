package by.itacademy.Lesson7.Task1;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Task3 {
    public static void main(String[] args) {
        Date date = new Date();
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(date);
        int day = gc.get(GregorianCalendar.DAY_OF_MONTH);
        int month = gc.get(GregorianCalendar.MONTH);
     //  gc.add(GregorianCalendar.DATE, 30);
        // добавляет дни

        gc.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        gc.add(GregorianCalendar.YEAR, 30);
        System.out.println(gc.getTime().toString()); // getTime - переводит в Date
    }
}
