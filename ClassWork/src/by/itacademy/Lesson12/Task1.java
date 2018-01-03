package by.itacademy.Lesson12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {


        String text ="@abs@gmail.com@";

        text = text.replaceAll("^@|@$", "");
        System.out.println(text);


        String text1 = "2200 MP-7";
        Pattern pattern = Pattern.compile("^[0-9]{4}\\s[A-Za-z]{2}[-][1-7]");
        Matcher matcher = pattern.matcher(text1);
        if(matcher.matches()){
            System.out.println("Номер коректный");
        }
        else {
            System.out.println("Номер некоректный");
        }

        String text2 = "+375 (29) 111-11-11";
        text2 = text2.replaceAll("\\D","");
        System.out.println(text2);


        Pattern pattern2 = Pattern.compile("^375(29|33|17|44|25)[0-9]{7}$");
        Matcher matcher2 = pattern2.matcher(text2);
        if(matcher2.matches()){
            System.out.println("Номер коректный");
        }
        else {
            System.out.println("Номер некоректный");
        }
    }


}
