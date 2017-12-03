package by.itacademy.HomeWork7.Task2;

import java.util.Date;

public class Student {
    private String firstName;
    private String lastName;
    private Date birthDate;

    public Student(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}
