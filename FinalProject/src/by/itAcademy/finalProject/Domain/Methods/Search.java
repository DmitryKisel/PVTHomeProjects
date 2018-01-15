package by.itAcademy.finalProject.Domain.Methods;

import by.itAcademy.finalProject.Domain.Entity.Employee;

import java.io.IOException;
import java.util.List;


public abstract class Search {
    public abstract void searchTool (List<Employee> list) throws IOException;
}