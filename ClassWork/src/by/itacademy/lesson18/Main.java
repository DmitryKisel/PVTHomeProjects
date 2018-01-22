package by.itacademy.lesson18;





import by.itacademy.Lesson5.Task1.Student;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Main {
    private Student student = new Student();// сильная ссылка
    private  SoftReference<Student> studentSoftReference =
            new SoftReference<Student>(new Student());// мягкая ссылка

    private WeakReference<Student> studentWeakReference =
            new WeakReference<Student>(new Student());// слабая ссылка

    public  void main(String[] args) {
        Student student = studentSoftReference.get();
        Main main = new Main();
    }
}
