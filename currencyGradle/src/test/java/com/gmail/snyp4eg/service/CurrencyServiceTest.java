package com.gmail.snyp4eg.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gmail.snyp4eg.config.ServiceTestConfig;
import com.gmail.snyp4eg.dao.CurrencyDao;
import com.gmail.snyp4eg.model.Currency;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
@SpringBootTest
public class CurrencyServiceTest {
    private CurrencyService currencyService;
    @Autowired
    CurrencyDao currencyDaoMock;

    @BeforeEach
    public void init() {
	currencyService = new CurrencyService(currencyDaoMock);
    }

    @Test
    public void shouldReturnExpectedCurrencysListThenGetAllCalled() {
	List<Currency> currencysFromMock = new ArrayList<>();
	Mockito.when(currencyDaoMock.getAll()).thenReturn(currencysFromMock);
	List<Currency> banks = currencyService.getAll();
	assertEquals(banks, currencysFromMock);
    }
}
