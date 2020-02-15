package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        try {
            InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties");
            Properties props = new Properties();
            props.load(input);
            System.out.println("input" +  props);
            RestController restController = new RestController();
            String discogsResponse = restController.getDiscogsInfo(props.getProperty("discogsKey"), props.getProperty("discogsSecret"));
            System.out.println(discogsResponse);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

