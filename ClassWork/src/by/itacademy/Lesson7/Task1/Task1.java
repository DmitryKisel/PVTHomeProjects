package by.itacademy.Lesson7.Task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class Task1 {

    public static void main(String[] args)  {
        Date date = new Date();
        System.out.println(date.toString());// выводит дату
        System.out.println(date.getTime());// время в млсек с января 1980

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMMM yyyy", Locale.forLanguageTag("ru"));

        String dataText = sdf.format(date);
        String dataText1 = sdf1.format(date);
        String dataText2 = sdf2.format(date);

        System.out.println(dataText);
        System.out.println(dataText1);
        System.out.println(dataText2);

        String inputDate = "2017-11-30 17:50";
        Date data2 = null;
        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
           data2 = sdf4.parse(inputDate);
       } catch (ParseException e){
            System.out.println("Неверный формат данных");
        }
        System.out.println(data2.toString());
    }




}
