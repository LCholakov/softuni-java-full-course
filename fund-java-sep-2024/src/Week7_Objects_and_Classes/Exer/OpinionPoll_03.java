package Week7_Objects_and_Classes.Exer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class OpinionPoll_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // solution without class to upload only code to alphajudge, without dealing with multiple files
        LinkedHashMap<String, Integer> personMap = new LinkedHashMap<>();
        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String[] input = scan.nextLine().split(" ");
            personMap.put(input[0], Integer.parseInt(input[1]));
        }

        for(Map.Entry<String, Integer> entry : personMap.entrySet()) {
            if (entry.getValue() > 30) {
                System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
