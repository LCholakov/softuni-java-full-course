package Week3_Functional_Programming.Lab;

import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sum = 0;
        String [] strArr = scan.nextLine().split(", ");

        Function<String, Integer> parseInt = Integer::parseInt;

        for (String s : strArr) {
            sum += parseInt.apply(s);
        }
        System.out.println("Count = " + strArr.length);
        System.out.println("Sum = " + sum);
    }
}
