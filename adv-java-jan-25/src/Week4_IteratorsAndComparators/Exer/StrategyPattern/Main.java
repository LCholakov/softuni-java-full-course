package Week4_IteratorsAndComparators.Exer.StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Person> personByNameSet = new TreeSet<>(new ComparatorByName());
        Set<Person> personByAgeSet = new TreeSet<>(new ComparatorByAge());

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String [] tokens = scan.nextLine().split("\\s+");
            personByNameSet.add(new Person(tokens[0], Integer.parseInt(tokens[1])));
            personByAgeSet.add(new Person(tokens[0], Integer.parseInt(tokens[1])));
        }
        personByNameSet.forEach(System.out::println);
        personByAgeSet.forEach(System.out::println);

    }
}
