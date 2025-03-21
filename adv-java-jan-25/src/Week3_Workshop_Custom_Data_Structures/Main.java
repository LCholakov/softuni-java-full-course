package Week3_Workshop_Custom_Data_Structures;

public class Main {
    public static void main(String[] args) {
        SmartArray smArr = new SmartArray();

        smArr.add(1);
        smArr.add(2);
        smArr.add(3);
        smArr.add(4);
        smArr.add(5);
        smArr.add(6);

        smArr.forEach(n -> System.out.print(n + ", "));
        smArr.add(2, 13);
        System.out.println(smArr.contains(11));
        System.out.println(smArr.contains(1));
        System.out.println(smArr.remove(3));
        System.out.println(smArr.remove(3));
        System.out.println(smArr.remove(3));
        System.out.println(smArr.remove(1));
        System.out.println(smArr.remove(1));

        CustomStack cusStack = new CustomStack();

        cusStack.push(1);
        cusStack.push(2);
        cusStack.push(3);
        cusStack.push(4);
        cusStack.push(5);
        cusStack.push(6);


        cusStack.forEach(n -> System.out.print(n + ", "));
        System.out.println();
        System.out.println(cusStack.peek());
        cusStack.pop();
        System.out.println(cusStack.peek());
        cusStack.pop();

        System.out.println(cusStack.peek());


    }
}
