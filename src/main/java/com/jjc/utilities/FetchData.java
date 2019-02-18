package com.jjc.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.util.Random;

public class FetchData {

    public static JSONObject getRandomUser() throws Exception {
    	
    	int randomInt = new Random().nextInt(10) + 1;

    	// Initialize the connection.
        String url = "https://jsonplaceholder.typicode.com/users/" + randomInt;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        
        // Set request headers.
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con. getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Convert the string response to JSON and return.
        JSONObject jsonResponse = new JSONObject(response.toString());
        return jsonResponse;
    }
}
