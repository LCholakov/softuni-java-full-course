package Week2_Streams_Files_And_Directories.Exer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {
        String inPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";

        String fileContent = Files.readString(Path.of(inPath)).replaceAll("\\s+", "");

        Set<Character> vowels = new HashSet<>();
        // add a bunch of elements to a set
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, '!', ',', '.', '?');

        int vowelCount = 0;
        int punctuationCount = 0;
        int otherCount = 0;

        for (char c : fileContent.toCharArray()) {
            if(vowels.contains(c)) {
                ++vowelCount;
            } else if (punctuation.contains(c)) {
                ++punctuationCount;
            } else {
                ++otherCount;
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPath));
        bufferedWriter.write("Vowels: " + vowelCount);
        bufferedWriter.newLine();
        bufferedWriter.write("Other symbols: " + otherCount);
        bufferedWriter.newLine();
        bufferedWriter.write("Punctuation: " + punctuationCount);
        bufferedWriter.close();
    }
}
