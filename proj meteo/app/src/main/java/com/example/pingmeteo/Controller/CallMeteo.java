package com.example.pingmeteo.Controller;

import android.util.Log;

import com.example.pingmeteo.Model.Datatype.*;
import com.example.pingmeteo.Model.Lieu;
import com.example.pingmeteo.Model.Météo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

public class CallMeteo {
    private static HttpURLConnection connection;
    public static Météo meteoActuel(Lieu location) {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        String locationText = location.getNom().getValeur();
        Météo météo = null;
        HttpURLConnection connection = null;
        try {

            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + locationText + "&appid=e53301e27efa0b66d05045d91b2742d3&units=metric&lang=fr");

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



    public static ArrayList<Météo> meteoAVenir(Lieu location) {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        String locationText = "lat="+location.getPosition().getLatitute()+"&lon=" + location.getPosition().getLongitude();
        ArrayList<Météo> meteoList = new ArrayList<Météo>();
        HttpURLConnection connection = null;

        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?" + locationText  + "&appid=02ea4280e22d565ee897479a4054211a&units=metric&lang=fr");
            Log.d("MeteoLieuAsyncTask", "Making API call to URL: " + url.toString());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            Log.d("MeteoLieuAsyncTask", "Response code: " + connection.toString()); // READ
            int status = connection.getResponseCode();
            Log.d("MeteoLieuAsyncTask", "Response code: " + status); // NOT READ
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                Log.d("status > 299", "reader code: " + reader);
                while ((line = reader.readLine()) != null) {
                    Log.d("status > 299", "Response code: " + line);
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                Log.d("status > 299", "reader code: " + reader);
                while ((line = reader.readLine()) != null) {
                    Log.d("status < 299", "Response code: " + line);
                    responseContent.append(line);
                }
                reader.close();
            }

            JSONObject jsonResponse = new JSONObject(responseContent.toString());
            Log.d("jsonResponse", "Response code: " + jsonResponse);
            JSONArray jsonList = jsonResponse.getJSONArray("list");
            for (int i = 0; i < jsonList.length(); i++) {
                JSONObject jsonForecast = jsonList.getJSONObject(i);
                Météo meteo = parse(jsonForecast.toString(), location);
                meteoList.add(meteo);
            }
        } catch (MalformedURLException e) {
            Log.e("MeteoLieuAsyncTask", "Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            Log.e("MeteoLieuAsyncTask", "IOException: " + e.getMessage());
        } catch (JSONException e) {
            Log.e("MeteoLieuAsyncTask", "JSONException: " + e.getMessage());
        }catch (Exception e) {
        Log.e("MeteoLieuAsyncTask", "Exception: " + e.getMessage());
            e.printStackTrace();
    }
        finally {
            if (connection != null) {
                connection.disconnect();
            }
            return meteoList;
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
        Météo resultat = new Météo(lieu, tempActu,pluie,ventType);

        try {
            resultat.setDateToString(jsonResponse.getString("dt_txt"));
            System.out.println(jsonResponse.getJSONObject("dt_txt"));
        } catch (JSONException e){

        }

        return resultat;

    }


    
}
