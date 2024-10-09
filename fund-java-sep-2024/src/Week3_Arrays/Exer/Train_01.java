package Week3_Arrays.Exer;

import java.util.Scanner;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int [] trainArr = new int[n];
        for (int i = 0; i < n; i++) {
            trainArr[i] = Integer.parseInt(scanner.nextLine());
            sum += trainArr[i];
        }

        for (int num : trainArr) {
            System.out.print(num + " ");
        }
        System.out.printf("%n%d", sum);
    }
}
