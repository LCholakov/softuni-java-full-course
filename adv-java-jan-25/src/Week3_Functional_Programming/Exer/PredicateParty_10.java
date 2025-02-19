package Week3_Functional_Programming.Exer;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateParty_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> guestList = Arrays.stream(scan.nextLine().split("\\s+")).toList();

//        Predicate<Integer> tester = createTester(scan.nextLine(), Integer.parseInt(scan.nextLine()));
//        Consumer<Map.Entry<String, Integer>> printer = createPrinter(scan.nextLine());
//        printFilteredStudent(pplMap, tester, printer);

        String [] tokens = scan.nextLine().split("\\s+");
        while (!tokens[0].equals("Party!")) {
            String mainCmd = tokens[0];
            String subCmd = tokens[1];
            String param = tokens[2];


            tokens = scan.nextLine().split("\\s+");
        }

    }
    static Consumer<Map.Entry<String, Integer>> createPrinter (String format) {
        Consumer<Map.Entry<String, Integer>> printer = null;
        switch (format) {
            case "name age" -> printer = person -> System.out.printf("%s - %d%n",
                    person.getKey(), person.getValue());
            case "name" -> printer = person -> System.out.printf("%s%n",person.getKey());
            case "age" -> printer = person -> System.out.printf("%d%n",person.getValue());
        }
        return printer;
    }

    static Predicate<Integer> createTester(String condition, Integer age) {
        Predicate<Integer> tester = null;
        switch (condition) {
            case "younger" -> tester = x -> x <= age;
            case "older"  -> tester = x -> x >= age;
        }
        return tester;
    }

    static void printFilteredStudent(
            LinkedHashMap<String, Integer> people,
            Predicate<Integer> tester,
            Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey()))) {
                printer.accept(person);
            }
        }
    }
}
