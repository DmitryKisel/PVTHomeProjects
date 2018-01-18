package by.itacademy.homeWork16.Domain.Entity;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Employee  {
    private int id;
    private String name;
    private String degree;
    private Date dateOfBirth;
    private int yearEperience;
    private List<String> emails;

    @SerializedName("visible")
    private boolean isVisible;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getYearEperience() {
        return yearEperience;
    }

    public void setYearEperience(int yearEperience) {
        this.yearEperience = yearEperience;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (yearEperience != employee.yearEperience) return false;
        if (isVisible != employee.isVisible) return false;
        if (!name.equals(employee.name)) return false;
        if (!degree.equals(employee.degree)) return false;
        if (!dateOfBirth.equals(employee.dateOfBirth)) return false;
        return emails.equals(employee.emails);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + degree.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + yearEperience;
        result = 31 * result + emails.hashCode();
        result = 31 * result + (isVisible ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", degree='" + degree + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", yearEperience=" + yearEperience +
                ", emails=" + emails +
                ", isVisible=" + isVisible +
                '}';
    }

    /**
     * This method prints employee's data in specific format
     * @param employee
     */
   public static void printEmployee(Employee employee) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        System.out.printf("%-30s%-5s%-5d%-30s%-17s%-14s%-7d%-9s%-200s%n", "Ф.И.О: " + employee.getName(),  " ID: ",  employee.getId(),"" +
                        " Дата рождения: "  + sdf.format(employee.getDateOfBirth()), " Степень: " + employee.getDegree(),
                " Опыт работы:", employee.getYearEperience(), "e-mails: ", employee.getEmails());
        System.out.println();
    }


}
