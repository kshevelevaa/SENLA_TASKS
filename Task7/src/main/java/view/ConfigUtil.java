package view;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
    public static final String PATH_TO_PROPERTIES = "D:\\JavaCourse\\Task7\\src\\main\\resources\\app.properties";

    public static Properties getProperties() {
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            return prop;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
