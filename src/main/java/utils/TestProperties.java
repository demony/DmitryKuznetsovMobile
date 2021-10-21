package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private final Properties properties = new Properties();

    public TestProperties() {
        String propertyFilePath = "src//test//resources//test.properties";
        try (FileInputStream fileInputStream = new FileInputStream(propertyFilePath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrlGoogle() {
        return properties.getProperty("urlGoogle");
    }

    public String getUrlIana() {
        return properties.getProperty("urlIana");
    }

    public String getUserName() {
        return properties.getProperty("userName");
    }

    public String getUserEmail() {
        return properties.getProperty("userEmail");
    }

    public String getUserPassword() {
        return properties.getProperty("userPassword");
    }

}
