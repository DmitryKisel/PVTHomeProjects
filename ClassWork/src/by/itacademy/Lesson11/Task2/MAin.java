package by.itacademy.Lesson11.Task2;

public class MAin {
    int a =1;
    Parsing parsing = null;
    if(a == 1){
        parsing = new XmlParsing();
    }
    else {
        parsing = new JsonParsing();
    }
}
