package Week1_Working_With_Abstraction.Cards_01_02_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 01. Card Suits
//        System.out.println("Card Suits:");
//
//        CardSuits[] suits = CardSuits.values();
//        for (CardSuits s : suits) {
//            System.out.println(
//                    String.format("Ordinal value: %d; Name value: %s", s.ordinal(), s.name()));
//        }

        // 02. Card Ranks
//        System.out.println("Card Ranks:");
//
//        CardRanks[] ranks = CardRanks.values();
//        for (CardRanks r : ranks) {
//            System.out.println(
//                    String.format("Ordinal value: %d; Name value: %s", r.ordinal(), r.name()));
//        }


        // 03. Card with Power
        Scanner scan = new Scanner(System.in);

        String rank = scan.nextLine();
        String suit = scan.nextLine();
        int rankPow = CardRanks.valueOf(rank).getPower();;
        int suitPow = CardSuits.valueOf(suit).getPower();
        System.out.printf("Card name: %s of %s; Card power: %d%n"
        , rank, suit, rankPow + suitPow);
    }
}
