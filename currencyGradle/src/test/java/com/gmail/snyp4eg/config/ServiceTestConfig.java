package com.gmail.snyp4eg.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gmail.snyp4eg.dao.BankDao;
import com.gmail.snyp4eg.dao.CurrencyDao;
import com.gmail.snyp4eg.dao.OperationDao;

@Configuration
public class ServiceTestConfig {

    @Bean
    public BankDao bankDaoMock() {
	return Mockito.mock(BankDao.class);
    }
    
    @Bean
    public CurrencyDao currencyDaoMock() {
	return Mockito.mock(CurrencyDao.class);
    }
    
    @Bean
    public OperationDao operationDaoMock() {
	return Mockito.mock(OperationDao.class);
    }
}
