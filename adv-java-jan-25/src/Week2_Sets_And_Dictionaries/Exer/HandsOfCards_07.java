package Week2_Sets_And_Dictionaries.Exer;

import java.util.*;

public class HandsOfCards_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Map<String, Set<String>> allPlayersMap = new LinkedHashMap<>();

        String[] input = scan.nextLine().split(": ");

        while (!input[0].equals("JOKER")) {
            String name = input[0];
            String[] cardsArr = input[1].split(", ");
            Set<String> cardsSet = new HashSet<>();
            cardsSet.addAll(Arrays.asList(cardsArr));

            if (!allPlayersMap.containsKey(name)) {
                allPlayersMap.put(name, cardsSet);
            } else {
                Set<String> currHand = allPlayersMap.get(name);
                currHand.addAll(cardsSet);
                allPlayersMap.put(name, currHand);
            }

            input = scan.nextLine().split(": ");
        }

        allPlayersMap.forEach((k, v) -> System.out.println(k + ": " + calculatePoints(v)));


    }

    private static int getSymbolValue(Character c) {
        Map<Character, Integer> symbolMap = new HashMap<>();
        symbolMap.put('1', 1);
        symbolMap.put('2', 2);
        symbolMap.put('3', 3);
        symbolMap.put('4', 4);
        symbolMap.put('5', 5);
        symbolMap.put('6', 6);
        symbolMap.put('7', 7);
        symbolMap.put('8', 8);
        symbolMap.put('9', 9);
        symbolMap.put('J', 11);
        symbolMap.put('Q', 12);
        symbolMap.put('K', 13);
        symbolMap.put('A', 14);
        symbolMap.put('S', 4);
        symbolMap.put('H', 3);
        symbolMap.put('D', 2);
        symbolMap.put('C', 1);

        return symbolMap.get(c);
    }

    private static int calculatePoints(Set<String> v) {
        int points = 0;

        for (String card : v) {
            if (card.startsWith("10")) {
                points += 10 * getSymbolValue(card.charAt(2));
            } else {
                points += getSymbolValue(card.charAt(0)) * getSymbolValue(card.charAt(1));
            }
        }

        return points;
    }
}










