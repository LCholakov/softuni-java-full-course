package Week3_Functional_Programming.Exer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> namesList = Arrays.stream(scan.nextLine().split("\\s+"))
                .toList();

        Consumer<String> consumerPrint = e -> System.out.println(e);

        namesList.forEach(consumerPrint);
    }
}
