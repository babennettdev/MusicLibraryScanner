package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class RestController {

    public String getDiscogsInfo(String discogsKey, String discogsSecret){
        String output = "";
        try {
            InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties");
            Properties props = new Properties();
            props.load(input);
            System.out.println("input" +  props);
            URL url = new URL("https://api.discogs.com/database/search?q=810599020514");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Discogs key=" + discogsKey + ", secret=" + discogsSecret );

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            output = br.readLine();


            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;

    }
    }

