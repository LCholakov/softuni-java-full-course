package Week9_Bitwise_And_Text_Processing.Lab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextFilter_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] banArr = scan.nextLine().split(", ");

        String txt = scan.nextLine();

//        for (String word : banArr) {
//            while (txt.indexOf(word) != -1) {
//                String temp = "";
//                for (int i = 0; i < word.length(); i++) {
//                    temp = temp + "*";
//                }
//                txt = txt.replace(word, temp);
//            }
//        }

        HashMap<String, String> banMap = new HashMap<>();
        for (String word : banArr) {
            String tempVal = "";
            for (int i = 0; i < word.length(); i++) {
                tempVal = tempVal + "*";
            }
            banMap.put(word, tempVal);
        }
        for(Map.Entry<String, String> entry : banMap.entrySet()) {
            while (txt.contains(entry.getKey())) {
                txt = txt.replace(entry.getKey(), entry.getValue());
            }
        }

        System.out.println(txt);
    }
}
