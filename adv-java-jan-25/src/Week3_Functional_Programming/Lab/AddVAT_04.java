package Week3_Functional_Programming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        UnaryOperator<Double> addVat = v -> v * 1.2;

        List<Double> dList = Arrays.stream(scan.nextLine().split(", "))
                .map(Double::parseDouble)
                .toList();
        System.out.println("Prices with VAT:");
        dList.forEach(d -> System.out.printf("%.2f%n", addVat.apply(d)));
    }
}
