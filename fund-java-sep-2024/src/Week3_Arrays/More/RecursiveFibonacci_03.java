package Week3_Arrays.More;

import java.util.Scanner;

public class RecursiveFibonacci_03 {
    static int recursiveFibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(recursiveFibonacci(n));
    }
}
