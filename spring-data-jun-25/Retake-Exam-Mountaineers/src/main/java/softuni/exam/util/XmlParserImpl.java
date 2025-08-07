package softuni.exam.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;

public class XmlParserImpl implements XmlParser {
    private final Unmarshaller unmarshaller;
    public XmlParserImpl() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(MountaineersImportDto.class);
        unmarshaller = jaxbContext.createUnmarshaller();
    }
    @Override
    public <T> T fromXml(String xml, Class<T> tClass) throws JAXBException {
        try(StringReader reader = new StringReader(xml)){
            return (T) unmarshaller.unmarshal(reader);
        }
    }
}
