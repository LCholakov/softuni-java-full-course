package Week3_Generics.Lab.Jar;

import java.util.*;

public class Jar <T> {
    private Deque<T> jarDeq;

    public Jar() {
        this.jarDeq = new ArrayDeque<>();
    }
    public void add(T element) {
        this.jarDeq.push(element);
    }
    public  T remove() {
        return this.jarDeq.pop();
    }
}
