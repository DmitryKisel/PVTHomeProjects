package by.itacademy.Lesson5.Task1;

public class StringBuilderTask {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("a");
        builder.append("b");
        builder.append("c");
        builder.append("dsf");
        builder.append("jshfjfh");
        builder.append("d");
        String text = builder.toString();

        String text1 = "a".concat("b");
        String text2 = "a" + "b" + "c";

    }
}
