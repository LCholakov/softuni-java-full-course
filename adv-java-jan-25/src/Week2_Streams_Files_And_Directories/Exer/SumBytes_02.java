package Week2_Streams_Files_And_Directories.Exer;

import java.io.*;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
        String inPath = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(inPath));

        String line = bufferedReader.readLine();
        int sum = 0;
        while (line != null) {
            for(char c : line.toCharArray()) {
                sum += c;
            }
            line = bufferedReader.readLine();
        }
        System.out.println(sum);
    }
}
