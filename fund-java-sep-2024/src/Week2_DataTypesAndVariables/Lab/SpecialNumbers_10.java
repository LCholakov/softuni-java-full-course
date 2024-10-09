package Week2_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class SpecialNumbers_10
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        byte n = Byte.parseByte(scanner.nextLine());

        for (int i = 1; i <= n; i++)
        {
            int tempi = i;
            short digitSum = 0;
            while (tempi > 0) {
                digitSum += tempi % 10;
                tempi /= 10;
            }
            if (digitSum == 5 || digitSum == 7 || digitSum == 11) {
                System.out.println(i + " -> True");
            }
            else {
                System.out.println(i + " -> False");
            }
        }
    }
}
