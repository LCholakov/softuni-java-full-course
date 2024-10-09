package Week4_ForLoop.Exer;

import java.util.Scanner;

public class TrekkingMania_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numGroups = Integer.parseInt(scanner.nextLine());

        int pplTotal = 0;
        int pplMusala = 0;
        int pplMonthBlanc = 0;
        int pplKilimanjaro = 0;
        int pplK2 = 0;
        int pplEverest = 0;

        double p1_Musala = 0.0;
        double p2_MontBlanc = 0.0;
        double p3_Kilimanjaro = 0.0;
        double p4_K2 = 0.0;
        double p5_Everest = 0.0;

        for (int i = 0; i < numGroups; ++i)
        {
            int n_i = Integer.parseInt(scanner.nextLine());
            pplTotal += n_i;

            if (n_i <= 5)
                pplMusala += n_i;
            else if (n_i <= 12)
                pplMonthBlanc += n_i;
            else if (n_i <= 25)
                pplKilimanjaro += n_i;
            else if (n_i <= 40)
                pplK2 += n_i;
            else
                pplEverest += n_i;
        }

        p1_Musala = 100.0 * pplMusala / pplTotal;
        p2_MontBlanc = 100.0 * pplMonthBlanc / pplTotal;
        p3_Kilimanjaro = 100.0 * pplKilimanjaro / pplTotal;
        p4_K2 = 100.0 * pplK2 / pplTotal;
        p5_Everest = 100.0 * pplEverest / pplTotal;

        System.out.printf("%.2f%%%n", p1_Musala);
        System.out.printf("%.2f%%%n", p2_MontBlanc);
        System.out.printf("%.2f%%%n", p3_Kilimanjaro);
        System.out.printf("%.2f%%%n", p4_K2);
        System.out.printf("%.2f%%%n", p5_Everest);
    }
}
