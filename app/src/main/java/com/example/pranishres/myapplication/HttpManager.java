package com.example.pranishres.myapplication;

import android.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by pranishres on 11/9/16.
 * Makes http requests
 * Uses Standard java HttpURLConnection class as AndroidHttpClient has deprecated
 */

public class HttpManager {

    public static String getData(String uri){
        BufferedReader reader = null;

        try {
            URL url = new URL(uri);
            String line;

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            while((line = reader.readLine()) != null){
                sb.append(line + "\n");
            }

            return sb.toString();

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    // Method overloading
    public static String getData(String uri, String username, String password){
        BufferedReader reader = null;
        HttpURLConnection httpURLConnection = null;

        // Creating object that contains credentials
        byte[] loginBytes = (username + ":" + password).getBytes();
        StringBuilder loginBuilder = new StringBuilder()
                .append("Basic ")
                .append(Base64.encodeToString(loginBytes, Base64.DEFAULT));

        try {
            URL url = new URL(uri);
            String line;

            httpURLConnection = (HttpURLConnection) url.openConnection();

            /* Adding credentials object to httpConnection request. This is the same as providing username and password
            in "Authorization" tab in postman */
            httpURLConnection.addRequestProperty("Authorization", loginBuilder.toString());

            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            while((line = reader.readLine()) != null){
                sb.append(line + "\n");
            }

            return sb.toString();

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

}
