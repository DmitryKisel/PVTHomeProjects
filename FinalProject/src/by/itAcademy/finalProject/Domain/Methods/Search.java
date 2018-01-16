package by.itAcademy.finalProject.domain.methods;

import by.itAcademy.finalProject.domain.entity.Employee;

import java.io.IOException;
import java.util.List;


public abstract class Search {
    public abstract void searchTool (List<Employee> list) throws IOException;
}