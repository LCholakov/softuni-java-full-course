package Week2_Streams_Files_And_Directories.Lab;

import java.io.*;

public class CopyBytes_03 {
    public static void main(String[] args) {
        String inputPath = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Week3_Functional_Programming.Week3_Defining_Clases.Lab-Resources/input.txt";
        String outputPath = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Week3_Functional_Programming.Week3_Defining_Clases.Lab-Resources/03.CopyBytesOutput.txt";

        try (
        InputStream inputStream = new FileInputStream(inputPath);
        OutputStream outputStream = new FileOutputStream(outputPath)
        ) {
            int singleByte = inputStream.read();
            while (singleByte >= 0) {
                if(singleByte == 32 || singleByte == 10) {
                    outputStream.write(singleByte);
                } else {
                    String asciiCode = String.valueOf(singleByte);
                    for (int i = 0; i < asciiCode.length(); i++) {
                        outputStream.write(asciiCode.charAt(i));
                    }
                }

                singleByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
