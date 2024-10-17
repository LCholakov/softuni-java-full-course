package Week5_Lists.Exer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if(input[0].equals("End")) { break; }

            switch (input[0]) {
                case "Add" -> numList.add(Integer.parseInt(input[1]));
                case "Insert" -> {
                    int idx = Integer.parseInt(input[2]);
                    if(idx >= 0 && idx <= numList.size()) {
                        numList.add(idx, Integer.parseInt(input[1]));
                    } else {
                        System.out.println("Invalid index");
                    }
                }
                case "Remove" -> {
                    int idx = Integer.parseInt(input[1]);
                    if(idx >= 0 && idx < numList.size()) {
                        numList.remove(idx);
                    } else {
                        System.out.println("Invalid index");
                    }
                }
                case "Shift" -> /*numList = */shiftNum(numList, input[1] , Integer.parseInt(input[2]));
            }
        }

        System.out.println(numList.toString()
                .replaceAll("[\\[\\],]", ""));
    }

    private static void shiftNum(List<Integer> list, String direction, int count) {
        if (direction.equals("left")) {
//            ShiftLeft(list, count);
            for (int i = 0; i < count; i++) {
                list.add(list.get(0));
                list.remove(0);
            }
//            return list;
        } else if (direction.equals("right")) {
//            ShiftRight(list, count);
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
//        return list;
    }

//        ////////////////////////// test someone else's solution ////////////////////
//        Scanner sc=new Scanner(System.in);
//
//        int[] intInputArr=Arrays.stream(sc.nextLine().split(" ")).mapToInt(e->Integer.parseInt(e)).toArray();
//        List<Integer>intList=new ArrayList<Integer>();
//
//        for (int i:intInputArr){
//            intList.add(i);
//        }
//
//        String strInput="";
//        while(!(strInput=sc.nextLine().toLowerCase()).equals("end")){
//            String[] strInputArr=strInput.split(" ");
//            switch (strInputArr[0]){
//                case "add":
//                    int number=Integer.parseInt(strInputArr[1]);
//                    intList.add(number);
//                    break;
//                case "insert":
//                    int indexToInsert=Integer.parseInt(strInputArr[2]);
//                    if (indexToInsert>=0 && indexToInsert<intList.size()){
//                        int numberToInsert=Integer.parseInt(strInputArr[1]);
//                        intList.add(indexToInsert,numberToInsert);
//                    }else{
//                        System.out.println("Invalid index");
//                    }
//                    break;
//                case "remove":
//                    int indexToRemove = Integer.parseInt(strInputArr[1]);
//                    if (indexToRemove>=0 && indexToRemove<intList.size()){
//                        intList.remove(indexToRemove);
//                    }
//                    else{
//                        System.out.println("Invalid index");
//                    }
//                    break;
//                case "shift":
//                    String direction=strInputArr[1];
//                    int count=Integer.parseInt(strInputArr[2]);
//                    if (direction.equals("left")){
//                        ShiftLeft(intList,count);
//                    }else{
//                        ShiftRight(intList,count);
//                    }
//                    break;
//            }
//        }
//
//        for (int i=0;i<intList.size();i++){
//            System.out.printf("%d ",intList.get(i));
//        }
//
//    }
//
    static void ShiftLeft(List<Integer> l,int count){
        for (int shiftStep=0;shiftStep<count;shiftStep++){
            int temp=l.get(0);
            for (int i=0;i<l.size()-1;i++){
                l.set(i,l.get(i+1));
            }
            l.set(l.size()-1,temp);
        }
    }

    static void  ShiftRight(List<Integer> l,int count){

        for (int shiftStep=0;shiftStep<count;shiftStep++){
            int temp=l.get(l.size()-1);
            for (int i=l.size()-1;i>0;i--){
                l.set(i,l.get(i-1));
            }
            l.set(0,temp);
        }
    }
}
