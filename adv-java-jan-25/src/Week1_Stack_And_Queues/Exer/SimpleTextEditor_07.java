package Week1_Stack_And_Queues.Exer;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder txt = new StringBuilder();
        ArrayDeque<String> actionsStack = new ArrayDeque<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String [] cmd = scan.nextLine().split("\\s+");
            switch (cmd[0]) {
                case "1" -> {
                    actionsStack.push(txt.toString());
                    txt.append(cmd[1]);
                }
                case "2" -> {
                    actionsStack.push(txt.toString());
                    txt.delete(txt.length() - Integer.parseInt(cmd[1]), txt.length());
                }
                case "3" -> System.out.println(txt.charAt(Integer.parseInt(cmd[1]) - 1));
                case "4" -> {
                    txt = new StringBuilder(actionsStack.pop());
                }
            }
        }
    }
}
