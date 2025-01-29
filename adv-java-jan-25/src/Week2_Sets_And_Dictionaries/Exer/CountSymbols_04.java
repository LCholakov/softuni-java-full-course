package Week2_Sets_And_Dictionaries.Exer;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<Character, Integer> charTree = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!charTree.containsKey(c)) {
                charTree.put(c, 1);
            } else {
                charTree.put(c, charTree.get(c) + 1);
            }
        }
        charTree.forEach((key, val) -> System.out.printf("%c: %d time/s%n", key, val));
    }
}
