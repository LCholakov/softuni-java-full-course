package Week7_Objects_and_Classes.Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(getFactorial(Integer.parseInt(scan.nextLine())));
    }

    private static BigInteger getFactorial(int n) {
        BigInteger result = new BigInteger(String.valueOf(1));
        for (int i = 2; i <= n; i++)
        {
            result = result.multiply(BigInteger.valueOf(i));
//            result = result.multiply(BigInteger.valueOf(Integer.parseInt(String.valueOf(i))));
        }
        return result;
    }
}
