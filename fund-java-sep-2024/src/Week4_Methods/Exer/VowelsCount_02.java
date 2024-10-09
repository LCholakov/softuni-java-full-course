package Week4_Methods.Exer;

import java.util.Scanner;

public class VowelsCount_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        countVowels(scanner.nextLine());
    }

    private static void countVowels(String s) {
        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
////            char c = s.charAt(i);
////            if (c == 'A' || c == 'a' ||
////                c == 'E' || c == 'e' ||
////                c == 'I' || c == 'i' ||
////                c == 'O' || c == 'o' ||
////                c == 'U' || c == 'u') {
////                count++;
//            char c = s.toLowerCase().charAt(i);
//            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
//                count++;
//            }
//        }
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        System.out.println(count);
    }
}
