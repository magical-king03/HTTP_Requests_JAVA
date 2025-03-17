package com.practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;

import org.json.JSONArray;

public class SimpleHttpURLConnection_GET_Request {
    public static void main(String[] args) {
        BufferedReader read;
        String text;
        StringBuffer content = new StringBuffer();

        try{
            URL url = new URL("https://todo-application-rho-sand.vercel.app/api-tasks");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            int statusCode = conn.getResponseCode();
            System.out.println("The status code: "+ statusCode);
            System.out.println();

            System.out.println("Returned Headers: \n" + conn.getHeaderFields());
            System.out.println("Content size: " + conn.getHeaderField("Content-Length"));
            System.out.println("Content type: " + conn.getHeaderField("Content-Type"));
            System.out.println();

            System.out.println("The response body is ");
            if(statusCode >= 200 && statusCode < 300){
                read = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((text = read.readLine()) != null) {
                    content.append(text);
                }
                read.close();

                String responseText = content.toString();

                if(conn.getHeaderField("Content-Type").contains("json")){
                    JSONArray jsonArray = new JSONArray(responseText);
                    System.out.println("JSON format : \n" + jsonArray.toString(4));
                }else{
                    System.out.println(responseText);
                }
                System.out.println("\n" + content.toString());
            }else{
                System.out.println("The request failed " + conn.getResponseMessage());
            }

            conn.disconnect();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException iox){
            iox.printStackTrace();
        }
    }
}
