package Week2_Streams_Files_And_Directories.Lab;

import java.io.Serializable;

public class Cube implements Serializable {
    String color;
    double width;
    double height;
    double depth;

    public Cube(String color, double width, double height, double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
}
