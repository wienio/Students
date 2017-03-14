/**
 * Created by Wienio on 2017-03-08.
 */
import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private int id;
    private String name,surname;
    private StudentType type;
    List <Activity> activities = new ArrayList<>();
    static int helperForID = 1234;

    public Student(String name, String surname, StudentType type) {
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.id=helperForID++;
    }

    @Override
    public int compareTo(Student o) {
        int compareSurname = surname.compareTo(o.surname);
        if (compareSurname == 0 ) {
            return name.compareTo(o.name);
        }
        else {
            return compareSurname;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", type=" + type +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public StudentType getType() {
        return type;
    }

    public List<Activity> getActivities() {
        return activities;
    }
}
