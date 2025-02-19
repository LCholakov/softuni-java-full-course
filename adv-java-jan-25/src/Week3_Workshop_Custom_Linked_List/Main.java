package Week3_Workshop_Custom_Linked_List;

public class Main {
    public static void main(String[] args) {
//        Element firstElement = new Element(10, null, null);
//        System.out.println(firstElement);

        DoublyLinkedList customList = new DoublyLinkedList();
        customList.addLast(0);
        customList.addLast(1);
        customList.addLast(2);
        customList.addLast(3);
        customList.addLast(4);
        customList.addLast(5);
        customList.addLast(6);
        customList.addLast(7);
        customList.addLast(8);
        customList.addLast(9);
        customList.addLast(10);
        customList.addLast(11);

//        customList.removeLast();
//        customList.removeLast();
//        customList.removeLast();
//        customList.removeLast();
//        customList.removeLast();
//        customList.removeLast();
//        customList.removeLast();
//        customList.removeLast();
//        customList.removeLast();
//        customList.removeLast();
//        customList.removeLast();
//        customList.removeLast();
//        customList.removeLast();
//        customList.addLast(10);
//        customList.addLast(7);
//        customList.addLast(5);
//        customList.addLast(3);
//        customList.addLast(1);

        int [] test = customList.toArray();

        for (int i : test) {
            System.out.println(i);
        }
        customList.forEach(System.out::println);
        System.out.println(customList.get(11));
    }
}
