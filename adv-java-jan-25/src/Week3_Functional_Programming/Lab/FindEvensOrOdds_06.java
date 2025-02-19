package Week3_Functional_Programming.Lab;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FindEvensOrOdds_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] rangeInput = scan.nextLine().split("\\s+");
        int beginN = Integer.parseInt(rangeInput[0]);
        int endN = Integer.parseInt(rangeInput[1]);
        String cmd = scan.nextLine();

        int [] nArr = new int[endN - beginN + 1];

        for (int i = beginN; i <= endN; i++) {
            nArr[i - beginN] = i;
        }

        Predicate<Integer> tester = createTester(cmd);
        Consumer<Integer> printer = createPrinter();
        printFilteredNums(nArr, tester, printer);

    }

    static Consumer<Integer> createPrinter () {
        Consumer<Integer> printer = null;
        printer = n -> System.out.printf(n + " ");
        return printer;
    }

    static Predicate<Integer> createTester(String condition) {
        Predicate<Integer> tester = null;
        switch (condition) {
            case "even" -> tester = x -> x % 2 == 0;
            case "odd"  -> tester = x -> x % 2 != 0;
        }
        return tester;
    }

    static void printFilteredNums(
            int [] nArr,
            Predicate<Integer> tester,
            Consumer<Integer> printer) {
        for (int n : nArr) {
            if (tester.test(n)) {
                printer.accept(n);
            }
        }
    }
}
