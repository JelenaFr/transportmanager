package com.example.demo.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Location {
    private double longitude;
    private double latitude;
    private String userIpAddress;
    private List<Double> listUserCoordinate;

    public String findUserIpAddress() {
        String userIpAddress = "";
        try {
            URL url = new URL("http://checkip.amazonaws.com/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            userIpAddress = br.readLine();
            System.out.println(userIpAddress);


        } catch (IOException e) {
            e.printStackTrace();

        }
        return userIpAddress;
    }

    public List<Double> findUserCoordinate(String userIpAddress) {
        var listCoord = new ArrayList();
        try {

            String query = "http://api.ipstack.com/" + userIpAddress + "?access_key=8e688f204e498c5f2656bd842268f4df";
            HttpURLConnection connectionAPI = null;
            try {
                connectionAPI = (HttpURLConnection) new URL(query).openConnection();
                connectionAPI.setRequestMethod("GET");
                connectionAPI.setUseCaches(false);
                connectionAPI.setConnectTimeout(250);
                connectionAPI.setReadTimeout(250);
                connectionAPI.connect();
                StringBuilder sb = new StringBuilder();
                if (HttpURLConnection.HTTP_OK == connectionAPI.getResponseCode()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connectionAPI.getInputStream()));
                    String line;
                    while ((line = in.readLine()) != null) {
                        sb.append(line);
                        sb.append("\n");
                    }
                    System.out.println(sb.toString());
                    JSONObject obj = new JSONObject(sb.toString());
                    listCoord.add(obj.getDouble("latitude"));
                    listCoord.add(obj.getDouble("longitude"));

                } else {
                    System.out.println("fail: " + connectionAPI.getResponseCode() + ", " + connectionAPI.getResponseMessage());
                }
            } catch (Throwable cause) {
                cause.printStackTrace();

            } finally {
                if (connectionAPI != null) {
                    connectionAPI.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();


        }

        return listCoord;
    }
}
