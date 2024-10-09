package Week4_Methods.More;

import java.util.Arrays;
import java.util.Scanner;

// TODO
// use longs?
// .toLowerCase for string inputs?

public class ArrayManipulator_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("END") && !input[0].equals("end")) {
            if (input[0].equals("exchange")) {
                numsArr = exchange(input, numsArr);
            } else if (input[0].equals("max") && input[1].equals(("odd"))) {
                maxOdd(numsArr);
            } else if (input[0].equals("max") && input[1].equals(("even"))) {
                maxEven(numsArr);
            } else if (input[0].equals("min") && input[1].equals(("odd"))) {
                minOdd(numsArr);
            } else if (input[0].equals("min") && input[1].equals(("even"))) {
                minEven(numsArr);
            } else if (input[0].equals("first") && input[2].equals(("odd"))) {
                firstOdd(input, numsArr);
            } else if (input[0].equals("first") && input[2].equals(("even"))) {
                firstEven(input, numsArr);
            } else if (input[0].equals("last") && input[2].equals(("odd"))) {
                lastOdd(input, numsArr);
            } else if (input[0].equals("last") && input[2].equals(("even"))) {
                lastEven(input, numsArr);
            }
            input = scanner.nextLine().split(" ");
        }
        printArr(numsArr, numsArr.length);

    }

    private static int[] exchange(String[] sArr, int[] nArr) {
        int splitIndex = Integer.parseInt(sArr[sArr.length - 1]);
        // check for valid index
        if (splitIndex < 0 || splitIndex > nArr.length - 1) {
            System.out.println("Invalid index");
            return nArr;
        }
        // if last index return original array. Would be lighter with pointers.
        if (splitIndex == nArr.length - 1) {
            return nArr;
        }
        // temp array of same length
        int[] resultArr = new int[nArr.length];
        // copy elements after split index to temp array head
        for (int i = 0; i < nArr.length - 1 - splitIndex; i++) {
            resultArr[i] = nArr[i + 1 + splitIndex];
        }
        // copy elements from start of array to temp array tail
        for (int i = 0; i <= splitIndex; i++) {
            resultArr[nArr.length - 1 - splitIndex + i] = nArr[i];
        }
        return resultArr;
    }

    private static void maxOdd(int[] nArr) {
        int resultNum = Integer.MIN_VALUE;
        int resultIndex = -1;
        for (int i = 0; i < nArr.length; i++) {
            if (nArr[i] % 2 != 0 && nArr[i] > resultNum) {
                resultNum = nArr[i];
                resultIndex = i;
            }
        }
        if (resultIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(resultIndex);
        }
    }

    private static void maxEven(int[] nArr) {
        int resultNum = Integer.MIN_VALUE;
        int resultIndex = -1;
        for (int i = 0; i < nArr.length; i++) {
            if (nArr[i] % 2 == 0 && nArr[i] > resultNum) {
                resultNum = nArr[i];
                resultIndex = i;
            }
        }
        if (resultIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(resultIndex);
        }
    }

    private static void minOdd(int[] nArr) {
        int resultNum = Integer.MAX_VALUE;
        int resultIndex = -1;
        for (int i = 0; i < nArr.length; i++) {
            if (nArr[i] % 2 != 0 && nArr[i] < resultNum) {
                resultNum = nArr[i];
                resultIndex = i;
            }
        }
        if (resultIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(resultIndex);
        }
    }

    private static void minEven(int[] nArr) {
        int resultNum = Integer.MAX_VALUE;
        int resultIndex = -1;
        for (int i = 0; i < nArr.length; i++) {
            if (nArr[i] % 2 == 0 && nArr[i] < resultNum) {
                resultNum = nArr[i];
                resultIndex = i;
            }
        }
        if (resultIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(resultIndex);
        }
    }

    private static void firstOdd(String[] sArr, int[] nArr) {
        int searchCount = Integer.parseInt(sArr[1]);
        if (searchCount > nArr.length) {
            System.out.println("Invalid count");
            return;
        }
        int[] resultArr = new int[searchCount];
        int resultCounter = 0;

        for (int i = 0; i < nArr.length; i++) {
            if (nArr[i] % 2 != 0 && resultCounter < searchCount) {
                resultArr[resultCounter] = nArr[i];
                resultCounter++;
            }
        }
        printArr(resultArr, resultCounter);
    }

    private static void firstEven(String[] sArr, int[] nArr) {
        int searchCount = Integer.parseInt(sArr[1]);
        if (searchCount > nArr.length) {
            System.out.println("Invalid count");
            return;
        }
        int[] resultArr = new int[searchCount];
        int resultCounter = 0;

        for (int i = 0; i < nArr.length; i++) {
            if (nArr[i] % 2 == 0 && resultCounter < searchCount) {
                resultArr[resultCounter] = nArr[i];
                resultCounter++;
            }
        }
        printArr(resultArr, resultCounter);
    }

    private static void lastOdd(String[] sArr, int[] nArr) {
        int searchCount = Integer.parseInt(sArr[1]);
        if (searchCount > nArr.length) {
            System.out.println("Invalid count");
            return;
        }

        int[] resultArr = new int[searchCount];
        int resultCounter = 0;

        for (int i = 0; i < nArr.length; i++) {
            if (nArr[i] % 2 != 0) {
                if (resultCounter < searchCount) {
                    resultArr[resultCounter] = nArr[i];
                    resultCounter++;
                } else {
                    for (int j = 0; j < resultArr.length - 1; j++) {
                        resultArr[j] = resultArr[j+1];
                    }
                    resultArr[resultArr.length-1] = nArr[i];
                }
            }
        }
        printArr(resultArr, resultCounter);
    }

    private static void lastEven(String[] sArr, int[] nArr) {
        int searchCount = Integer.parseInt(sArr[1]);
        if (searchCount > nArr.length) {
            System.out.println("Invalid count");
            return;
        }

        int[] resultArr = new int[searchCount];
        int resultCounter = 0;

        for (int i = 0; i < nArr.length; i++) {
            if (nArr[i] % 2 == 0) {
                if (resultCounter < searchCount) {
                    resultArr[resultCounter] = nArr[i];
                    resultCounter++;
                } else {
                    for (int j = 0; j < resultArr.length - 1; j++) {
                        resultArr[j] = resultArr[j+1];
                    }
                    resultArr[resultArr.length-1] = nArr[i];
                }
            }
        }
        printArr(resultArr, resultCounter);
    }

    private static void printArr(int[] nArr, int counter) {
//        if(nArr.length ==1 ) {
//            System.out.println(nArr[0]);
//        } else {
            String result = "[";
            for (int i = 0; i < counter; i++) {
                if (i == counter - 1) {
                    result = result + nArr[i];
                } else {
                    result = result + nArr[i] + ", ";
                }
            }
            result = result + "]\n";
            System.out.print(result);
//        }
    }
}
