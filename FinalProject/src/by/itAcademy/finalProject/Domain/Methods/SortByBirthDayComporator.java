package by.itAcademy.finalProject.domain.methods;

import by.itAcademy.finalProject.domain.entity.Employee;

import java.util.Comparator;
import java.util.GregorianCalendar;

public class SortByBirthDayComporator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        GregorianCalendar gc1 = new GregorianCalendar();
        GregorianCalendar gc2 = new GregorianCalendar();
        gc1.setTime(o1.getDateOfBirth());
        gc2.setTime(o2.getDateOfBirth());

        int day1 = gc1.get(GregorianCalendar.DATE);
        int month1 = gc1.get(GregorianCalendar.MONTH);
        int year1 = gc1.get(GregorianCalendar.YEAR);

        int day2 = gc2.get(GregorianCalendar.DATE);
        int month2 = gc2.get(GregorianCalendar.MONTH);
        int year2 = gc2.get(GregorianCalendar.YEAR);

        if(year1 > year2) return  1;
        else if(year1 < year2) return -1;
        else if(month1 > month2) return  1;
        else  if(month1 <  month2) return  -1;
        else  if(day1 > day2) return  1;
        else  if (day1 < day2) return -1;
        else  return 0;
    }
}