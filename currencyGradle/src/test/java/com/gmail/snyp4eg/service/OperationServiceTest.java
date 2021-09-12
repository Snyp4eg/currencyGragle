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
import com.gmail.snyp4eg.dao.OperationDao;
import com.gmail.snyp4eg.model.Operation;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
@SpringBootTest
public class OperationServiceTest {
    private OperationService operationService;
    @Autowired
    OperationDao operationDaoMock;

    @BeforeEach
    public void init() {
	operationService = new OperationService(operationDaoMock);
    }

    @Test
    public void shouldReturnExpectedCurrencysListThenGetAllCalled() {
	List<Operation> operationsFromMock = new ArrayList<>();
	Mockito.when(operationDaoMock.getAll()).thenReturn(operationsFromMock);
	List<Operation> banks = operationService.getAll();
	assertEquals(banks, operationsFromMock);
    }
}
