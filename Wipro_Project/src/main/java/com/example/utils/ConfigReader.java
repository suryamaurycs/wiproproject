package com.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\athun\\Downloads\\Program_Prac\\Wipro_Project\\src\\resources\\config.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
