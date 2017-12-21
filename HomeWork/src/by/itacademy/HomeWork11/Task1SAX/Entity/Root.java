package HomeWork11.Entity;

import java.util.List;

public class Root {
    private String name;
    private List<People> peopleList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Root root = (Root) o;

        if (!name.equals(root.name)) return false;
        return peopleList.equals(root.peopleList);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + peopleList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", peopleList=" + peopleList +
                '}';
    }
}
