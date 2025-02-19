package Week2_Sets_And_Dictionaries.Lab;

import java.util.*;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Double>> shopsMap = new TreeMap<>();

        String [] input = scan.nextLine().split(", ");
        while(!input[0].equals("Revision")) {
            String shop = input[0];
            String item = input[1];
            double price = Double.parseDouble(input[2]);

            if (!shopsMap.containsKey(shop)) {
//                List<Map<String, Double>> tempItemsList = new ArrayList<>();
//                tempItemsList.add(tempItemMap);
                Map<String, Double> tempItemMap = new LinkedHashMap<>();
                tempItemMap.put(item, price);

                shopsMap.put(shop, tempItemMap);
            } else {
                shopsMap.get(shop).put(item, price);
            }


            input = scan.nextLine().split(", ");
        }
        shopsMap.forEach((shop, itemList) -> {
            System.out.println(shop + "->");
            itemList.forEach((item, price) -> {
                System.out.printf("Product: %s, Price: %.1f%n", item, price);
            });
        });
    }
}
