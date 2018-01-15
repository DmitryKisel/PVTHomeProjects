package by.itAcademy.finalProject.Domain.Methods;

import by.itAcademy.finalProject.Domain.Entity.Employee;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Jubilee {

    /**
     * This method finds out which of employees has an jubilee in the current year and  prints them
     * @param list
     */
    public void jubileeFind(List<Employee> list){

        Date currentDate = new Date();
        int currentYear = currentDate.getYear()+ 1900;
        int count = 0;

        System.out.println("Список юбиляров в " + currentYear + " году");
        for(Employee person : list){
            Date date = person.getDateOfBirth();
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(date);

            int year = gc.get(GregorianCalendar.YEAR);
            int ageYears = currentYear - year;

            if (ageYears%10 == 0 ){
                Employee.printEmployee(person);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("В " + currentYear + " году юбиляров нет.");
        }
    }
}
