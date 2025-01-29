package Week2_Streams_Files_And_Directories.Exer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {
        String inPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        List<String> linesList = Files.readAllLines(Path.of(inPath));
        linesList.stream()
                        .map(line -> line.toCharArray()) // or method ref .map(String::toCharArray)
                                .forEach(arr -> {
                                    int sum = 0;
                                    for (char c : arr) {
                                        sum += c;
                                    }
                                    System.out.println(sum);
                                });

    }
}
