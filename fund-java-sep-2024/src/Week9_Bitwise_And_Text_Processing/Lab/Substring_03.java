package Week9_Bitwise_And_Text_Processing.Lab;

import java.util.Scanner;

public class Substring_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();

        while (str2.indexOf(str1) != -1) {
            str2 = str2.replace(str1, "");
        }
        System.out.println(str2);
    }
}
