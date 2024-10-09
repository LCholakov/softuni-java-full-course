package Week4_ForLoop.More;

import java.util.Scanner;

public class Hospital_02
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int timeframe = Integer.parseInt(scanner.nextLine());

        int doctorCount = 7;
        int totalPatientCount = 0;
        int untreatedPatientCount = 0;

        for (int i = 1; i <= timeframe; ++i)
        {
            int dailyPatientCount = Integer.parseInt(scanner.nextLine());

            if (i % 3 == 0 && untreatedPatientCount > totalPatientCount - untreatedPatientCount)
            {
                ++doctorCount;
            }
            totalPatientCount += dailyPatientCount;

            if (dailyPatientCount > doctorCount)
            {
                untreatedPatientCount += dailyPatientCount - doctorCount;
            }
        }

        System.out.printf("Treated patients: %d.%n", totalPatientCount - untreatedPatientCount);
        System.out.printf("Untreated patients: %d.", untreatedPatientCount);
    }
}
