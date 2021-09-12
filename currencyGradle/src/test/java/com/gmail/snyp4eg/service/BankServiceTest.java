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
import com.gmail.snyp4eg.dao.BankDao;
import com.gmail.snyp4eg.model.Bank;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
@SpringBootTest
public class BankServiceTest {
    private BankService bankService;
    @Autowired
    BankDao bankDaoMock;

    @BeforeEach
    public void init() {
	bankService = new BankService(bankDaoMock);
    }

    @Test
    public void shouldReturnExpectedBanksListThenGetAllCalled() {
	List<Bank> banksFromMock = new ArrayList<>();
	Mockito.when(bankDaoMock.getAll()).thenReturn(banksFromMock);
	List<Bank> banks = bankService.getAll();
	assertEquals(banks, banksFromMock);
    }
}
