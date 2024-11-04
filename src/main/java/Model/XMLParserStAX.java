package Model;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;

public class XMLParserStAX {
    private static final Logger logger = Logger.getLogger(XMLParserStAX.class.getName());

    public static void parseXML(String xmlFilePath) {
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = inputFactory.createXMLEventReader(new FileInputStream(new File(xmlFilePath)));

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    logger.info("Start Element: " + event.asStartElement().getName());
                } else if (event.isEndElement()) {
                    logger.info("End Element: " + event.asEndElement().getName());
                } else if (event.isCharacters()) {
                    logger.info("Characters: " + event.asCharacters().getData());
                }
            }
        } catch (Exception e) {
            logger.severe("Error parsing XML with StAX: " + e.getMessage());
        }
    }
}