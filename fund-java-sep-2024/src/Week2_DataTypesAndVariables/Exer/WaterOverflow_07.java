package Week2_DataTypesAndVariables.Exer;

import java.util.Scanner;

public class WaterOverflow_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short n = Short.parseShort(scanner.nextLine());
        short capacity = 255;
        short sum = 0;
        for (short i = 0; i < n; i++) {
            short input = Short.parseShort(scanner.nextLine());
            if (sum + input > capacity)
                System.out.println("Insufficient capacity!");
            else
                sum += input;
        }
        System.out.println(sum);

    }
}
