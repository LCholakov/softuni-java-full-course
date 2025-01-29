package Week2_Streams_Files_And_Directories.Exer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllCapitals_03 {
    public static void main(String[] args) throws IOException {
        String inPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";

        String updatedContent = Files.readString(Path.of(inPath));
        updatedContent = updatedContent.toUpperCase();

        BufferedWriter buffWriter = new BufferedWriter(new FileWriter(outPath));
        buffWriter.write(updatedContent);
        buffWriter.close();
    }
}
