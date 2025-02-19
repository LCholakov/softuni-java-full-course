package Week2_Streams_Files_And_Directories.Lab;

import java.io.*;

public class WriteToFile_02 {
    public static void main(String[] args) {

        String inputPath = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Week3_Functional_Programming.Week3_Defining_Clases.Week3_Generics.Week4_IteratorsAndComparators.Lab-Resources/input.txt";
        String outputPath = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Week3_Functional_Programming.Week3_Defining_Clases.Week3_Generics.Week4_IteratorsAndComparators.Lab-Resources/02.WriteToFileOutput.txt";


        try (
                InputStream inputStream = new FileInputStream(inputPath);
                OutputStream outputStream = new FileOutputStream(outputPath)
        ) {
            int singleByte = inputStream.read();
            while (singleByte >= 0) {
                char c = (char) singleByte;
                if (c != ',' && c != '.' && c != '!' && c != '?') {
                    outputStream.write(singleByte);
                }
                singleByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
