package Week2_DataTypesAndVariables.Exer;

import java.util.Scanner;

public class PokeMon_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int nTemp = n;
        int m = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        while (m <= nTemp) {
            nTemp -= m;
            ++counter;
            if (nTemp == n * 0.5 && y != 0) {
                nTemp /= y;
            }
        }
        System.out.println(nTemp);
        System.out.println(counter);
    }
}
