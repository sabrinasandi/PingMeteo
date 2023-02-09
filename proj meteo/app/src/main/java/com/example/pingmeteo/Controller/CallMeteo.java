package com.example.pingmeteo.Controller;

import com.example.pingmeteo.Model.Datatype.*;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.Model.Météo;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public class CallMeteo {
    private static HttpURLConnection connection;
    public static Météo meteoActuel(Lieu location) {BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        String locationText = location.getNom().getValeur();
        Météo météo = null;
        HttpURLConnection connection = null;
        try {

            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + locationText + "&appid=e53301e27efa0b66d05045d91b2742d3&units=metric&lang=fr");
            /*CallAPI callAPI = new CallAPI();
            try {
                String response = callAPI.run("https://api.openweathermap.org/data/2.5/weather?q=" + locationText + "&appid=e53301e27efa0b66d05045d91b2742d3&units=metric&lang=fr");
                // Do something with the response
                météo = parse(response, location);
                return météo;
            } catch (IOException e) {
                e.printStackTrace();
            }
            */

            connection = (HttpURLConnection) url.openConnection();
    
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
    
            int status = connection.getResponseCode();
    
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            // System.out.println(responseContent.toString());
            météo = parse(responseContent.toString(), location);
    
    
    
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
            return météo;
        }
    }
    public static Météo parse (String responseBody, Lieu lieu) throws JSONException {
        JSONObject jsonResponse = new JSONObject(responseBody);

        JSONObject jsonTemp = jsonResponse.getJSONObject("main");
        JSONObject jsonWeather = jsonResponse.getJSONArray("weather").getJSONObject(0);
        JSONObject jsonVent = jsonResponse.getJSONObject("wind");
        JSONObject jsonPluie = null;
        TemperatureType tempActu = new TemperatureType(jsonTemp.getInt("temp"),TemperatureUnit.CELSIUS );



        VitesseType vitesseVent = new VitesseType(jsonVent.getInt("speed"),jsonVent.getInt("deg"));
        VentType ventType = new VentType(vitesseVent);

        PluieType pluie = null;
        try {
            jsonPluie = jsonResponse.getJSONObject("rain");
            pluie = new PluieType(jsonPluie.getInt("1h"),jsonWeather.getString("description"));
        } catch (JSONException e) {
            pluie = new PluieType(0, jsonWeather.getString("description"));
        }

        return new Météo(lieu, tempActu,pluie,ventType);

    }


    
}
