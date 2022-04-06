package com.example.weather.service;

import com.example.weather.model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiInterface {

    @GET("/data/2.5")
    Call<Weather> getEverythingWeatherBySearch(@Query("city") String city, @Query("apiKey")String apiKey);
}
