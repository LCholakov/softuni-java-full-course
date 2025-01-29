package Week2_Streams_Files_And_Directories.Exer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles_07 {
    public static void main(String[] args) throws IOException {
        String text1Path = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String text2Path = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";
        String outPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";

        List<String> text1LinesList = Files.readAllLines(Path.of(text1Path));
        List<String> text2LinesList = Files.readAllLines(Path.of(text2Path));

        BufferedWriter buffWriter = new BufferedWriter(new FileWriter(outPath));

        text1LinesList.forEach(line -> {
            try {
                buffWriter.write(line);
                buffWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        text2LinesList.forEach(line -> {
            try {
                buffWriter.write(line);
                buffWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buffWriter.close();
    }
}
