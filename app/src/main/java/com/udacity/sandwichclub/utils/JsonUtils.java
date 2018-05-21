package com.udacity.sandwichclub.utils;


import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {

            JSONObject sandwich_menu = new JSONObject(json);

            // pull up name, mainName

            JSONObject name = sandwich_menu.getJSONObject( "name" );
            String mainName = name.getString( "mainName");

            // pull up alsoKnownAs array and we should use 'for loop' to reach objects in the array

            JSONArray alsoKnownAs = name.getJSONArray( "alsoKnownAs" );
            List<String> alsoKnownAsList = new ArrayList<>();

            for (int i=0; i < alsoKnownAs.length(); i++) {
                alsoKnownAsList.add( alsoKnownAs.getString(i) );
            }

            // pull up placeOfOrigin, description, image

            String placeOfOrigin = sandwich_menu.getString( "placeOfOrigin" );
            String description = sandwich_menu.getString( "description" );
            String image = sandwich_menu.getString( "image" );

            // pull up ingredients array and we should use 'for loop' to reach objects in the array

            JSONArray ingredients = sandwich_menu.getJSONArray( "ingredients" );
            List<String> ingredientsList = new ArrayList<>();

            for (int i = 0; i<ingredients.length(); i++ ) {
                ingredientsList.add( ingredients.getString( i ) );
            }
            // return a new sandwich
            return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList );

        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;

        }

    }

}
