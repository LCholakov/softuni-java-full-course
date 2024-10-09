package Week2_DataTypesAndVariables.Exer;

import java.util.Scanner;

public class SpiceMustFlow_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int drop = 10;
        int forWorkers = 26;
        int sum = 0;
        int counter = 0;

        while (n >= 100) {
            ++counter;
            sum += n;
            n -= drop;
        }

        sum -= forWorkers * (counter + 1);
        if (sum < 0)
            sum = 0;
        System.out.printf("%d%n%d", counter, sum);
    }
}
