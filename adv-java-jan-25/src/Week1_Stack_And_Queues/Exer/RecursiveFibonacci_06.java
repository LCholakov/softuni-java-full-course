package Week1_Stack_And_Queues.Exer;

import java.util.Scanner;

public class RecursiveFibonacci_06 {

    private static long[] computedFibs;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        computedFibs = new long[n + 1];
        System.out.println(getFib(n));
    }

    private static long getFib(int n) {
        if (n < 2) {
            return 1;
        }
        if (computedFibs[n] != 0) {
            return computedFibs[n];
        }
        long thisfib = getFib(n - 1) + getFib(n - 2);
        computedFibs[n] = thisfib;
        return thisfib;
    }
}
