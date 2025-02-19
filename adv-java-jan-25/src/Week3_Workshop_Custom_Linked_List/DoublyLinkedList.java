package Week3_Workshop_Custom_Linked_List;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {
    private class Element {
        private int value;
        private Element prev;
        private Element next;


        public Element(int value, Element prev, Element next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }
    private Element head;
    private Element tail;
    private int size;

    public void addFirst(int elementValue) {
        if(this.isEmpty()) {
            // add 1st element
            addToEmptyList(elementValue);
        } else {
            // add as head
            Element newHead = new Element(elementValue, null, this.head);
            this.head.prev = newHead;
            this.head = newHead;
        }
        this.size++;
    }

    public void addLast(int elementValue) {
        if(this.isEmpty()) {
            // add 1st element
            addToEmptyList(elementValue);
        } else {
            // add as tail
            Element newTail = new Element(elementValue, this.tail, null);
            this.tail.next = newTail;
            this.tail = newTail;
        }
        this.size++;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private void addToEmptyList(int elementValue) {
        Element newElem = new Element(elementValue, null, null);
        this.head = newElem;
        this.tail = newElem;
    }

    public int get(int idx) {
        if (!isValidIndex(idx)) {
            throw new IndexOutOfBoundsException("Provided index is invalid");
        }
        Element currElem = this.head;
        for (int i = 0; i < idx; i++) {
            currElem = currElem.next;
        }
        return currElem.value;
    }

    private boolean isValidIndex (int idx) {
        return idx >= 0 && idx < this.size;
    }

    public int removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException("List is empty. Nothing to remove");
        }
        int result = this.head.value;
        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
        return result;
    }

    public int removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException("List is empty. Nothing to remove");
        }
        int result = this.tail.value;
        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return result;
    }

    public void forEach(Consumer<Integer> consumer){

        Element currElem = this.head;
        for (int i = 0; i < this.size; i++) {
            consumer.accept(currElem.value);
            currElem = currElem.next;
        }
    }

    public int[] toArray() {
        int [] result = new int[this.size];
        Element currElem = this.head;
        for (int i = 0; i < result.length; i++) {
            result[i] = currElem.value;
            currElem = currElem.next;
        }
        return result;
    }
}
