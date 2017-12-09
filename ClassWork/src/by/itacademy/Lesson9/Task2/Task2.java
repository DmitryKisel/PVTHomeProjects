package by.itacademy.Lesson9.Task2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.add("1111");
        array.add("2222");
        array.add("3333");
        array.add("4444");
        System.out.println("List size is: " + array.size());
        array.add("5555");
        System.out.println("List size is: " + array.size());

        System.out.println(array.get(3));

        array.remove(3);
        System.out.println("List size is: " + array.size());

        array.add(3, "3030");// добовляет со сдвигом
        System.out.println(array.get(3));
        array.set(3, "3131");
        System.out.println(array.get(3));//заменяет значение под индексом
        // плюсы  быстрая работа по поиску индекса и возврату итого элемента
        // минусы медлено удаляет и вставляет элементы , если это не последние элементы
        // это проявляется при большом объеме данных

        LinkedList<String> linkedList = new LinkedList<>();
        /* Это двухсвязный список, который имеет ссылку на предыдущий элемент и следующий
        минусы плохо ищет по индексу, т.е. долгий доступ к элменту
        */
        // плюсы вставка и удаление в середину




    }


}
