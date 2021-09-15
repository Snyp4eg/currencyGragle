package com.gmail.snyp4eg;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.OkHttpClient;
import okhttp3.Request;

@Configuration
public class NetworkConfig {
    protected static final String PRIVATBANK_URL = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

    @Bean
    public OkHttpClient client() {
	return new OkHttpClient();
    }
    
    @Bean
    @Qualifier("privatbank")
    public Request request() {
	return new Request.Builder().url(PRIVATBANK_URL).build();
    }
}
