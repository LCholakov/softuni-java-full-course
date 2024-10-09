package Week1.Lab;

import java.util.Scanner;

public class ProjectsCreation_07
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String archName = scanner.nextLine();
        int projCount = Integer.parseInt(scanner.nextLine());
        int projTime = projCount * 3;
        System.out.printf("The architect %s will need %d hours to complete %d project/s."
                , archName, projTime, projCount);
    }
}
