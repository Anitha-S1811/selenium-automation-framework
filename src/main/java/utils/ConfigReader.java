package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    static{
        loadConfig();
    }

    private static void loadConfig(){
        try{
            properties = new Properties();
            FileInputStream fo = new FileInputStream("src/main/resources/config.properties");
            properties.load(fo);
            System.out.println("Config file loaded properly");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e + " File not found Exception");
        } catch (IOException e) {
            throw new RuntimeException(e + " IO Exception");
        }
    }

    public static String get(String key){
        String value = properties.getProperty(key.toLowerCase());
        if(value == null){
            throw  new RuntimeException("==no key is found in config");
        }
        return value.trim().toLowerCase();
    }
}
