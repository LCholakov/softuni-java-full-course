package Week8_Maps_Lambda_Stream.Exer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // should do it with a class, this is a bit stupid
        LinkedHashMap<String, ArrayList<String>> orderMap = new LinkedHashMap<>();
        String[] input = scan.nextLine().split(" ");
        while (!input[0].equals("buy")) {
            String item = input[0];

//            if (orderMap.containsKey(item)) {
//                orderMap.put(item, orderMap.get(item) + price * qty);
//            } else {
//                orderMap.put(item, price * qty);
//            }

            input = scan.nextLine().split(" ");
        }

//        for(Map.Entry<String, Double> entry : orderMap.entrySet()) {
//            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
//        }
    }
}
