package Week3_Generics.Exer.GenericSwapMethodStrings_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /// STRINGS ///
//        Box<String> strBox = new Box<>();
//
//        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
//            strBox.add(scan.nextLine());
//        }

        /// INTEGERS ///
//        Box<Integer> numBox = new Box<>();
//
//        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
//            numBox.add(Integer.parseInt(scan.nextLine()));
//        }

//        int idx1 = scan.nextInt();
//        int idx2 = scan.nextInt();
//        numBox.swap(idx1, idx2);
//
//        System.out.println(numBox.toString());

        // Задача 4
//        String compareVal = scan.nextLine();
//        System.out.println(strBox.countGreater(compareVal));

        // Задача 5
        Box<Double> dblBox = new Box<>();

        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            dblBox.add(Double.parseDouble(scan.nextLine()));
        }
        double compareVal = Double.parseDouble(scan.nextLine());
        System.out.println(dblBox.countGreater(compareVal));
    }
}
