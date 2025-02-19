package Week2_Sets_And_Dictionaries.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Voina_NumberGame_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> p1set = new LinkedHashSet<>();
        String [] input = scan.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            p1set.add(Integer.parseInt(input[i]));
        }

        Set<Integer> p2set = new LinkedHashSet<>();
        input = scan.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            p2set.add(Integer.parseInt(input[i]));
        }

        int counter = 0;
        while(!p1set.isEmpty() && !p2set.isEmpty() && counter < 50) {

            int p1card = p1set.iterator().next();
            int p2card = p2set.iterator().next();
            p1set.remove(p1card);
            p2set.remove(p2card);

            if (p1card > p2card) {
                p1set.add(p2card);
                p1set.add(p1card);
            } else if (p2card > p1card){
                p2set.add(p1card);
                p2set.add(p2card);
            }
            counter++;
        }

        if(p1set.size() > p2set.size()) {
            System.out.println("First player win!");
        } else if(p2set.size() > p1set.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }
}
