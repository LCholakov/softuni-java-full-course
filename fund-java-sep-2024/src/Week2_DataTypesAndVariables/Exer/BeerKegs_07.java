package Week2_DataTypesAndVariables.Exer;

import java.util.Scanner;

public class BeerKegs_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte n = Byte.parseByte(scanner.nextLine());
        String resultKegName = "";
        double resultKegVol = 0;

        for (byte i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double vol = Math.PI
                        * Math.pow(Double.parseDouble(scanner.nextLine()), 2)     // radius
                        * Double.parseDouble(scanner.nextLine());                 // height
            if (vol > resultKegVol){
                resultKegVol = vol;
                resultKegName = name;
            }
        }
        System.out.println(resultKegName);
    }
}
