package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public void fetchPropertyData(String key) throws IOException { //It needs to throw exception in case of issues
        Properties prop = new Properties();
        File f = new File("./notes/AppConfig.properties"); //Find the file

        FileReader fr = new FileReader(f); //Read the file
        prop.load(fr); //Load the file here

        String result = (prop.get("Username")).toString(); //Get a specific value
    }
}
