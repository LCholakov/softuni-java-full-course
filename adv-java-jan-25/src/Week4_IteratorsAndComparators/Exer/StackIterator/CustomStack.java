package Week4_IteratorsAndComparators.Exer.StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomStack implements Iterable<Integer> {
    private List<Integer> nList;

    public CustomStack(List<Integer> nList) {
        this.nList = nList;
    }
    public CustomStack() {
        this.nList = new ArrayList<>();
    }

    public int pop() {
        if (nList.isEmpty()) {
            System.out.println("No elements");
            return 0;
        }

        return nList.remove(nList.size()-1);
    }

    public void push(int number) {
        nList.add(number);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            private int idx = nList.size() - 1;
            @Override
            public boolean hasNext() {
                return idx >= 0;
            }

            @Override
            public Integer next() {
                int num = nList.get(idx);
                idx--;
                return num;
            }
        };
    }
}
