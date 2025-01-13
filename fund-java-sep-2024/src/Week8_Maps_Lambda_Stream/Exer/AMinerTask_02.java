package Week8_Maps_Lambda_Stream.Exer;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine().toLowerCase();

        LinkedHashMap<String, Integer> rsrcMap = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            if (rsrcMap.containsKey(input)) {
                rsrcMap.put(input, rsrcMap.get(input) + Integer.parseInt(scan.nextLine()));
            } else {
                rsrcMap.put(input, Integer.parseInt(scan.nextLine()));
            }
            input = scan.nextLine().toLowerCase();
        }

        for(Map.Entry<String, Integer> entry : rsrcMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
