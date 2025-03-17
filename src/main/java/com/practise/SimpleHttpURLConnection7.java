package com.practise;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleHttpURLConnection7 {
    public static void main(String[] args) {

        BufferedReader read;

        String text;
        StringBuffer content = new StringBuffer();

        try{
            URL url = new URL("https://duty-dash.vercel.app/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("HEAD");


//            conn.setDoOutput(true);

            int statusCode = conn.getResponseCode();
            System.out.println("The status code: "+ statusCode);
            System.out.println();
            long responseSize = conn.getContentLengthLong();
            System.out.println("Response size: "+responseSize);

            System.out.println("Headers: "+conn.getHeaderFields().toString());


            if(!conn.getRequestMethod().equalsIgnoreCase("GET") && responseSize>0) {

                System.out.println("The response body: ");
                if(statusCode >= 200 && statusCode < 300) {
                    read = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((text = read.readLine()) != null) {
                        content.append(text);
                    }
                    read.close();
                    String responseText = content.toString();

                    if(conn.getHeaderField("Content-Type").contains("json")) {
                        JSONObject obj = new JSONObject(responseText);
                        System.out.println("JSON: "+obj.toString());
                    }else{
                        System.out.println(responseText);
                    }
                }
            }

            conn.disconnect();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException iox){
            iox.printStackTrace();
        }
    }
}
