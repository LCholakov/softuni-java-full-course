package Week2_Sets_And_Dictionaries.Lab;

import java.util.*;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double [] realNums = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> map = new LinkedHashMap<>();

        for (double realNum : realNums) {
//            if (map.containsKey(realNum)) {
//                int key = map.get(realNum) + 1;
//                map.put(realNum, key);
//            } else {
//                map.put(realNum, 1);
//            }
            map.putIfAbsent(realNum, 0);
            map.put(realNum, map.get(realNum) + 1);
        }

        map.forEach((k, v) -> System.out.printf("%.1f -> %d%n", k, v));

    }
}
