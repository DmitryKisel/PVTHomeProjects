package by.itacademy.homeWork16.Domain.Entity;

import java.util.List;

public class Root {

    private String name;
    private String location;
    private  int baseSalary;
    private List<Employee> employees;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Root root = (Root) o;

        if (baseSalary != root.baseSalary) return false;
        if (!name.equals(root.name)) return false;
        if (!location.equals(root.location)) return false;
        return employees.equals(root.employees);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + location.hashCode();
        result = 31 * result + baseSalary;
        result = 31 * result + employees.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", baseSalary=" + baseSalary +
                ", employees=" + employees +
                '}';
    }
}
