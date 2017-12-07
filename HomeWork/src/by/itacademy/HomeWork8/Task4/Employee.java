package by.itacademy.HomeWork8.Task4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Employee {
    private String fullName;
    private String occupation;
    private Date dateOfBirth;




    public Employee(String fullName, String occupation, Date dateOfBirth) {
        this.fullName = fullName;
        this.occupation = occupation;
        this.dateOfBirth = dateOfBirth;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}




