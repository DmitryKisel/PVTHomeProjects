package by.itacademy.HomeWork13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String... args) {
        System.out.println("hellowoooorld");
        System.out.println(squeeze("hellowoooorld"));
    }

    private static String squeeze(String data) {
        String result = "";

        Pattern pattern = Pattern.compile("(.)\\1{0,}");

        Matcher matcher = pattern.matcher(data);

        while (matcher.find()) {
            result += matcher.group(1);
            int length = matcher.group().length();
            if (length > 1)
                result += length;
        }
        return result;
    }
}
