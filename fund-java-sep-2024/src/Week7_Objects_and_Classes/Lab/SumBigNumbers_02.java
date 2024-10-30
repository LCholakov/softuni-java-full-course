package Week7_Objects_and_Classes.Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BigInteger n1 = new BigInteger(scan.nextLine());
        BigInteger n2 = new BigInteger(scan.nextLine());
        System.out.println(n1.add(n2));
    }
}
