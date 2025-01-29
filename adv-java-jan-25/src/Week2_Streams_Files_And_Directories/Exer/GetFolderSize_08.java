package Week2_Streams_Files_And_Directories.Exer;

import java.io.File;

public class GetFolderSize_08 {
    public static void main(String[] args) {
        String path = "rsc/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";
        File folder = new File(path);

        File[] allFiles = folder.listFiles();
        int folderSize = 0;
        for(File f : allFiles) {
            folderSize += f.length();
        }
        System.out.println("Folder size: " + folderSize);
    }
}
