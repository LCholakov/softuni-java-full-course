package Week2_Streams_Files_And_Directories.Lab;

import java.io.File;

public class ListFiles_07 {
    public static void main(String[] args) {
        String dirPath = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Week3_Functional_Programming.Week3_Defining_Clases.Week3_Generics.Week4_IteratorsAndComparators.Lab-Resources/Files-and-Streams";

        File file = new File(dirPath);

        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.printf("%s: [%d]%n", files[i].getName(), files[i].length());
            }
        }
    }
}
