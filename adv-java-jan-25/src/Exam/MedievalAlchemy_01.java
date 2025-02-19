package Exam;

import java.util.*;
import java.util.stream.Collectors;

public class MedievalAlchemy_01 {
    // Strings
    static final String brewImmortStr = "Brew of Immortality";
    static final String essenceResilStr = "Essence of Resilience";
    static final String draughtWisStr = "Draught of Wisdom";
    static final String potionAgilStr = "Potion of Agility";
    static final String elixirStrenStr = "Elixir of Strength";

    // Potion energies
    static final int brewImmortLvl = 110;
    static final int essenceResilLvl = 100;
    static final int draughtWisLvl = 90;
    static final int potionAgilLvl = 80;
    static final int elixirStrenLvl = 70;

    // Potions made
    static boolean brewImmortExists = false;
    static boolean essenceResilExists = false;
    static boolean draughtWisExists = false;
    static boolean potionAgilExists = false;
    static boolean elixirStrenExists = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Substances will be a STACK
        // Crystals will be a QUEUE

        // STACK
        ArrayDeque<Integer> substanceStack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(substanceStack::push);
        // QUEUE
        ArrayDeque<Integer> crystalQueue = Arrays
                .stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        List<String> potionsMade = new ArrayList<>();


        // logic

        while (!substanceStack.isEmpty() && !crystalQueue.isEmpty() && !allPotionsExist()) {
            // this is gonna be waaaay too verbose, should have come with some real logic instead of brute forcing all cases.
            // A map would have been good, removing potions after they've been made
            // energy level matches exactly
            int currEnergyLvl = substanceStack.peek() + crystalQueue.peek();
            if (currEnergyLvl == brewImmortLvl && !brewImmortExists) {
                brewImmortExists = true;
                potionsMade.add(brewImmortStr);
                substanceStack.pop();
                crystalQueue.poll();
            } else if (currEnergyLvl == essenceResilLvl && !essenceResilExists) {
                essenceResilExists = true;
                potionsMade.add(essenceResilStr);
                substanceStack.pop();
                crystalQueue.poll();
            } else if (currEnergyLvl == draughtWisLvl && !draughtWisExists) {
                draughtWisExists = true;
                potionsMade.add(draughtWisStr);
                substanceStack.pop();
                crystalQueue.poll();
            } else if (currEnergyLvl == potionAgilLvl && !potionAgilExists) {
                potionAgilExists = true;
                potionsMade.add(potionAgilStr);
                substanceStack.pop();
                crystalQueue.poll();
            } else if (currEnergyLvl == elixirStrenLvl && !elixirStrenExists) {
                elixirStrenExists = true;
                potionsMade.add(elixirStrenStr);
                substanceStack.pop();
                crystalQueue.poll();
            } else {
                // energy level does not match
                if (currEnergyLvl > brewImmortLvl && !brewImmortExists) {
                    substanceStack.pop();
                    if (crystalQueue.peek() - 20 > 0) { crystalQueue.offer(crystalQueue.poll() - 20); }
                    else { crystalQueue.poll(); }
                    brewImmortExists = true;
                    potionsMade.add(brewImmortStr);
                } else if (currEnergyLvl > essenceResilLvl && !essenceResilExists) {
                    substanceStack.pop();
                    if (crystalQueue.peek() - 20 > 0) { crystalQueue.offer(crystalQueue.poll() - 20); }
                    else { crystalQueue.poll(); }
                    essenceResilExists = true;
                    potionsMade.add(essenceResilStr);
                } else if (currEnergyLvl > draughtWisLvl && !draughtWisExists) {
                    substanceStack.pop();
                    if (crystalQueue.peek() - 20 > 0) { crystalQueue.offer(crystalQueue.poll() - 20); }
                    else { crystalQueue.poll(); }
                    draughtWisExists = true;
                    potionsMade.add(draughtWisStr);
                } else if (currEnergyLvl > potionAgilLvl && !potionAgilExists) {
                    substanceStack.pop();
                    if (crystalQueue.peek() - 20 > 0) { crystalQueue.offer(crystalQueue.poll() - 20); }
                    else { crystalQueue.poll(); }
                    potionAgilExists = true;
                    potionsMade.add(potionAgilStr);
                } else if (currEnergyLvl > elixirStrenLvl && !elixirStrenExists) {
                    substanceStack.pop();
                    if (crystalQueue.peek() - 20 > 0) { crystalQueue.offer(crystalQueue.poll() - 20); }
                    else { crystalQueue.poll(); }
                    elixirStrenExists = true;
                    potionsMade.add(elixirStrenStr);
                } else {
                    substanceStack.pop();
                    if (crystalQueue.peek() - 5 > 0) { crystalQueue.offer(crystalQueue.poll() - 5); }
                    else { crystalQueue.poll(); }
                }
            }
        }

        if (allPotionsExist()) {
            System.out.println("Success! The alchemist has forged all potions!");
        } else {
            System.out.println("The alchemist failed to complete his quest.");
        }
        if (!potionsMade.isEmpty()) {
            System.out.print("Crafted potions: ");
            System.out.println(potionsMade.toString().replaceAll("[\\[\\]]", ""));
        }
        if (!substanceStack.isEmpty()) {
            System.out.print("Substances: ");
            System.out.println(substanceStack.toString().replaceAll("[\\[\\]]", ""));
        }
        if (!crystalQueue.isEmpty()) {
            System.out.print("Crystals: ");
            System.out.println(crystalQueue.toString().replaceAll("[\\[\\]]", ""));
        }

    }

    private static boolean allPotionsExist() {
        return brewImmortExists && essenceResilExists && draughtWisExists && potionAgilExists && elixirStrenExists;
    }
}
