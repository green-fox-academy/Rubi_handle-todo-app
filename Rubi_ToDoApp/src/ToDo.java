import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ToDo implements ISave{
    List < Task > taskList;
    List<String>taskStringList;

 // public ToDo(List < Task > taskList) {
 //     this.taskList = taskList;
 //     this.taskStringList=new ArrayList<String>();
 // }
    public ToDo(List<String> taskStringList){
        this.taskStringList=taskStringList;
    this.taskList= new ArrayList <> ();}

    public void removeTaskAt(int in){
 this.taskStringList.remove ( in );
       // this.taskList.remove( taskList.get ( in ) );
    }
    public void removeTaskAt2() throws IOException {
        Scanner scanner = new Scanner ( System.in );
        System.out.println ("give me number index of task you want to delete");
        int in=scanner.nextInt ();
        this.taskStringList.remove ( in );
        this.saveToFile ();
      //  this.taskList.remove ( taskList.get ( in ) );
    }
    @Override
    public void saveToFile() throws IOException {
   var write = Files.write ( Paths.get ( "C:\\Users\\Anirr\\OneDrive\\Plocha\\GitHub\\Rubi_handle-todo-app\\Rubi_ToDoApp\\tasksText.txt" ), this.taskStringList );

    }
}
