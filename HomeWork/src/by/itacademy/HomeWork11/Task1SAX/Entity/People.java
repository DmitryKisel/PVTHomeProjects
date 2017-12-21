package HomeWork11.Entity;

public class People{

    private int age;
    private int id;
    private boolean isDegree;
    private String name;
    private String surname;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDegree() {
        return isDegree;
    }

    public void setDegree(boolean degree) {
        isDegree = degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        if (age != people.age) return false;
        if (id != people.id) return false;
        if (isDegree != people.isDegree) return false;
        if (!name.equals(people.name)) return false;
        return surname.equals(people.surname);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + id;
        result = 31 * result + (isDegree ? 1 : 0);
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", id=" + id +
                ", isDegree=" + isDegree +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
