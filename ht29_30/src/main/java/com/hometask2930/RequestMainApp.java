package com.hometask2930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/1";

        RequestBody body = new RequestBody(1, 1, "delectus aut autem", false);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInput = objectMapper.writeValueAsString(body);
        
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED){
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                        response.append(line).append("\n");
                    }
                    System.out.println("Response from typicode server");
                    System.out.println(response.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
// String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";
//    try {
//      URL url = new URL(apiUrl);
//      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//      connection.setRequestMethod("GET");
//      connection.setConnectTimeout(5000);

//      int responseCode = connection.getResponseCode();
//      if (responseCode == HttpURLConnection.HTTP_OK){
//          BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//          StringBuilder response = new StringBuilder();
//          String line;
//          while((line = reader.readLine()) != null){
//              response.append(line).append("\n");
//          }
//          reader.close();

//          System.out.println("Response from typicode server");
//          System.out.println(response.toString());
//      }
//    } catch (Exception e) {
//         e.printStackTrace();
//    }
