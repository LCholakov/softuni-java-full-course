package Week3_Workshop_Custom_Data_Structures;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;

    private int[] items;
    private int size;
    private int capacity;

    public CustomStack() {
        this.items = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public int getSize() {
        return size;
    }

    public void push(int element) {
        if (this.size == this.capacity) {
            resize();
        }
        this.items[this.size] = element;
        this.size++;
    }

    private void resize() {
        this.capacity *= 2;
        int [] copyArr = new int[this.capacity];

        for (int i = 0; i < this.items.length; i++) {
            copyArr[i] = this.items[i];
        }
        items = copyArr;
    }

    public int pop() {
        checkEmpty();
        this.size--;
        return this.items[this.size];
    }

    private void checkEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException("CustomStack is empty.");
        }
    }

    public  int peek() {
        return this.items[this.size - 1];
    }

    public void forEach(Consumer<Integer> consumer){

        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.items[i]);
        }
    }
}
