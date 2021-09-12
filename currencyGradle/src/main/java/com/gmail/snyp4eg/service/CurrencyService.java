package com.gmail.snyp4eg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.snyp4eg.dao.CurrencyDao;
import com.gmail.snyp4eg.model.Currency;
import com.gmail.snyp4eg.service.interfaces.CurrencyExtendedService;

@Service
public class CurrencyService implements CurrencyExtendedService {
    private CurrencyDao currencyDao;

    @Autowired
    public CurrencyService(CurrencyDao currencyDao) {
	this.currencyDao = currencyDao;
    }

    @Override
    public void saveAll(List<Currency> currensys) {
	currensys.stream().forEach(currency -> currencyDao.insert(currency));
    }

    @Override
    public List<Currency> getAll() {
	return currencyDao.getAll();
    }
}
