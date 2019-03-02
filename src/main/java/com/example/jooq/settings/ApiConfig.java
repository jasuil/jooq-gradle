package com.example.jooq.settings;

import com.example.jooq.Dto.jasuilDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.jackson.JacksonConverterFactory;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.*;

import java.util.List;

@Configuration
public class ApiConfig {
    @Autowired
    private ObjectMapper objectMapper;

    private static String config = "http://localhost:8080/";

    @Bean
    public MyAPI myapi() {
        return new Retrofit.Builder()
                .baseUrl(this.config)
                .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()))
                .client(newHttpClient())
                .build()
                .create(MyAPI.class);
    }


    private OkHttpClient newHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        return builder.build();
    }


    public interface MyAPI<T extends Object> {

        @GET("/get1/{id}")
        Call<jasuilDto> get1(@Path("id") String id);

        @GET("/get2")
        Call<List<T>> get2(@Query("from") Long from);


    }

}