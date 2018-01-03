package by.itacademy.Lesson12.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

    }

    public static boolean checkCarNumber(String text){
        Pattern pattern = Pattern.compile("^[0-9]{4}\\s[A-Za-z]{2}[-][1-7]");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean checkPhoneNumber(String text){
        text = text.replaceAll("\\D","");
        System.out.println(text);
        Pattern pattern = Pattern.compile("^375(29|33|17|44|25)[0-9]{7}$");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();



    }
}
