package Week2_Streams_Files_And_Directories.Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile_01 {
    public static void main(String[] args) {

        String fpath = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Week3_Functional_Programming.Week3_Defining_Clases.Lab-Resources/input.txt";

        try (InputStream inputStream = new FileInputStream(fpath);){

            int oneByte = inputStream.read();

            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");

                oneByte = inputStream.read();
            }

        } catch (IOException exception) {
            System.out.println("File not found");
            exception.printStackTrace();

        } finally {
            System.out.println();

        }

    }
}
