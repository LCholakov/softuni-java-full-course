package Week7_Objects_and_Classes.Exer;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] phraseArr = { "Excellent product.", 
                                "Such a great product.",
                                "I always use that product.",
                                "Best product of its category.",
                                "Exceptional product.",
                                "I can’t live without this product." };
        
        String[] eventArr = { "Now I feel good.",
                                "I have succeeded with this product.",
                                "Makes miracles. I am happy of the results!",
                                "I cannot believe but now I feel awesome.",
                                "Try it yourself, I am very satisfied.",
                                "I feel great!" };

        String[] authorArr = { "Diana", "Petya", "Stella", "Elena",
                                "Katya", "Iva", "Annie", "Eva" };

        String[] cityArr = { "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse" };

        Random rnd = new Random();
        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String output = "";
            output = output.concat(phraseArr[rnd.nextInt(phraseArr.length)]) + " ";
            output = output.concat(eventArr[rnd.nextInt(eventArr.length)]) + " ";
            output = output.concat(authorArr[rnd.nextInt(authorArr.length)]) + " - ";
            output = output.concat(cityArr[rnd.nextInt(cityArr.length)]);

            System.out.println(output);
        }
    }
}
