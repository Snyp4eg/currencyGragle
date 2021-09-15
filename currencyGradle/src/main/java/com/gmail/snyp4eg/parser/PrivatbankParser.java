package com.gmail.snyp4eg.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bluelinelabs.logansquare.*;

import com.gmail.snyp4eg.model.Privatbank;

@Component
public class PrivatbankParser implements Parser<Privatbank> {
    
    public PrivatbankParser(){
    }

    @Override
    public List<Privatbank> parse(String jsonString) {
	List<Privatbank> banks = new ArrayList<>();
	getList(jsonString).stream().forEach(json -> {
	    Privatbank bank = null;
	    try {
		bank = LoganSquare.parse(json, Privatbank.class);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    banks.add(bank);
	});
	return banks;
    }

    private List<String> getList(String jsonString) {
	List<String> jsonList = new ArrayList<>(Arrays.asList(jsonString.split("}")));
	List<String> result = new ArrayList<>();
	jsonList.stream().forEach(json -> {
	    String res;
	    char[] chars = json.toCharArray();
	    if (chars[0] == '[') {
		res = json + "}]";
		result.add(res);
	    }
	    if (chars[0] != ']' && chars[0] == ',') {

		res = "[" + json.substring(1) + "}]";
		result.add(res);
	    }

	});
	return result;
    }

}
