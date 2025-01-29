package Week2_Streams_Files_And_Directories.Exer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {
        String wordsPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";
        String textPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";
        String outPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/results.txt";

        Map<String, Integer> wordCountMap = new HashMap<>();
        List<String> linesList = Files.readAllLines(Path.of(wordsPath));

        for (String line : linesList) {
            Arrays.stream(line.split("\\s+"))
                    .forEach(word -> {
                        wordCountMap.put(word, 0);
                    });
        }

        linesList = Files.readAllLines(Path.of(textPath));
        for (String line : linesList) {
            Arrays.stream(line.split("\\s+"))
                    .forEach(word -> {
                        if(wordCountMap.containsKey(word)) {
                            wordCountMap.put(word, wordCountMap.get(word) + 1);
                        }
                    });
        }

        PrintWriter printWriter = new PrintWriter(outPath);

        wordCountMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                        .forEach(entry -> printWriter.println(entry.getKey() + " - " + entry.getValue()));
        printWriter.close();
    }
}
