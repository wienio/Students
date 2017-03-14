/**
 * Created by Wienio on 2017-03-08.
 */
import java.util.*;

public class University {
    private List <Student> studentsList = new ArrayList<>();
    private List <Activity> studentsActivity = new ArrayList<>();

    public void addStudent(String name, String surname, StudentType type) {
        studentsList.add(new Student(name,surname,type));
    }

    public void addActivity(String name) {
        studentsActivity.add(new Activity(name));
    }

    public void assignStudent (Student temp, Activity temp2) {
        temp2.getAssignedStudents().add(temp);
        temp.getActivities().add(temp2);
    }

    public void removeStudent (Student temp) {
            int j = 0;
            for ( Iterator<Activity> i = studentsActivity.iterator() ; i.hasNext() ; i.next() ) { // usuwa z przypisanych zajec
                Activity temp2 = studentsActivity.get(j);
                if (temp2.getAssignedStudents().contains(temp)) {
                    temp2.getAssignedStudents().remove(temp);
                }
                j++;
            }
        if (studentsList.contains(temp)) {   // usuwa z listy studentow na uniwersytecie
            studentsList.remove(temp);
            }
        if (studentsActivity.contains(temp)) {  // usuwa z zajec dla klasy student, w klasie uniwersytetu musi zostac dane zajecie
            temp.getActivities().clear();
            }
    }

    public void removeStudentWithID (int id) {
        int j=0;
        for (Iterator<Student> i = studentsList.iterator() ; i.hasNext() ; i.next() ) {  // petla do sprawdzenia czy student o takim id
            Student temp = studentsList.get(j);  // w ogole istnieje
            if (temp.getId() == id) {  // warunek, jesli znajdzie w systemie
                int k = 0;
                for ( Iterator<Activity> l = studentsActivity.iterator() ; l.hasNext() ; l.next() ) { // usuwa z przypisanych zajec
                    Activity temp2 = studentsActivity.get(k);
                    if (temp2.getAssignedStudents().contains(temp)) {
                        temp2.getAssignedStudents().remove(temp);
                    }
                    k++;
                }
                studentsList.remove(j); // usuwa z systemu
                temp.getActivities().clear();  // usuwa zajecia studenta
                return ;
            }
            j++;
        }
    }

    public void removeAllStudentsFromActivity(Activity temp) {
        temp.getAssignedStudents().clear();
        int j =0;
        for (Iterator<Student> i = studentsList.iterator() ; i.hasNext() ; i.next() ) {
            Student temp2= getStudentsList().get(j);
            temp2.getActivities().remove(temp);
            j++;
        }
    }

    public boolean isStudentAssignedToActivity (Student temp, Activity temp1) {
       if ( temp1.getAssignedStudents().contains(temp)) {
           return true;
       }
       return false;
    }

    public Queue<Student> studentsWithoutActivities () {
        Queue <Student> temporaryQueue = new ArrayDeque<Student>(); // kolejka pomocnicza, gdzie bede przepisywal a pozniej ja zwroce
        int j =0;
        for (Iterator<Student> i = studentsList.iterator() ; i.hasNext() ; i.next() ) {
            Student temp2 = studentsList.get(j);
            if (temp2.getActivities().size() == 0) {
                temporaryQueue.add(temp2);
            }
            j++;
        }
        return temporaryQueue;
    }

    public Stack<Student> assignedStudentsForNActivties (int n) {
        Stack<Student> temporaryStack = new Stack<>();
        int j =0;
        for (Iterator<Student> i = studentsList.iterator() ; i.hasNext() ; i.next() ) {
            Student temp = studentsList.get(j);
            if (temp.getActivities().size() == n) {
                temporaryStack.add(temp);
            }
            j++;
        }
        return temporaryStack;
    }

     public Student maxActivities () {
        return Collections.max(studentsList , (o1,o2) -> {
            if (o1.getActivities().size() > o2.getActivities().size()) {
                return 1;
            }
            else if (o1.getActivities().size() < o2.getActivities().size() ) {
                return -1;
            }
            return 0;
        });
    }


   public HashMap<StudentType, Integer> studentsAmountOfType () {
       HashMap<StudentType,Integer> temporaryMap = new HashMap<>();
       int stationary = 0 , nonstationary = 0, postgraduate = 0;
        for (int i = 0 ; i < studentsList.size() ; ++i ) {
            Student temporary = studentsList.get(i);
            if (temporary.getType() == StudentType.STATIONARY) {
                stationary++;
            }
            else if (temporary.getType() == StudentType.NONSTATIONARY) {
                nonstationary++;
            }
            else if (temporary.getType() == StudentType.POSTGRADUATE) {
                postgraduate++;
            }
        }
        temporaryMap.put(StudentType.STATIONARY,stationary);
        temporaryMap.put(StudentType.NONSTATIONARY,nonstationary);
        temporaryMap.put(StudentType.POSTGRADUATE,postgraduate);
        return temporaryMap;
   }

    public void printStudentsSorted () {
            Collections.sort(studentsList);
            int j = 0;
            System.out.println("Oto studenci posortowani alfabetycznie:");
            for (Iterator<Student> i = studentsList.iterator(); i.hasNext(); i.next()) {
                Student temp = studentsList.get(j);
                System.out.format("Student nazywa sie: %s %s (typ: %s)\n", temp.getName(), temp.getSurname(), temp.getType());
                j++;
            }
    }

    public boolean ifStudentsAssignedToThisSame (Activity temp1, Activity temp2) {
        return Collections.disjoint(temp1.getAssignedStudents(),temp2.getAssignedStudents());
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public List<Activity> getStudentsActivity() {
        return studentsActivity;
    }
}
