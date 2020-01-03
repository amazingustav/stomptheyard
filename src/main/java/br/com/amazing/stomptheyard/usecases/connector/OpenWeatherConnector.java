package br.com.amazing.stomptheyard.usecases.connector;


import br.com.amazing.stomptheyard.usecases.entity.WeatherData;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherConnector {

    String openWeatheraAppid = "b6907d289e10d714a6e88b30761fae22";

    @GET("weather")
    public WeatherData weatherFromCity(@Query("q") String city,
                                       @Query("appid") String appid);

    @GET("weather")
    public WeatherData weatherFromCity(@Query("q") String city);
}
