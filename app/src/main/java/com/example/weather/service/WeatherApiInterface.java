package com.example.weather.service;

import com.example.weather.model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiInterface {

    @GET("weather")
    Call<Weather> getEverythingWeatherBySearch(@Query("q") String q, @Query("appid")String apiKey);
}
