package Week2_Streams_Files_And_Directories.Exer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {
        String inPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        String outPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";

        List<String> linesList = Files.readAllLines(Path.of(inPath));

        BufferedWriter buffWriter = new BufferedWriter(new FileWriter(outPath));

        for (int i = 0; i < linesList.size(); i++) {
            buffWriter.write((i + 1) + ". " + linesList.get(i));
            buffWriter.newLine();
        }
        buffWriter.close();

    }
}
