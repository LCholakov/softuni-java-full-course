package Week11_Exam_Prep.Thu;

import java.util.Scanner;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder msg = new StringBuilder(scan.nextLine());

        String[] cmd = scan.nextLine().split("\\|");
        while (!cmd[0].equals("Decode")) {
            switch (cmd[0]) {
                case "Move" -> {
                    int n = Integer.parseInt(cmd[1]);
                    msg.append(msg, 0, n);
                    msg.replace(0, n, "");
//                    System.out.println(msg);
                }
                case "Insert" -> {
                    msg.insert(Integer.parseInt(cmd[1]), cmd[2]);
//                    System.out.println(msg);
                }
                case "ChangeAll" -> {
                    String substr = cmd[1];
                    while (msg.indexOf(substr) != -1) {
                        int iBegin = msg.indexOf(substr);
                        int iEnd = msg.indexOf(substr) + substr.length();
                        msg.replace(iBegin, iEnd, cmd[2]);
                    }
//                    System.out.println(msg);
                }
            }
            cmd = scan.nextLine().split("\\|");
        }
        System.out.println("The decrypted message is: " + msg);
    }
}
