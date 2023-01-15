package base;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class LoadProperties {
    public static Properties user= loadProperties("D:\\FiveM\\ExtentReport\\src\\main\\java\\properties\\user.properties") ;

    public static Properties loadProperties(String filePath){
        Properties properties=new Properties();
        try {
            FileInputStream fileInputStream=new FileInputStream(filePath);
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getPropertiesValue(String path,String key){
        Properties properties=loadProperties(path);
        String result=" ";

        Set<String> values=properties.stringPropertyNames();
        for(String value: values){

            if(StringUtils.equalsIgnoreCase(value,key)){
            result = properties.getProperty(value);
            break;
            }
        }
        return result;
    }

}
