import java.util.*;

class Oppgave1{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        TaskOverview overview = new TaskOverview();

        boolean fortsett = true;
        while (fortsett) {
            System.out.println("\nMeny:");
            System.out.println("    1. Add student");
            System.out.println("    2. Show students:");
            System.out.println("    3. End:");
            System.out.print("[1/2/3]:  ");
 
            int input;
            try {
                input = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) { // InputMismatchException e
                System.out.println("Worng input --> returning 0...");
                input = 0;
            }

            if (input == 1) {

                System.out.print("Name: ");
                String name = in.nextLine();
                System.out.print("Tasks completed: ");
                int tasksCompleted;
                try {
                    tasksCompleted = Integer.parseInt(in.nextLine());
                } catch (NumberFormatException e) { // InputMismatchException e
                    System.out.println("Worng input --> returning 0...");
                    tasksCompleted = 0;
                }

                overview.addStudent(name, tasksCompleted);

            } else if (input == 2) {  // Print ut og endre studenter
                if (overview.getNrOfStudents() == 0) {
                    System.out.println("\nNo students to show");
                } else {
                    System.out.println("\n"); // Print ut
                    System.out.println("There are " + overview.getNrOfStudents() + " students.");
                    for (int i = 0; i < overview.getNrOfStudents(); i++) {
                        System.out.println(overview.toString(i));
                    }

                    System.out.println("\nChoose student:");
                    String name = in.nextLine().toLowerCase(); // Velg student

                    for (int i = 0; i < overview.getNrOfStudents(); i++) {
                        if (overview.getStudents()[i].getName().toLowerCase().equals(name)) {

                            System.out.print("Add number of completed tasks: ");
                            int addedTasks;
                            try {
                              addedTasks = Integer.parseInt(in.nextLine()); // Endre spesifikk student
                            } catch (NumberFormatException e) { // InputMismatchException e
                                System.out.println("Worng input --> returning 0...");
                                addedTasks = 0;
                            }

                            overview.increaseTasksCompletedBy(overview.getStudents()[i], addedTasks);                            

                        }
                    }

                }
            } else {
                System.out.println("Ended");
                fortsett = false;
            }
        }



    }
}