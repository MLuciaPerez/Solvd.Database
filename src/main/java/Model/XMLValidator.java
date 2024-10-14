package Model;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class XMLValidator {
    private static final String XSD_FILE_PATH = "src/main/resources/hospital.xsd";
    private static final Logger LOGGER = Logger.getLogger(XMLValidator.class.getName());

    public static void validateXML(String xmlFilePath) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new File(XSD_FILE_PATH));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFilePath)));
            LOGGER.info("XML file is valid.");
        } catch (SAXException e) {
            LOGGER.info("XML file is not valid: " );
        } catch (IOException e) {
            LOGGER.info("IO exception occurred during XML validation");
        }
    }
}