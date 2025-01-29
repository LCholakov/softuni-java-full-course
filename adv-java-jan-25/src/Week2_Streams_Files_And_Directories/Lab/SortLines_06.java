package Week2_Streams_Files_And_Directories.Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class SortLines_06 {
    public static void main(String[] args) throws IOException {
        String inputPath = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Week3_Functional_Programming.Week3_Defining_Clases.Lab-Resources/input.txt";
        String outputPath = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Week3_Functional_Programming.Week3_Defining_Clases.Lab-Resources/06.SortLinesOutput.txt";

        List<String> linesList = Files.readAllLines(Path.of(inputPath));
        Collections.sort(linesList);

        Files.write(Path.of(outputPath), linesList);
    }
}
