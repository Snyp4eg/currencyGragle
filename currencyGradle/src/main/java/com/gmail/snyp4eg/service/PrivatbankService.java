package com.gmail.snyp4eg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.snyp4eg.model.Privatbank;
import com.gmail.snyp4eg.network.PrivatbankPublicApi;
import com.gmail.snyp4eg.parser.PrivatbankParser;

@Service
public class PrivatbankService {
    private PrivatbankPublicApi privatbankPublicApi;
    private PrivatbankParser privatbankParser;

    @Autowired
    public PrivatbankService(PrivatbankPublicApi privatbankPublicApi, PrivatbankParser privatbankParser) {
	this.privatbankPublicApi = privatbankPublicApi;
	this.privatbankParser = privatbankParser;
    }
    
    public List<Privatbank> getList() {
	String jSon = privatbankPublicApi.getData();
	return privatbankParser.parse(jSon);
    }

}
