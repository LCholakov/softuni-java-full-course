package Week8_Maps_Lambda_Stream.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OddOccurrences_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] strArr = scan.nextLine().toLowerCase().split(" ");

        LinkedHashMap<String, Integer> wCounter = new LinkedHashMap<>();

        for (int i = 0; i < strArr.length; i++) {
            if (wCounter.containsKey(strArr[i])) {
                int n = wCounter.get(strArr[i]) + 1;
                wCounter.put(strArr[i], n );
            } else {
                wCounter.put(strArr[i], 1);
            }
        }

        String result = "";
        for(Map.Entry<String, Integer> entry : wCounter.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                result = result + ", " + entry.getKey();
            }
        }
        result = result.replaceFirst(", ", "");
        System.out.println(result);
    }
}
