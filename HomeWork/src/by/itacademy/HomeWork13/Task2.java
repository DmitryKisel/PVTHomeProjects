package by.itacademy.HomeWork13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        String fileName="kgksgnkdnfs.xml" ;
        Pattern pattern = Pattern.compile("\\w+([.][A-Za-z]+$)");
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.find()) {
            String extension = matcher.group(1);
            System.out.println("расширение файла: " + extension);
        }
    }
}
