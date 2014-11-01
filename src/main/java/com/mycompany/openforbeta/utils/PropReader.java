package com.mycompany.openforbeta.utils;

import java.io.*;
import java.util.Properties;

/**
 * Reads property file
 */
public class PropReader
{
    private static Properties propertyFile;
    private static String propertyFilename = "./src/main/resources/testdata.properties";

    public static String getStringPropertyValue(String key)
    {
        Properties prop = new Properties();
        InputStream input = null;
        String result = "";

        try
        {
            prop.load(new FileInputStream(propertyFilename));
            result = prop.getProperty(key);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if (input != null)
            {
                try
                {
                    input.close();
                }
                catch (IOException e)
                {
                    //Reporter.log("Error while reading config: " + e.getMessage(), 2, true);
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
