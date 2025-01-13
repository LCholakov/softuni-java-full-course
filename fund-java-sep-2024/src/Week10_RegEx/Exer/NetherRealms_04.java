package Week10_RegEx.Exer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String healthRegex = "[^0-9+,\\-*\\/.]";
        String baseDamageRegex = "[+-]?\\d+[.\\d]*";
//        String baseDamageRegex = "[-]?[0-9]+\\.?[0-9]*";                             // teacher version
        String modifyDamageRegex = "[\\*\\/]";
//        String[] inputArr = scan.nextLine().replace(" ", "").split(",");
        String[] inputArr = scan.nextLine().split("\\s*,+\\s*");

        Pattern healthPattern = Pattern.compile(healthRegex);
        Pattern baseDamagePattern = Pattern.compile(baseDamageRegex);
        Pattern modifyDamagePattern = Pattern.compile(modifyDamageRegex);

        for (String s : inputArr) {
            int health = 0;
            double damage = 0;
            Matcher healthMatcher = healthPattern.matcher(s);
            while(healthMatcher.find()) {
                health += healthMatcher.group().charAt(0);
            }
//            for (char c : s.toCharArray()) {
//                if(!Character.isDigit(c) && c != '+' && c != '-' && c != '*' && c != '/' && c != '.') {
//                    health += c;
//                }
//            }
            Matcher baseDamageMatcher = baseDamagePattern.matcher(s);
            while(baseDamageMatcher.find()) {
                damage += Double.parseDouble(baseDamageMatcher.group());
            }
            Matcher modifyDamageMatcher = modifyDamagePattern.matcher(s);
            while(modifyDamageMatcher.find()) {
                switch (modifyDamageMatcher.group()) {
                    case "/" -> damage /= 2.0;
                    case "*" -> damage *= 2;
                }
//
//            for (char c : s.toCharArray()) {
//                if(c == '*') {
//                    damage *= 2;
//                } else if (c == '/') {
//                    damage /= 2.0;
//                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", s, health, damage);
        }
    }
}
