package com.lonnycorn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;

public class SimpleHttpURLConnection {
    public static void main(String[] args) {
        BufferedReader read;
        String text;
        StringBuffer content = new StringBuffer();

        try{
            URL url = new URL("https://duty-dash.vercel.app/");
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
                System.out.println(content.toString());
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
