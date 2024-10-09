package Week6_NestedLoop.Exer;

import java.util.Scanner;

public class TrainTheTrainers_04
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String currPPTtitle = "";
        double currPPTscoreSum = 0.0;
        double currPPTavg = 0.0;
        double allPPTavgSum = 0.0;
        int PPTcounter = 0;

        int nJury = Integer.parseInt(scanner.nextLine());
        double score = 0.0;
        String input = "";

        while (true)
        {
            input = scanner.nextLine();
            if (input.equals("Finish")) { break; }

            currPPTtitle = input;

            for (int i = 1; i <= nJury; i++)
            {
                currPPTscoreSum += Double.parseDouble(scanner.nextLine());
            }

            currPPTavg = currPPTscoreSum / nJury;
            System.out.printf("%s - %.2f.%n", currPPTtitle, currPPTavg);

            allPPTavgSum += currPPTscoreSum;
            ++PPTcounter;
            currPPTtitle = "";
            currPPTscoreSum = 0.0;
        }

        System.out.printf("Student's final assessment is %.2f.", allPPTavgSum / (PPTcounter * nJury));
    }
}
