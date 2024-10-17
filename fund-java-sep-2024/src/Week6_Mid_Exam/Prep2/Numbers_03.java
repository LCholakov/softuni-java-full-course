package Week6_Mid_Exam.Prep2;

import java.util.*;

public class Numbers_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numsArr = Arrays
                        .stream(scan.nextLine().split(" "))
                        .mapToInt(e -> Integer.parseInt(e)).toArray();

        List<Integer> resultList = new ArrayList<>();

        int sum = 0;
        for (int n : numsArr) {
            sum += n;
        }
        double avg = 1.0 * sum / numsArr.length;
        for (int n : numsArr) {
            if (n > avg)
                resultList.add(n);
        }
        if (resultList.isEmpty()) {
            System.out.println("No");
        } else {
            Collections.sort(resultList);
            Collections.reverse(resultList);
            while (resultList.size() > 5) {
                resultList.remove(resultList.size() - 1);
            }
            System.out.println(resultList.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
