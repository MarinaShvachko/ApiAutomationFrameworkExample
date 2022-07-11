package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BodyGenerator {
    //read data from Json file, convert it to String to use in requests
    public static String generateBodyFromFileToString(String fileName) {
        String generatedBody = "";
        try {
            String filePath = System.getProperty("user.dir") + "\\src\\main\\java\\resourcesForBodies\\" + fileName;
            generatedBody = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return generatedBody;
    }
}
