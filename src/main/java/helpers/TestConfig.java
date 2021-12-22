package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {
    protected static FileInputStream fileInputStream;
    protected static Properties visualProperties;

    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/visual.properties");
            visualProperties = new Properties();
            visualProperties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getProperty(String key) {
        return visualProperties.getProperty(key);
    }
}
