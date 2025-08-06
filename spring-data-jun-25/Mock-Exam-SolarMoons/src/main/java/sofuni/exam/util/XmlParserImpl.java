package sofuni.exam.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;
import sofuni.exam.models.dto.MoonsImportDto;

import java.io.StringReader;

@Component
public class XmlParserImpl implements XmlParser {

    private final Unmarshaller unmarshaller;

    public XmlParserImpl() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(MoonsImportDto.class);
        unmarshaller = jaxbContext.createUnmarshaller();
    }

    @Override
    public <T> T fromFile(String xml, Class<T> tClass) throws JAXBException {

        try (StringReader reader = new StringReader(xml)) {
            return (T) unmarshaller.unmarshal(reader);
        }
    }
}
