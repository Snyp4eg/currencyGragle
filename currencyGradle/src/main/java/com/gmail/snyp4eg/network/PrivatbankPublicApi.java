package com.gmail.snyp4eg.network;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Component
public class PrivatbankPublicApi implements BankPublicApi {
    OkHttpClient client;
    Request request;

    @Autowired
    public PrivatbankPublicApi(OkHttpClient client, @Qualifier("privatbank") Request request) {
	this.client = client;
	this.request = request;
    }

    @Override
    public String getData() {
	String result = null;
	try (Response response = client.newCall(request).execute()) {
	    result = response.body().string();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return result;
    }
}
