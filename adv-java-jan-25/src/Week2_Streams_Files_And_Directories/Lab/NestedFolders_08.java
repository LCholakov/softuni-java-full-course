package Week2_Streams_Files_And_Directories.Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders_08 {
    public static void main(String[] args) {
        String dirPath = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Lab-Resources";

        File file = new File(dirPath);

        File[] files = file.listFiles(File::isDirectory);
//        for (int i = 0; i < files.length; i++) {
//            if (files[i].isDirectory()) {
//                System.out.printf("%s: [%d]%n", files[i].getName(), files[i].length());
//            }
//        }

        File root = new File(dirPath);
//        System.out.println(root.getName());
        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        int count = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles)
                if (nestedFile.isDirectory())
                    dirs.offer(nestedFile);
            if (current != root) {
                count++;
                System.out.println(current.getName());
            }
        }
        System.out.println(count + " folders");
//        printSubdirs(files);
    }

    public static void printSubdirs(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
                printSubdirs(file.listFiles());
            }
        }
    }
}
