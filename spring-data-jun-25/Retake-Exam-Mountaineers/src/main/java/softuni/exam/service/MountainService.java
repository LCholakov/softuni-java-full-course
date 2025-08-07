package softuni.exam.service;

import java.io.IOException;

public interface MountainService {

    boolean areImported();

    String readMountainsFileContent() throws IOException;

    String importMountains() throws IOException;

    String exportMountains();
}
