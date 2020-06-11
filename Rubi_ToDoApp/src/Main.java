import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Main {
    /*
    javac ISave.java  Main.java ToDo.java Task.java
    java Main -l
    */
    public static void main(String[] args) throws IOException {
        ToDo toDo = initToDoApp ();
        inputHandling ( args, toDo );


    }

    private static void inputHandling(String[] args, ToDo toDo) throws IOException {
        if (args.length < 1) {
            printUsage ();
        } else {
            switch (args[0]) {
                case "-l":
                    if (toDo.taskStringList.isEmpty ()) {
                        System.out.println ( "Nothing to do for today" );
                    } else {
                        for (String s : toDo.taskStringList) {
                            System.out.println ( s );
                        }
                    }
                    break;
                case "-a":
                    if (args.length < 3) {
                        System.out.println ( "Unable to add: no task provided" );
                        System.out.println ( "But I can Help You" );
                        createAndSaveTask ( toDo );
                    } else if (args.length == 3) {
                        toDo.taskStringList.add ( new Task ( false, args[1], args[2] ).toString () );
                        toDo.saveToFile ();
                        System.out.println ( toDo.taskStringList );
                    } else {
                        System.out.println ( "Too many arguments" );
                    }
                    break;
                case "-r":
                    if (args.length < 2) {
                        System.out.println ( "Unable to do your request" );
                        System.out.println ( "but I can help you" );
                        toDo.removeTaskAt2 ();
                    } else if (args.length == 2) {
                        System.out.println ( "this task will be removed" );
                        System.out.println ( toDo.taskStringList.get ( Integer.parseInt ( args[1] ) ) );
                        toDo.removeTaskAt ( Integer.parseInt ( args[1] ) );
                    } else {
                        System.out.println ( "Too many arguments" );
                    }
                    break;
                case "-c":
                    if (args.length < 2) {
                        System.out.println ( "Unable to do your request" );
                    } else if (args.length == 2) {
                        if (Integer.parseInt ( args[1] ) > toDo.taskStringList.size ()) {
                            System.out.println ( "there are just this number of tasks:" + toDo.taskStringList.size () );
                        } else {
                            System.out.println ( toDo.taskStringList.get ( Integer.parseInt ( args[1] ) ) );
                        }
                    } else {
                        System.out.println ( "Too many arguments" );
                    }
                    break;
                default:
                    System.out.println ( "Unsupported argument" );
                    printUsage ();
            }


        }
    }

    private static ToDo initToDoApp() throws IOException {
        Path filePath = Paths.get ( "C:\\Users\\Anirr\\OneDrive\\Plocha\\GitHub\\Rubi_handle-todo-app\\Rubi_ToDoApp\\tasksText.txt" );
        List < String > lines = Files.readAllLines ( filePath );
        ToDo toDo = new ToDo ( lines );
        for (int i = 0; i < toDo.taskStringList.size (); i++) {
            if (toDo.taskStringList.get ( i ).isBlank ()) {
                toDo.taskStringList.remove ( i );
            }
        }
        return toDo;
    }

    private static void printCheck(ToDo toDo) {
        int count = 1;
        for (String s : toDo.taskStringList) {
            count++;
            System.out.println ( s );
        }
    }

    private static void createAndSaveTask(ToDo toDo) throws IOException {
        toDo.taskStringList.add ( Task.createNewTask () );
        toDo.saveToFile ();
    }

    private static void TryFileExistence() {
        try {
            File myFile = new File ( "tasksText.txt" );
            if (myFile.createNewFile ()) {
                System.out.println ( "File created: " + myFile.getName () );
            } else {
                System.out.println ( "This File already exists" );
            }

        }
        catch ( IOException ioe ) {
            System.out.println ( "Some Error" );
            ioe.printStackTrace ();
            ioe.getMessage ();
        }
    }

    public static void printUsage() {
        System.out.println ( "Command line ToDo application" );
        System.out.println ( "=============================" );
        System.out.println ( "Command line arguments:" );
        System.out.println ( "                       -l List all the tasks" );
        System.out.println ( "                       -a Adds new task" );
        System.out.println ( "                       -r Removes task" );
        System.out.println ( "                       -c Completes task" );
    }
}
