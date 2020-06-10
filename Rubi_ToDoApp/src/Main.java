public class Main {

    public static void main(String[] args) {
	if (args.length<1){printUsage();}
    }
    public static void printUsage(){
        System.out.println ("Command line ToDo application");
        System.out.println ("=============================");
        System.out.println ("Command line arguments:");
        System.out.println ("                       -l List all the tasks");
        System.out.println ("                       -a Adds new task");
        System.out.println ("                       -r Removes task");
        System.out.println ("                       -c Completes task");
    }
    }
