package by.itacademy.HomeWork10.Task2;

public class Person {
    private String lastName;
    private String firstName;
    private String paternalName;

    public Person(String lastName, String firstName, String paternalName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.paternalName = paternalName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPaternalName() {
        return paternalName;
    }
}
