package com.cybertek.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {



    private static Properties properties;

    static {

        try {
            // what file to read
            String path = "configuration.properties"; //path is like this cz this file is directly under the project,,we can go and right click and then check for absolute path of this file with pmxml file
            // read the file into java, finds the file using the string path
            FileInputStream input = new FileInputStream(path);//input represents data in configurationproperties
            // properties --> class that store properties in key / value format
            properties = new Properties(); //obecjt
            // the values from the file input is loaded / fed in to the properties object
            properties.load(input);  //loading everything to properties from line 18...putting nd loading  evrything in object (properties..)what ever we created in configuration properties file and saved in input

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {  //key value method..here we put our keys which are in configurationproperties file and whole class runs for that..key=value...browser=chrome,or url=.. ,,locator =..

        return properties.getProperty(keyName);//this will run all the options for that key name..eg browser
        //properties is object...getProperty is method with accepting varibale (input)..to get all the properties of that methiod
    }
}
