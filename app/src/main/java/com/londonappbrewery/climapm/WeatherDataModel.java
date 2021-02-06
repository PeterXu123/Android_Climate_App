package com.londonappbrewery.climapm;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataModel {

    // TODO: Declare the member variables here
    private String mTemperature, mCity, mIconName;
    private int mCondition;


    // TODO: Create a WeatherDataModel from a JSON:
    public static WeatherDataModel frommJson(JSONObject jsonObject) {
        WeatherDataModel data = new WeatherDataModel();
        try {
            data.mCity = jsonObject.getString("name");
            data.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            data.mIconName = updateWeatherIcon(data.mCondition);
            Log.d("Wtf", String.valueOf(jsonObject.getJSONObject("main").getDouble("temp")));
            double tempResult = (((jsonObject.getJSONObject("main").getDouble("temp") - 273.15) * ( 9.0 / 5.0) + 32) - 32) * 5.0 / 9.0;
            int roundedValue = (int) Math.rint(tempResult);
            data.mTemperature = String.valueOf(roundedValue);
            return data;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }


    // TODO: Uncomment to this to get the weather image name from the condition:
    private static String updateWeatherIcon(int condition) {

        if (condition >= 0 && condition < 300) {
            return "tstorm1";
        } else if (condition >= 300 && condition < 500) {
            return "light_rain";
        } else if (condition >= 500 && condition < 600) {
            return "shower3";
        } else if (condition >= 600 && condition <= 700) {
            return "snow4";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition < 800) {
            return "tstorm3";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloudy2";
        } else if (condition >= 900 && condition <= 902) {
            return "tstorm3";
        } else if (condition == 903) {
            return "snow5";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "tstorm3";
        }

        return "dunno";
    }

    // TODO: Create getter methods for temperature, city, and icon name:


    public String getmTemperature() {
        return mTemperature + "°C";
    }

    public void setmTemperature(String mTemperature) {
        this.mTemperature = mTemperature;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

    public String getmIconName() {
        return mIconName;
    }

    public void setmIconName(String mIconName) {
        this.mIconName = mIconName;
    }

    public int getmCondition() {
        return mCondition;
    }

}
