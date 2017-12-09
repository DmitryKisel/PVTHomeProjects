package by.itacademy.Lesson9.Task2;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {


        Student student = (Student) o;


        return this.name.equals(student.getName());
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override// if only one way of sort
    public int compareTo(Student o) {
       if (this.age == o.age && this.name.compareTo(o.name) == 0) {return 0;}
       else if (this.name.compareTo(o.name) == 1) {return 1;}

    return -1;
   }


}
