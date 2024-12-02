package com.hometask2930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class RequestMainApp {
    public static void main( String[] args ) throws JsonProcessingException{
        String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if(responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED){
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                        response.append(line).append("\n");
                    }

                    System.out.println("Response from typicode server:");
                    System.out.println(response.toString());

                    System.out.println("Parsed response:");
                    System.out.println(objectMapper.readValue(response.toString(), RequestBody.class));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}