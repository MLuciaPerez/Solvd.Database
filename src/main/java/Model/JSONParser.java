package Model;

import Model.classesHierarchy.Hospital;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JSONParser {

    public static void parseJSON() {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse JSON file to Java object
            Hospital hospital = objectMapper.readValue(new File("src/main/resources/hospital.json"), Hospital.class);

            // Print parsed hospital object
            System.out.println("Hospital parsed from JSON: ");
            System.out.println(hospital);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
