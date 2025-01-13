package Week11_Exam_Prep.Wed;

import java.util.Scanner;

public class SecretChat_01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder msg = new StringBuilder(scan.nextLine());

//        String str = scan.nextLine();

        String splitRegex = ":\\|:";
        String[] cmd = scan.nextLine().split(splitRegex);
        while (!cmd[0].equals("Reveal")) {
            switch (cmd[0]) {
                case "InsertSpace" -> {
                    int index = Integer.parseInt(cmd[1]);
                    msg.insert(index, " ");
                    System.out.println(msg);
                }
                case "Reverse" -> {
                    String substr = cmd[1];
                    if(msg.indexOf(substr) != -1) {
                        int iBegin = msg.indexOf(substr);
                        int iEnd = msg.indexOf(substr) + substr.length();
                        substr = new StringBuilder(substr).reverse().toString();
                        msg.replace(iBegin, iEnd, substr);
                        System.out.println(msg);
                    } else {
                        System.out.println("error");
                    }
                }
                case "ChangeAll" -> {
                    String substr = cmd[1];
                    String replacement = cmd[2];
                    while (msg.indexOf(substr) != -1) {
                        int iBegin = msg.indexOf(substr);
                        int iEnd = msg.indexOf(substr) + substr.length();
                        msg.replace(iBegin, iEnd, replacement);
                    }
                    System.out.println(msg);
                }
            }

            cmd = scan.nextLine().split(splitRegex);
        }
        System.out.println("You have a new text message: " + msg);

    }
}
