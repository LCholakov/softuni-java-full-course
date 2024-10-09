package Week3_Arrays.Lab;

import java.util.Scanner;

public class PrintNumbersInReverseOrder_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        short n = Short.parseShort(scanner.nextLine());
        short [] numArr = new short[n];

        for (short i = 0; i < n; i++) {
            numArr[i] = Short.parseShort(scanner.nextLine());
        }

        for (short i = (short) (numArr.length - 1); i >= 0; i--) {
            System.out.print(numArr[i] + " ");
        }
    }
}
