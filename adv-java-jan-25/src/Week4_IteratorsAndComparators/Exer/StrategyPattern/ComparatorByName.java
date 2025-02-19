package Week4_IteratorsAndComparators.Exer.StrategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int compareResult = Integer.compare(o1.getName().length(), o2.getName().length());

        if (compareResult == 0) {
            return Character.compare(o1.getName().toLowerCase().charAt(0), o2.getName().toLowerCase().charAt(0));
        }
        return compareResult;
    }
}
