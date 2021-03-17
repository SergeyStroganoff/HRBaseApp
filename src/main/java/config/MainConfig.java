package config;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class MainConfig {
    private static final String CONFIG_NAME = "database.properties";
    private static final Properties MAIN_PROP = new Properties();

    public static void initConfig() throws IOException {


        try (InputStream in = Files.newInputStream(Paths.get(CONFIG_NAME))) {
            MAIN_PROP.load(in);
        }
    }


    public static String getProperty(String property) {
        return MAIN_PROP.getProperty(property);
    }
}
