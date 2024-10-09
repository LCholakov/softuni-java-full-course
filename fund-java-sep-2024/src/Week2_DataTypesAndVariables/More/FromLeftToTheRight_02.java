package Week2_DataTypesAndVariables.More;

import java.util.Scanner;

public class FromLeftToTheRight_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String aString = "";
            String bString = "";
            String largerNumAsString = "";
            for (int j = 0; j < input.length(); j++) {
                if (j < input.indexOf(" ")) {
                    aString = aString + input.charAt(j);
                } else if (j > input.indexOf(" ")) {
                    bString = bString + input.charAt(j);
                }
            }
            int sum = 0;

            // Compare longs, sum char values of digits from string
//            if (Long.parseLong(aString) > Long.parseLong(bString)) {
//                for (int j = 0; j < aString.length(); j++) {
//                    sum += aString.charAt(j) - 48;
//                }
//            } else {
//                for (int j = 0; j < bString.length(); j++) {
//                    sum += bString.charAt(j) - 48;
//                }
//            }

            // compare longs, use modulo for sum
            // my mistake is probably with the negatives !
            long num = 0;
            if (Long.parseLong(aString) > Long.parseLong(bString)) {
                num = Math.abs(Long.parseLong(aString));
            } else {
                num = Math.abs(Long.parseLong(bString));
            }
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            // compare char by char
//            if (aString.length() > bString.length()) {
//                largerNumAsString = aString;
//            }
//            else if (bString.length() > aString.length()) {
//                largerNumAsString = bString;
//            } else {
//                for (int j = 0; j < aString.length(); j++) {
//                    if (aString.charAt(j) > bString.charAt(j)) {
//                        largerNumAsString = aString;
//                        break;
//                    } else {
//                        largerNumAsString = bString;
//                        break;
//                    }
//                }
//            }
//            for (int j = 0; j < largerNumAsString.length(); j++) {
//                sum += largerNumAsString.charAt(j) - 48;
//            }
            System.out.println(sum);
        }
    }
}
