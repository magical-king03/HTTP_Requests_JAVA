package com.practise;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleHttpURLConnection_DELETE_Request {
    public static void main(String[] args) {

        String text;
        StringBuffer content = new StringBuffer();

        try{
            URL url = new URL("https://todo-application-rho-sand.vercel.app/api-tasks/67d859a616b790480b680845");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");

//            conn.setDoOutput(true);

//            int statusCode = conn.getResponseCode();
//            System.out.println("The status code: "+ statusCode);
//            System.out.println();

//            String postData = "{'email': 'john@gmail.com',"+
//        "'firstName': 'John','lastName': 'Doe'}";
//
//            try (OutputStream os = conn.getOutputStream()) {
//                byte[] input = postData.getBytes("UTF-8");
//                os.write(input, 0, input.length);
//            }

            System.out.println("Response code: "+conn.getResponseCode());
            System.out.println("Response body: "+conn.getResponseMessage());

            if(conn.getContentLengthLong()>0) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                    StringBuilder response = new StringBuilder();

                    while ((text = br.readLine()) != null) {
                        response.append(text.trim());
                    }

                    if (conn.getHeaderField("Content-Type").contains("json")) {
                        JSONObject jsonObject = new JSONObject(response.toString());
                        System.out.println("JSON format: " + jsonObject.toString(4));
                    } else {
                        System.out.println(response.toString());
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
