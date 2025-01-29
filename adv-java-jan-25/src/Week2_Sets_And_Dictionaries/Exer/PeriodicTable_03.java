package Week2_Sets_And_Dictionaries.Exer;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> chemElTree = new TreeSet<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String [] input = scan.nextLine().split("\\s+");
            chemElTree.addAll(Arrays.asList(input));
        }
        chemElTree.forEach(e -> System.out.print(e + " "));
    }
}
