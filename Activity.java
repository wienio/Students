/**
 * Created by Wienio on 2017-03-08.
 */
import java.util.HashSet;
import java.util.Set;

public class Activity {
    private String name;
    private Set<Student> assignedStudents = new HashSet<>();

    public Activity(String name) {
        this.name = name;
    }

    public Set<Student> getAssignedStudents() {
        return assignedStudents;
    }
}
