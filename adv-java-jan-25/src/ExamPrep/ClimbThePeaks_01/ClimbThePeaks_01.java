package ExamPrep.ClimbThePeaks_01;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbThePeaks_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> peakMap = new LinkedHashMap<>();
        peakMap.put("Vihren", 80);
        peakMap.put("Kutelo", 90);
        peakMap.put("Banski Suhodol", 100);
        peakMap.put("Polezhan", 60);
        peakMap.put("Kamenitza", 70);

        List<String> peakList = new ArrayList<>();
        List<String> conqueredPeakList = new ArrayList<>();
        peakMap.forEach((p, s) -> peakList.add(p));

        ArrayDeque<Integer> foodStack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(foodStack::push);

        ArrayDeque<Integer> staminaQ = Arrays
                .stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (!peakList.isEmpty() && !foodStack.isEmpty() && !staminaQ.isEmpty()) {
            if (foodStack.peek() + staminaQ.peek() >= peakMap.get(peakList.getFirst())) {
                foodStack.pop();
                staminaQ.poll();
                conqueredPeakList.add(peakList.removeFirst());
            } else {
                foodStack.pop();
                staminaQ.poll();
            }
        }

        if (peakList.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (!conqueredPeakList.isEmpty()) {
            System.out.println("Conquered peaks:");
            System.out.println(conqueredPeakList.toString().replaceAll("[\\[\\]]", "").replaceAll(", ", "\n"));
        }
    }
}
