package Week12_Final_Exam;

public class Theoretical {
    public static void main(String[] args) {
        // 5
        printText("Java");
        // 7
//        String name = "George";
//        name.charAt(2) = "m";
//        System.out.println(name.charAt(2));
        // 8
        for (int i = 10; i > 3; i -= 2) {
            System.out.printf("%d ", i);

        }

        // 11
        String str11 = "Hello World!";
        System.out.println(str11.substring(3,5));

        //14
//        boolean isTrue = true;
//        int val = Integer.parseInt(isTrue);


        //16
        boolean isTrue1 = 100f != 100d;
        boolean isTrue2 = "string".equals("String");
        boolean isTrue3 = 100d == 100d;
        boolean isTrue4 = 5 > 'a';
        System.out.println(isTrue1);
        System.out.println(isTrue2);
        System.out.println(isTrue3);
        System.out.println(isTrue4);
    }

    public static void printText(String text) {
        System.out.println("I love" + text);
    }
}
