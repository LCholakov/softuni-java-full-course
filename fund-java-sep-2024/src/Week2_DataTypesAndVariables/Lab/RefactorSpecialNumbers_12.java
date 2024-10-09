package Week2_DataTypesAndVariables.Lab;

import java.util.Scanner;

public class RefactorSpecialNumbers_12
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int rangeLimit = Integer.parseInt(scanner.nextLine());
        int digitSum = 0;
        int tempi = 0;
        boolean isSpecialNum = false;
        for (int i = 1; i <= rangeLimit; i++) {
            tempi = i;
            while (tempi > 0) {
                digitSum += tempi % 10;
                tempi = tempi / 10;
            }
            isSpecialNum = (digitSum == 5) || (digitSum == 7) || (digitSum == 11);
            if(isSpecialNum) {
                System.out.println(i + " -> True");
            }
            else {
                System.out.println(i + " -> False");
            }
            digitSum = 0;
        }

    }
}
