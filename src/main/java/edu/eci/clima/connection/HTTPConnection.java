/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.clima.connection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Component;
/**
 *
 * @author 2126081
 */
@Component
public class HTTPConnection {
     private static final String USER_AGENT = "Mozilla/5.0";
    private static String GET_URL = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=d7ed9b673f9a7b2274420a51587ef5f0";

    public String getCityWeather() throws IOException {
        String resp = null;
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            resp = response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
         return resp;
    }
    
    public void setCity (String newCity){
        GET_URL = "https://api.openweathermap.org/data/2.5/weather?q="+newCity+"&appid=d7ed9b673f9a7b2274420a51587ef5f0";
    }
}



