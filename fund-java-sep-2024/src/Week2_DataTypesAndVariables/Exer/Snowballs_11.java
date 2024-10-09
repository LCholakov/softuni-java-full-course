package Week2_DataTypesAndVariables.Exer;

import java.util.Map;
import java.util.Scanner;

public class Snowballs_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double valHigh = 0.0;
        int snowHigh = 0;
        int timeHigh = 0;
        int qualityHigh = 0;
        for (int i = 0; i < n; i++) {
            int snow = Integer.parseInt(scanner.nextLine());
            int time = Integer.parseInt(scanner.nextLine());
            int quality = Integer.parseInt(scanner.nextLine());
            double val = Math.pow((double) (snow / time), (double) quality);     // this is sketch

            if (val > valHigh) {
                snowHigh = snow;
                timeHigh = time;
                qualityHigh = quality;
                valHigh = val;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)", snowHigh, timeHigh, valHigh, qualityHigh);
    }
}
