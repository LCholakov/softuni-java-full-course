package Week2_Streams_Files_And_Directories.Lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) {
        String inputPath = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Week3_Functional_Programming.Week3_Defining_Clases.Week3_Generics.Week4_IteratorsAndComparators.Lab-Resources/input.txt";
        String outputPath = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Week3_Functional_Programming.Week3_Defining_Clases.Week3_Generics.Week4_IteratorsAndComparators.Lab-Resources/05.WriteEveryThirdLineOutput.txt";


        try  (
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath))
                BufferedReader buffReader = Files.newBufferedReader(Path.of(inputPath));
                BufferedWriter buffWriter = Files.newBufferedWriter(Path.of(outputPath))
            ) {
            String line = buffReader.readLine();

            int counter = 0;
            while (line != null) {
                ++counter;
                if (counter % 3 == 0) {
                    buffWriter.write(line);
                    buffWriter.newLine();
                }
                line = buffReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
