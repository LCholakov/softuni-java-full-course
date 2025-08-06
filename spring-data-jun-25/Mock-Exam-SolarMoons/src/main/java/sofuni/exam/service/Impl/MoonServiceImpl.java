package sofuni.exam.service.Impl;

import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Service;
import sofuni.exam.repository.MoonRepository;
import sofuni.exam.service.MoonService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class MoonServiceImpl implements MoonService {

    private final MoonRepository moonRepository;

    public MoonServiceImpl(MoonRepository moonRepository) {
        this.moonRepository = moonRepository;
    }

    @Override
    public boolean areImported() {
        return moonRepository.count() > 0;
    }

    @Override
    public String readMoonsFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/xml/moons.xml"));
    }

    @Override
    public String importMoons() throws IOException, JAXBException {
        return null;
    }

    @Override
    public String exportMoons() {
        return null;
    }
}
