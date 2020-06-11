import java.util.Scanner;

public class Task implements ISave {
    private static Integer idCount = 0;
    private final Integer id;
    private final boolean isCompleted;
    private final String name;
    private final String description;


    public Task(boolean isCompleted, String name, String description) {
        this.id = idCount + 1;
        this.isCompleted = isCompleted;
        this.name = name;
        this.description = description;
        idCount++;
    }

    public static String createNewTask() {
        Scanner scanner = new Scanner ( System.in );
        System.out.println ( "give me name" );
        String name = scanner.nextLine ();
        System.out.println ( "give me description" );
        String description = scanner.nextLine ();
        Task input = new Task ( false, name, description );
        return input.toString ();
    }

    public Integer getId() {
        return id;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[X]" : "[ ]") + " Task: " + name + " Description: " + description + "\n";
    }

    @Override
    public void saveToFile() {

    }
}
