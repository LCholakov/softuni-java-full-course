package Week3_Defining_Clases.Lab.BankAccount_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] cmd = scan.nextLine().split("\\s+");

        HashMap<Integer, BankAccount> accMap = new HashMap<>();
        while (!cmd[0].equals("End")) {
            switch (cmd[0]) {
                case "Create" -> {
                    BankAccount ba = new BankAccount();
                    accMap.put(ba.getId(), ba);
                    System.out.printf("Account ID%d created%n", ba.getId());
                }
                case "Deposit" -> {
                    int accID = Integer.parseInt(cmd[1]);
                    double amount = Double.parseDouble(cmd[2]);
                    if(accMap.containsKey(accID)) {
                        accMap.get(accID).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, accID);
                    } else {
                        System.out.println("Account does not exist");
                    }
                }
                case "SetInterest" -> BankAccount.setInterestRate(Double.parseDouble(cmd[1]));

                case "GetInterest" -> {
                    int accID = Integer.parseInt(cmd[1]);
                    int years = Integer.parseInt(cmd[2]);
                    if(accMap.containsKey(accID)) {
                        System.out.printf("%.2f%n", accMap.get(accID).getInterest(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                }
            }

            cmd = scan.nextLine().split("\\s+");
        }
    }
}
