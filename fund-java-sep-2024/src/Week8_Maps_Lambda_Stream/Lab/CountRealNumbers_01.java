package Week8_Maps_Lambda_Stream.Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double[] numsArr = Arrays
                        .stream(scan.nextLine().split(" "))
                        .mapToDouble(e -> Double.parseDouble(e)).toArray();

        TreeMap<Double, Integer> counterMap = new TreeMap<>();

        for (double num : numsArr) {
            if (counterMap.containsKey(num)) {
                counterMap.put(num, counterMap.get(num) + 1);
            } else {
                counterMap.put(num, 1);
            }
        }

        for(Map.Entry<Double, Integer> entry : counterMap.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}
