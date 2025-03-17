package com.lonnycorn;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleHttpURLConnection3 {
    public static void main(String[] args) {

        String text;
        StringBuffer content = new StringBuffer();

        try{
            URL url = new URL("https://todo-application-rho-sand.vercel.app/add-task");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

//            int statusCode = conn.getResponseCode();
//            System.out.println("The status code: "+ statusCode);
//            System.out.println();

            String postData = "{\"taskDesc\":\"Complete the assigned courses. Go through Java backend very clearly.\",\"taskDate\":\"2025-03-21T00:00:00.000Z\",\"addedBy\":\"visweish80@gmail.com\",\"taskName\":\"Complete the courses.\"}";


            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = postData.getBytes("UTF-8");
                os.write(input, 0, input.length);
            }

            System.out.println("Response code: "+conn.getResponseCode());
            System.out.println("Response body: "+conn.getResponseMessage());

            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                StringBuilder response = new StringBuilder();

                while ((text = br.readLine()) != null) {
                    response.append(text.trim());
                }

                if(conn.getHeaderField("Content-Type").contains("json")){
                    JSONObject jsonObject = new JSONObject(response.toString());
                    System.out.println("JSON format: " + jsonObject.toString(4));
                }else{
                    System.out.println(response.toString());
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
