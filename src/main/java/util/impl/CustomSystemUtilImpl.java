package util.impl;

import util.CustomSystemUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CustomSystemUtilImpl implements CustomSystemUtil {

    @Override
    public boolean isNumeric(String regNum) {
        return regNum.matches("^[^0]\\d{2,4}$");
    }

    @Override
    public void delay(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getPropertyValue(String propertyName) {
        String propertyValue = "";
        Properties properties = new Properties();

        try (InputStream inputStream = this.getClass().getResourceAsStream("/app.properties")) {
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyName);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return propertyValue;
    }
}
