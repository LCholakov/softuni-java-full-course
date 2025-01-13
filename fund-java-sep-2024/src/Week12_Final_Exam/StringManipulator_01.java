package Week12_Final_Exam;

import java.util.Scanner;

public class StringManipulator_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = 10;
        double b = 5.5;
        a += b;
        System.out.println(a);

        String str = scan.nextLine();

        String[] cmd = scan.nextLine().split(" ");
        while (!cmd[0].equals("End")) {
            switch  (cmd[0]) {
                case "Translate" -> {
                    str = str.replace(cmd[1].charAt(0), cmd[2].charAt(0));
                    System.out.println(str);
                }
                case "Includes" -> {
                    if(str.contains(cmd[1]))
                        System.out.println("True");
                    else
                        System.out.println("False");
                }
                case "Start" -> {
                    if(str.startsWith(cmd[1]))
                        System.out.println("True");
                    else
                        System.out.println("False");
                }
                case "Lowercase" -> {
                    str = str.toLowerCase();
                    System.out.println(str);
                }
                case "FindIndex" -> {
                    System.out.println(str.lastIndexOf(cmd[1].charAt(0)));
                }
                case "Remove" -> {
                    int idxBegin = Integer.parseInt(cmd[1]);
                    int len = Integer.parseInt(cmd[2]);
                    str = str.substring(0, idxBegin) + str.substring(idxBegin + len);
                    System.out.println(str);
                }
            }
            cmd = scan.nextLine().split(" ");
        }
    }
}
