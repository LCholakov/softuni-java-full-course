package Week11_Exam_Prep.Wed;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern pattern = Pattern.compile("([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(scan.nextLine());
        ArrayList<String> destList = new ArrayList<>();
        int travelPoints = 0;
        while (matcher.find()) {
            String match = matcher.group("destination");
            destList.add(match);
            travelPoints += match.length();
        }
        System.out.println("Destinations: " + String.join(", ", destList));
        System.out.println("Travel Points: " + travelPoints);
    }
}
