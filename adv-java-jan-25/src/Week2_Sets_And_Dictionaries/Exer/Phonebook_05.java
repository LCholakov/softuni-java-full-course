package Week2_Sets_And_Dictionaries.Exer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, String> phonebookMap = new HashMap<>();

        String[] phoneAddInput = scan.nextLine().split("-");

        while (!phoneAddInput[0].equals("search")) {
            phonebookMap.put(phoneAddInput[0], phoneAddInput[1]);
            phoneAddInput = scan.nextLine().split("-");
        }

        String searchInput = scan.nextLine();
        while (!searchInput.equals("stop")) {
            if (phonebookMap.containsKey(searchInput)) {
                System.out.println(searchInput + " -> " + phonebookMap.get(searchInput));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchInput);
            }
            searchInput = scan.nextLine();
        }
    }
}

