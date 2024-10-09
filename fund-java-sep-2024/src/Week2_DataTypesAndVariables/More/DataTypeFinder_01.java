package Week2_DataTypesAndVariables.More;

import java.util.Scanner;

public class DataTypeFinder_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String type = "";
            boolean isInt = true;
            boolean isFloat = true;

            // check all chars are digits
            for (int i = 0; i < input.length(); i++) {
                char c1 = input.charAt(0);
                if (i == 0 && c1 == '-' && input.length() > 1) {
                    ++i;
                }
                if (input.charAt(i) < 48 || 57 < input.charAt(i)) {
                    isInt = false;
                    break;
                }
            }
            // check for float
            if (input.length() < 3) {
                isFloat = false;
            } else if (!isInt) {    // not an int and at least 3chars, e.g. 1.1
                int dotCounter = 0;
                int i = 0;
                if ((input.charAt(0) == '-' && (48 <= input.charAt(1) && input.charAt(1) <= 57))) {    // 1st char is - and 2nd char is digit
                    i = 2;
                } else if ((48 <= input.charAt(0) && input.charAt(0) <= 57)) {    // 1st char is digit
                    i = 1;
                }

                for (; i < input.length(); i++) {
                    if (input.charAt(input.length() - 1) == '.') {
                        isFloat = false;
                        break;
                    } else if(input.charAt(i) == '.') {
                        ++dotCounter;
                        if(dotCounter > 1) {
                            isFloat = false;
                            break;
                        }
                        continue;
                    }
                    if (input.charAt(i) < 48 || 57 < input.charAt(i)) {
                        isFloat = false;
                        break;
                    }
                }
            }



            if(isInt) {
                type = "integer";
            } else if (isFloat) {
                type = "floating point";
            } else if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                type = "boolean";
            } else {
                if (input.length() == 1) {
                    type = "character";
                } else {
                    type = "string";
                }
            }
            System.out.printf("%s is %s type%n", input, type);
//            System.out.println(input + " is boolean type");
            input = scanner.nextLine();
        }
    }
}
