package br.com.amazing.stomptheyard.usecases.connector;

import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class RetrofitConnectorFactory {

    public RetrofitConnector create() {
        return new Builder()
                .baseUrl("")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitConnector.class);
    }
}