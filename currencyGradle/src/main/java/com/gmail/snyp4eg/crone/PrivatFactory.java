package com.gmail.snyp4eg.crone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gmail.snyp4eg.model.Privatbank;
import com.gmail.snyp4eg.service.BankService;
import com.gmail.snyp4eg.service.CurrencyService;
import com.gmail.snyp4eg.service.OperationService;
import com.gmail.snyp4eg.service.PrivatbankService;

public class PrivatFactory {
    private PrivatbankService privatbankService;
    private OperationService operationService;
    private BankService bankService;
    private CurrencyService currencyService;

    @Autowired
    public PrivatFactory(PrivatbankService privatbankService, OperationService operationService,
	    BankService bankService, CurrencyService currencyService) {
	this.privatbankService = privatbankService;
	this.operationService = operationService;
	this.bankService = bankService;
	this.currencyService = currencyService;
    }

    public void run() {
	List<Privatbank> privatbank = privatbankService.getList();
	
    }
}
