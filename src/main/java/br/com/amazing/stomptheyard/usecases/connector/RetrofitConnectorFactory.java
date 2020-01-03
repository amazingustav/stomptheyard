package br.com.amazing.stomptheyard.usecases.connector;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class RetrofitConnectorFactory {

    @Value("{spotify.host}") private String spotifyHost;
    @Value("{openWeather.host}") private String openWeatherHost;

    public SpotifyConnector createSpotifyConnector() {
        return adapt(spotifyHost).create(SpotifyConnector.class);
    }

    public OpenWeatherConnector createOpenWeatherConnector() {
        return adapt(openWeatherHost).create(OpenWeatherConnector.class);
    }

    private Retrofit adapt(String host) {
        return new Builder()
            .baseUrl(host)
            .client(new OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}