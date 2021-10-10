import java.util.ArrayList;
// Hashmaps

class TaskOverview {

    private Student[] students;
    private int nrOfStudents;

    public TaskOverview() {
        students = new Student[0]; // tar mye minne med predefinert høyt tall
        nrOfStudents = 0;
    }

    public void addStudent(String name, int tasksCompleted) {
        Student student = new Student(name, tasksCompleted);

        students = addX(nrOfStudents, students, student);
        nrOfStudents++;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getNrOfStudents() {
        return nrOfStudents;
    }

    public int tasksCompletedBy(String name) {
        for (int i = 0; i < nrOfStudents; i++) {
            if (students[i].getName().equals(name)) {
                return students[i].getTasksCompleted();
            } else {
                return 0;
            }  
        }
        return 0;
    }

    public void increaseTasksCompletedBy(Student student, int increase) {
        for (int i = 0; i < nrOfStudents; i++) {
            if (students[i].equals(student)) {
                students[i].increaseTasksCompleted(increase);
            }
        }
    }

    public String toString(int i) {
        return students[i].getName() + " has completed " + students[i].getTasksCompleted() + " tasks";
    }

    public String print() {
        String studentsString = "";
        for (int i = 0; i < nrOfStudents; i++) {
            studentsString += ", ( " + students[i].toString() + " )";
        }
        return nrOfStudents + studentsString;
    }

    public static Student[] addX(int n, Student[] arr, Student x) {
        int i;
  
        Student newarr[] = new Student[n + 1];
  
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
  
        newarr[n] = x;
  
        return newarr;
    }
}