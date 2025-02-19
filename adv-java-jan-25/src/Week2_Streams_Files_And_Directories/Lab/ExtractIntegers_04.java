package Week2_Streams_Files_And_Directories.Lab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) throws FileNotFoundException {
        String inputPath = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Week3_Functional_Programming.Week3_Defining_Clases.Week3_Generics.Week4_IteratorsAndComparators.Lab-Resources/input.txt";
        InputStream inputStream = new FileInputStream(inputPath);
        Scanner scan = new Scanner(inputStream);

        String outputPath = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Week3_Functional_Programming.Week3_Defining_Clases.Week3_Generics.Week4_IteratorsAndComparators.Lab-Resources/04.ExtractIntegersOutput.txt";

        PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath));

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                int nextInt = scan.nextInt();

                printWriter.flush();
                printWriter.write(String.valueOf(nextInt));

                printWriter.flush();
                printWriter.write(System.lineSeparator());

                System.out.println(nextInt);
            }
            scan.next();
        }
    }
}
