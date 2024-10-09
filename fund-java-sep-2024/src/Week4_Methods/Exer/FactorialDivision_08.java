package Week4_Methods.Exer;

import java.util.Scanner;

public class FactorialDivision_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        divide2Factorials(Integer.parseInt(scanner.nextLine())
                        , Integer.parseInt(scanner.nextLine()));
    }

    private static void divide2Factorials(int a, int b) {
        System.out.printf("%.2f", 1.0 * getFactorial(a) / getFactorial(b));
    }

    private static long getFactorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++)
        {
            result *= i;
        }
//        System.out.println(result);
        return result;
    }
}
