package Week2_Interfaces_And_Abstraction.FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();


        int totalFood = 0;
        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String [] tok = scan.nextLine().split("\\s+");
            switch (tok.length) {
                case 3: rebels.add(new Rebel(tok[0], Integer.parseInt(tok[1]), tok[2]));
                break;
                case 4: citizens.add(new Citizen(tok[0], Integer.parseInt(tok[1]), tok[2], tok[3]));
                break;
            }
        }

        String buyer = scan.nextLine();
        loop: while (!buyer.equals("End")) {
            for (Citizen c : citizens) {
                if(c.getName().equals(buyer)) {
                    c.buyFood();
                    totalFood += 10;
                }
            }
            for (Rebel r : rebels) {
                if(r.getName().equals(buyer)) {
                    r.buyFood();
                    totalFood += 5;
                }
            }

            buyer = scan.nextLine();
        }
        System.out.println(totalFood);
    }
}
