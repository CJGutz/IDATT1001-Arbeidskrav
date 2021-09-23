class Student{
    private final String name; 
    private int tasksCompleted;

    public Student(String name, int tasksCompleted) {
        this.name = name;
        this.tasksCompleted = tasksCompleted;
    }

    public String getName() {
        return name;
    }
    
    public int getTasksCompleted() {
        return tasksCompleted;
    }
    
    public void increaseTasksCompleted(int increase) { 
        tasksCompleted += increase;
    }

    public String toString() {
        return name + ", " + tasksCompleted;
    }
    
 
}
