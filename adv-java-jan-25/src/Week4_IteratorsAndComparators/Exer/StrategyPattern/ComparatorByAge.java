package Week4_IteratorsAndComparators.Exer.StrategyPattern;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
//        return Integer.compare(o1.getAge(), o2.getAge());
        return o1.getAge().compareTo(o2.getAge());
    }
}
