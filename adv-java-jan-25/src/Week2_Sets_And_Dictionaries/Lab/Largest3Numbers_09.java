package Week2_Sets_And_Dictionaries.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> nListSorted = Arrays
                .stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());

        for (int i = 0; i < Math.min(3, nListSorted.size()); i++) {
            System.out.print(nListSorted.get(i) + " ");
        }
    }
}
