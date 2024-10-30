package Week8_Maps_Lambda_Stream.Lab;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordSynonyms_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // replace with linked map
        TreeMap<String, String> synonMap = new TreeMap<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String word = scan.nextLine();
            String synonym = scan.nextLine();
            if (synonMap.containsKey(word)) {
                String synonList = synonMap.get(word);
                synonMap.put(word, synonList + ", " + synonym);
                // synonMap.compute(word, (k, synonList) -> synonList + ", " + synonym);
            } else {
                synonMap.put(word, synonym);
            }
        }

        for(Map.Entry<String, String> entry : synonMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
