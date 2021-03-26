package com.example.delivered;

import android.widget.Toast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpClient {
    public static String send(final String url, final String param){
        final String[] jsonStr = {"Default"};
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    jsonStr[0] = sendPost(url, param);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return jsonStr[0];
    }

    private static String sendPost(String url,String param){
        OutputStreamWriter out =null;
        BufferedReader reader = null;
        /*Store Value*/
        StringBuilder response = new StringBuilder();
        //connection
        try {
            URL httpUrl = null; //HTTP URL
            //create URL
            httpUrl = new URL(url);
            //new connection
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer d23ad1dabfb92b5fba806dbba8da49c8719977f6");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setUseCaches(false); //No cache
            conn.setInstanceFollowRedirects(true);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            //POST write
            out = new OutputStreamWriter(conn.getOutputStream());
            out.write(param);
            out.flush();
            //Read return from server
            reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), StandardCharsets.UTF_8);
                response.append(lines);
            }
            reader.close();
            if (conn.getResponseCode() == 200){
                System.out.println("POST CODE 200");
                System.out.println(response);
            }
            // Close Connection
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("HTTP POST Exception"+e);
            e.printStackTrace();
        }
        //Turn off Input Stream and Output Stream
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(reader!=null){
                    reader.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(String.valueOf(response));
        String str = "";
        if (element.isJsonObject()) {
            JsonObject object = element.getAsJsonObject();

            str = object.get("return_value").getAsString();
        }

        return str;
    }
}
