package Week5_WhileLoop.Exer;

import java.util.Scanner;

public class Coins_05
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int change = (int) (100 * Double.parseDouble(scanner.nextLine()));

        int coin2lv = 0;
        int coin1lv = 0;
        int coin50st = 0;
        int coin20st = 0;
        int coin10st = 0;
        int coin5st = 0;
        int coin2st = 0;
        int coin1st = 0;

        coin2lv = change / 200;
        change -= coin2lv * 200;

        coin1lv = change / 100;
        change -= coin1lv * 100;

        coin50st = change / 50;
        change -= coin50st * 50;

        coin20st = change/ 20;
        change -= coin20st * 20;

        coin10st = change / 10;
        change -= coin10st * 10;

        coin5st = change / 5;
        change -= coin5st * 5;

        coin2st = change / 2;
        change -= coin2st * 2;

        coin1st = change / 1;

        int result = coin2lv + coin1lv + coin50st + coin20st + coin10st + coin5st + coin2st + coin1st;
        System.out.println(result);
    }
}
