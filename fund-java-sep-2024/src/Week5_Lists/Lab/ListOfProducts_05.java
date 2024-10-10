package Week5_Lists.Lab;

import java.util.*;

public class ListOfProducts_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> productsList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            productsList.add(scanner.nextLine());
        }
        Collections.sort(productsList);

        for (int i = 0; i < productsList.size(); i++) {
            System.out.println((i + 1) + "." + productsList.get(i));
        }
    }
}
