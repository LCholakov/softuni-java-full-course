package Week3_Functional_Programming.Exer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> nList = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList().reversed();
        int divisor = Integer.parseInt(scan.nextLine());
        nList = nList.stream().filter(n -> n % divisor != 0).toList();

        System.out.println(nList.toString().replaceAll("[\\[\\],]", ""));
    }
}
