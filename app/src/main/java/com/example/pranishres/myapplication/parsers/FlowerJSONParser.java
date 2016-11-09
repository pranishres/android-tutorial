package com.example.pranishres.myapplication.parsers;

import com.example.pranishres.myapplication.model.Flower;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pranishres on 11/9/16.
 *Parsing JSON contents into "Flower" model object
 */

public class FlowerJSONParser {

    /**
     * Gets the raw JSON contents, parses it to "Flower" model object and returns the list of the parsed
     * "Flower" object
     * This method uses JSONArray and JSONObject class
     * @param content - raw JSON content
     * @return List of JSON parsed "Flower" model objects
     */
    public static List<Flower> parseFeed(String content){
        try {
            // Create a jsonArray and pass in the content
            JSONArray jsonArray = new JSONArray(content);

            // A Flower list to return a list of JSON parsed Flower object
            List<Flower> flowerList = new ArrayList<>();

            // Looping through the Json Array
            for(int i = 0 ; i < jsonArray.length() ; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Flower flower = new Flower();
                flower.setProductId(jsonObject.getInt("productId"));
                flower.setCategory(jsonObject.getString("category"));
                flower.setName(jsonObject.getString("name"));
                flower.setInstructions(jsonObject.getString("instructions"));
                flower.setPrice(Double.parseDouble(jsonObject.getString("price")));
                flower.setPhoto(jsonObject.getString("photo"));

                flowerList.add(flower);
            }

            return flowerList;

        }catch(JSONException e){
            e.printStackTrace();
            return null;
        }

    }

}
