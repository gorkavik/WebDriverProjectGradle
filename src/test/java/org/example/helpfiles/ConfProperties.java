package org.example.helpfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {

    private static FileInputStream fileInputStream;
    private static Properties properties;
    private final static String PATH_TO_CONFIG = "src/test/resources/conf.properties";

    static {
        try {
            fileInputStream = new FileInputStream(PATH_TO_CONFIG);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка, файл не найден!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка, что-то пошло не так");
            e.getMessage();
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Ошибка, файл не найден!");
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.println("Ошибка, что-то пошло не так");
                    e.getMessage();
                    e.printStackTrace();
                }
        }
    }

    //метод для возврата строки со значением из файла с настройками
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getLogin() {return properties.getProperty("login");}

    public static String getPassword() {return properties.getProperty("password");}
}
