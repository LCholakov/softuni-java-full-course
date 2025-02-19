import Week3_Defining_Clases.Lab.Car;

import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main2 {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//
//            // Class notes and hacks:
//            // SETS AND DICTIONARIES = ONLY UNIQUE VALS
////            Set<Integer> nums = new HashSet<>(); -> not sorted
////            Set<Integer> nums = new TreeSet<>(); -> sorted in ascending order
////            Set<Integer> nums = new LinkedHashSet<>(); -> sorted in addition order
//
////            Diff with lists: if we add an element that exits -> operation will be skipped, no element will be added.
////            there is no method get
//
//            // files and streams
//
//            // READING
//            String inputPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
//            // read via scanner
//            Scanner scanner = new Scanner(new File(inputPath));  // alt enter -> add exception
//            System.out.println(scanner.nextLine());
//
//            // buffered Reader
//            BufferedReader buffReader = new BufferedReader((new FileReader(inputPath)));
//            System.out.println(buffReader.readLine()); // alt enter -> add exception - upgrades the exception
//
//            // FileReader in an array of lines
//            List<String> lines = Files.readAllLines(Path.of(inputPath));
//            System.out.println(lines.get(0));
//
//            // File
//            String fullContent = Files.readString(Path.of(inputPath));
//
//            // WRITING
//            String outputPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";
//            // PrintWriter
//            PrintWriter printWriter = new PrintWriter(outputPath);
//            printWriter.println("Hello World!");
//            printWriter.close(); // always close the writer
//
//            // BufferedWriter
//            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(outputPath));
//            buffWriter.write("Hello World!");
//            buffWriter.close();
//
//            // FileWriter
//            FileWriter fileWriter = new FileWriter(outputPath);
//            fileWriter.write("Hello World!");
//            fileWriter.close();


            // Functional vs imperative.
            // imperative - describe everything.
            // functional - use lambdas.

            // predicate -> receives an arg -> returns bool
            // Consumer -> receives an arg -> no return val
            // Function -> receives an arg -> perform an action -> return result

            // Supplier -> () no args-> perform an action -> returns a result
            // BiFunction -> arg1, arg2 -> perform action with 2args -> returns a result (eg concatenation)
//        }


        Scanner scan = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String [] input = scan.nextLine().split("\\s+");
            if (input.length == 1) {
                cars.add(new Car(input[0]));
            } else {
                cars.add(new Car(input[0], input[1], Integer.parseInt(input[2])));
            }
        }

        cars.forEach(car -> System.out.println(car.carInfo()));


        // class feedback
        // 4d is a bit much. Before at 3 I had time to also solve all optional exer and also "More" exercises
        // now I don't have time for all the mandatory even. I feel lagging behind.
        // staying past 10pm is getting tough, since I work from 7 am and have to eat.
        // Yulian is great, but often extends to 10:30, 10:40
        // Kaloyan is good when he has prepared. But if he solves on the fly it's not very efficient.
    }
}