package by.itacademy.lesson18.task2;

public interface MyCollectionContract <Department, Staff> {

    void setDirector(Staff director);

    Staff getDirector();

    void removeDirector();

    void addDepartment (Department department);
    void removeDepartment(Department department);

    void addStaff (Staff staff, Department department);
    void removeStaff(Staff staff, Department department);
    void moveStaff(Staff staff, Department departmentOut, Department departmentIn);

}
