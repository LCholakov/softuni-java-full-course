package Week3_Workshop_Custom_Data_Structures;

import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }


    // add to end of list
    public void add(int element) {
        if (this.size == this.capacity) {
            resize();
        }
        this.data[this.size] = element;
        this.size++;
    }

    private void resize() {
        this.capacity *= 2;
        int [] copyArr = new int[this.capacity];

        for (int i = 0; i < this.data.length; i++) {
            copyArr[i] = this.data[i];
        }
        data = copyArr;
    }

    public int get(int idx) {
        checkIndex(idx);
        return this.data[idx];
    }

    private void checkIndex(int idx) {
        if (idx < 0 || idx >= this.size) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format("Ehooo, alo, Index %d is out of bounds for size %d.", idx, this.size)
            );
        }
    }
    public int remove(int idx) {
        checkIndex(idx);
        int n = this.data[idx];
        shiftLeft(idx);


        this.size--;
        if (this.size <= this.capacity / 4) {
            shrink();
        }
        return n;
    }

    private void shrink() {
        this.capacity /= 2;
        int [] copyArr = new int [this.capacity];

        for (int i = 0; i < this.size; i++) {
            copyArr[i] = this.data[i];
        }
        this.data = copyArr;
    }

    private void shiftLeft (int idx) {
        for (int i = idx; i < this.size ; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[this.size - 1] = 0;

    }

    public boolean contains(int element) {
        for (int datum : this.data) {
            if (element == datum) {
                return true;
            }
        }
        return false;
    }

    public void add (int idx, int element) {
        checkIndex(idx);
        if (idx == this.size - 1){
            add(this.data[this.size - 1]);
            this.data[this.size - 2] = element;
        } else {
            if (this.size == this.capacity) {
                resize();
            }
            shiftRight(idx);
            this.size++;
            this.data[idx] = element;
        }
    }

    private void shiftRight(int idx) {
        for (int i = this.size; i > idx; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    public void forEach(Consumer<Integer> consumer){

        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }
}
