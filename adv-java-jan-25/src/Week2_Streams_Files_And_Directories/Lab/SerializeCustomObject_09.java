package Week2_Streams_Files_And_Directories.Lab;

import java.io.*;

public class SerializeCustomObject_09 {
    public static void main(String[] args) {
        Cube cube1 = new Cube("green", 15.3d, 12.4d, 3d);
        Cube cube2 = new Cube("purple", 5.3d, 2.4d, 0.3d);

        String path = "/home/lyubo/Code/SoftUni/softuni-java-full-course/adv-java-jan-25/rsc/04. Java-Advanced-Files-and-Streams-Week3_Functional_Programming.Week3_Defining_Clases.Lab-Resources/save.txt";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))
                ) {
            oos.writeObject(cube1);

            // deserialize
            Object object = ois.readObject();
            if (object instanceof Cube) {
                cube2 = (Cube) object;
            }
            System.out.println();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
