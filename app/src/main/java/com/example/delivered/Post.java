package com.example.delivered;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.nio.charset.StandardCharsets;


public class Post {

    public void run(final int param){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    request(param);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }


    public void request(int param){
        try {
            java.net.URL url = new java.net.URL("https://api.particle.io/v1/devices/2b003e000447393035313138/LED");
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setRequestProperty("Authorization", "Bearer d23ad1dabfb92b5fba806dbba8da49c8719977f6");
            http.setRequestProperty("Content-Type", "application/json");

            String on = "{\"arg\":\"on\"}";
            String off = "{\"arg\":\"off\"}";

            byte[] out;
            if(param == 1) {
                out = on.getBytes(StandardCharsets.UTF_8);
            }else{
                out = off.getBytes(StandardCharsets.UTF_8);

            }
            java.io.OutputStream stream = null;
            stream = http.getOutputStream();
            stream.write(out);

            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
            http.disconnect();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
