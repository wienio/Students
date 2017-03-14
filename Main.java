/**
 * Created by Wienio on 2017-03-08.
 */
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    Queue<Student> queue = new ArrayDeque<>();
    Stack <Student> stack = new Stack<>();
    HashMap<StudentType,Integer> map = new HashMap<>();
    University admin = new University();   // administrator
        admin.addStudent("Tymek","Paluch",StudentType.STATIONARY);
        admin.addStudent("Kamil","Wieniecki",StudentType.STATIONARY);
        admin.addStudent("Jan","Janowski",StudentType.STATIONARY);
        admin.addStudent("Adam","Adamski",StudentType.NONSTATIONARY);
        admin.addActivity("Programowanie");
        admin.addActivity("C++");
        admin.assignStudent(admin.getStudentsList().get(0),admin.getStudentsActivity().get(0));
        admin.assignStudent(admin.getStudentsList().get(0),admin.getStudentsActivity().get(1));
        admin.assignStudent(admin.getStudentsList().get(1),admin.getStudentsActivity().get(0));
        admin.assignStudent(admin.getStudentsList().get(1),admin.getStudentsActivity().get(1));
     //   admin.removeStudent(admin.getStudentsList().get(0));

        admin.printStudentsSorted();

        queue = admin.studentsWithoutActivities();
        stack = admin.assignedStudentsForNActivties(10);
        if (admin.ifStudentsAssignedToThisSame(admin.getStudentsActivity().get(0),admin.getStudentsActivity().get(1))) {
            System.out.println("Brak takiego studenta, ktory bylby przypisany do obu zajec!");
        }
        else {
            System.out.println("Wystepuje student przypisany do obu podanych zajec!");
        }

        Student s1 = admin.maxActivities();
        System.out.println(s1);
        map=admin.studentsAmountOfType();

        System.out.println(map.get(StudentType.STATIONARY));
        System.out.println(map.get(StudentType.NONSTATIONARY));
    }
}
