package Week9_Bitwise_And_Text_Processing.Lab;

import java.util.Scanner;

public class ReverseStrings_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String output = "";
        while (!input.equals("end")) {
            for (int i = input.length() - 1; i >= 0; i--) {
                output = output + input.charAt(i);
            }
            System.out.println(input.concat(" = ").concat(output));
            output = "";
            input = scan.nextLine();
        }
    }
}
