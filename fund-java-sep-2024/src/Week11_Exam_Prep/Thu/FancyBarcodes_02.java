package Week11_Exam_Prep.Thu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pattern pattern = Pattern.compile("@#+(?<code>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+");
        for (int i = Integer.parseInt(scan.nextLine()); i > 0; i--) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String group = "";
                for (int j = 0; j < input.length(); j++) {
                    char c = input.charAt(j);
                    if(Character.isDigit(c)) {
                        group = group + c;
                    }
                }
                if(group.isBlank()) {
                    group = "00";
                }
                System.out.println("Product group: " + group);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
