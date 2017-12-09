package by.itacademy.Lesson9.Task2;

import java.util.Comparator;

public class SortByAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge() == o1.getAge()) return 0;
        if (o1.getAge() > o1.getAge()) return 1;
        return -1;
    }
}
