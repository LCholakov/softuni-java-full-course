package Week3_Generics.Exer.CustomList_07;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;
    private int size;


    public CustomList() {
        this.list = new ArrayList<>();
        size = 0;
    }

    public void add(T element) {
        this.list.add(element);
        this.size++;
    }

    public T remove(int index) {
        if (isNotInRange(index)) {
            return null;
        }
        this.size--;
        return this.list.remove(index);
    }

    private boolean isNotInRange(int index) {
        return index < 0 || index >= size;
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public  void swap (int index1, int index2) {
        if(isNotInRange(index1) || isNotInRange(index2)) {
            System.out.println("Provided index not in range.");
        }
        T temp = this.list.get(index1);
        this.list.set(index1, this.list.get(index2));
        this.list.set(index2, temp);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T e : this.list) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        T max = list.getFirst();
        for (T e : list) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }
        return max;
    }

    public T getMin() {
        T min = list.getFirst();
        for (T e : list) {
            if (e.compareTo(min) < 0) {
                min = e;
            }
        }
        return min;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.list) {
//            String fStr = String.format("%s: %s%n", element.getClass().getName(), element);
//            sb.append(fStr);
            sb.append(element + "\n");
        }
        return sb.toString();
    }

    public void sort() {
        this.list.sort((e1, e2) -> e1.compareTo(e2));
    }
}
