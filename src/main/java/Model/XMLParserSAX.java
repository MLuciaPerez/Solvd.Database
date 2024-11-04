package Model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.logging.Logger;

public class XMLParserSAX {
    private static final String XML_FILE_PATH = "src/main/resources/hospital.xml";
    private static final Logger LOGGER = Logger.getLogger(XMLParserSAX.class.getName());

    public static void parseXML() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    LOGGER.info("Start Element: " + qName);
                }


                public void endElement(String uri, String localName, String qName) throws SAXException {
                    LOGGER.info("End Element: " + qName);
                }


                public void characters(char[] ch, int start, int length) throws SAXException {
                    LOGGER.info("Content: " + new String(ch, start, length));
                }
            };

            saxParser.parse(new File(XML_FILE_PATH), handler);
        } catch (Exception e) {
            LOGGER.severe("An error occurred while parsing XML with SAX: " + e.getMessage());
        }
    }
}