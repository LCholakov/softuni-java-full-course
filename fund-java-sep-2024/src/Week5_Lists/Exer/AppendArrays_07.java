package Week5_Lists.Exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Regex gets | with any number of spaces on either side
        // input data seems to be all over the place
        String[] input = scanner.nextLine().split("[ ]*[|][ ]*");
        List<Integer> numList = new ArrayList<>();

        // empty array input validation
        if(input.length == 1 && input[0].equals("")) { return; }

        for (int i = input.length - 1; i >= 0 ; i--) {
            // skip empty string (occurs when input has two bars eg "||"
            if (input[i].length() == 0) { continue; }

            boolean isOnlyDigits = true;
            for (int j = 0; j < input[i].length(); j++) {
                char c = input[i].charAt(j);
                if(!(c == ' ' || (c >= 48 && c <= 57))) {
                    // skip string that has any non digit (or space) chars
//                    isOnlyDigits = false;
//                    break;
                    // remove non-digit (and non-space) chars
//                    input[i] = input[i].substring(0, j) + input[i].substring(j + 1);
                    // replace non-digit (and non-space) chars with space
                    input[i] = input[i].substring(0, j) + " " + input[i].substring(j + 1);
                    // skip if contains
//                    input[i] = input[i].substring(0, j) + input[i].substring(j + 1);
                }
            }
            //regex to replace 2 or more spaces with one to normalize data
            input[i] = input[i].replaceAll("  +", " ");
            // remove leading space to avoid exception when parsing ints
            if (input[i].charAt(0) == ' ') {
                input[i] = input[i].substring(1, input[i].length());
            }
            if(!isOnlyDigits) continue;
            int[] numsArr = Arrays.stream(input[i].split(" "))
                            .mapToInt(e -> Integer.parseInt(e)).toArray();

            for (int n : numsArr) {
                numList.add(n);
            }
        }
        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
