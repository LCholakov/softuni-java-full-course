package Week5_Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList1 = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> numList2 = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt).collect(Collectors.toList());

        int insertIdx = 1;
        for (int i = 0; i < numList2.size(); i++) {
            if (insertIdx <= numList1.size()) {
                numList1.add(insertIdx, numList2.get(i));
                insertIdx += 2;
            } else {
                numList1.add(numList2.get(i));
            }
        }

        System.out.println(numList1.toString()
                .replaceAll("[\\[\\],]", ""));

//        // Lecture ppt solution
//
//        List<Integer> resultNums = new ArrayList<>();
//        for (int i = 0; i < Math.min(numList1.size(), numList2.size()); i++) {
//            if (i % 2 == 0) {
//                resultNums.add(numList1.get(0));
//                numList1.remove(0);
//            } else {
//                resultNums.add(numList2.get(0));
//                numList2.remove(0);
//            }
//        }
//        if (numList1.size() > numList2.size())
//            resultNums.addAll(getRemainingElements(numList1, numList2));
//        else if (numList2.size() > numList1.size())
//            resultNums.addAll(getRemainingElements(numList2, numList1));
//        System.out.println(resultNums.toString().replaceAll("[\\[\\],]", ""));
    }
//
//    public static List<Integer> getRemainingElements
//            (List<Integer> longerList, List<Integer> shorterList) {
//        List<Integer> nums = new ArrayList<>();
//        for (int i = shorterList.size(); i < longerList.size(); i++)
//            nums.add(longerList.get(i));
//        return nums;
//    }
}
