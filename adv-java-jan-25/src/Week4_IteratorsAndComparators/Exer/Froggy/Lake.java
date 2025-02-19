package Week4_IteratorsAndComparators.Exer.Froggy;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lake implements Iterable<Integer> {
    private List<Integer> nList;

    public Lake(List<Integer> nList) {
        this.nList = nList;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            private int evenIdx = 0;
            private int oddIdx = 1;

            @Override
            public boolean hasNext() {
                return evenIdx < nList.size() || oddIdx < nList.size();
            }

            @Override
            public Integer next() {
                int number;
                if (evenIdx < nList.size()) {
                    number = nList.get(evenIdx);
                    evenIdx += 2;
                } else {
                    number = nList.get(oddIdx);
                    oddIdx += 2;
                }
                return  number;
            }
        };
    }
}
