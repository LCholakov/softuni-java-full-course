package Week10_RegEx.Exer;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern pattern = Pattern.compile("([^@\\-!:>]*)@(?<planet>[A-Za-z]+)([^@\\-!:>]*)([^@\\-!:>]*):(?<population>\\d+)([^@\\-!:>]*)!(?<attackType>[AD])([^@\\-!:>]*)!([^@\\-!:>]*)->(?<soldierCount>\\d+)");

        List<String> attackedArr = new ArrayList<>();
        List<String> destroyedArr = new ArrayList<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String input = scan.nextLine();

            int key = 0;
            for (int j = 0; j < input.length(); j++) {
                char c = input.toLowerCase().charAt(j);
                if(c == 's' || c == 't' || c == 'a' || c == 'r') {
                    key++;
                }
            }
            String message = "";
            for (int j = 0; j < input.length(); j++) {
                message = message + (char)(input.charAt(j) - key);
            }

            Matcher matcher = pattern.matcher(message);

            if(matcher.find()) {
                String s = matcher.group("planet");
                s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
                switch (matcher.group("attackType")) {
                    case "A" -> attackedArr.add(s);
                    case "D" -> destroyedArr.add(s);
                }
            }
//            System.out.println(message);
        }
        System.out.printf("Attacked planets: %d%n", attackedArr.size());
        Collections.sort(attackedArr);
        Collections.sort(destroyedArr);
        for(String s : attackedArr) {
            System.out.printf("-> %s%n", s);
        }
        System.out.printf("Destroyed planets: %d%n", destroyedArr.size());
        for(String s : destroyedArr) {
            System.out.printf("-> %s%n", s);
        }

    }
}
