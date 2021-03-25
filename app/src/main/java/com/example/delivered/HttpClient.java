package com.example.delivered;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpClient {
    public static String sendPost(String url,String param){
        OutputStreamWriter out =null;
        BufferedReader reader = null;
        /*Store Value*/
        String response = "";
        //connection
        try {
            URL httpUrl = null; //HTTP URL
            //create URL
            httpUrl = new URL(url);
            //new connection
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            //conn.setRequestProperty("connection", "keep-alive");
            conn.setUseCaches(false); //No cache
            conn.setInstanceFollowRedirects(true);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            //POST write
            out = new OutputStreamWriter(conn.getOutputStream());
            out.write(param);
            out.flush();
            // Read return from server
            reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), StandardCharsets.UTF_8);
                response += lines;
            }
            reader.close();
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
        return response;
    }
}
