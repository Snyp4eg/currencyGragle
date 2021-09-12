package com.gmail.snyp4eg.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gmail.snyp4eg.config.DaoTestConfig;
import com.gmail.snyp4eg.model.Currency;
import com.gmail.snyp4eg.reader.PropertyReader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class CurrencyDaoTest {
    private CurrencyDao testCurrencyDao;
    @Autowired
    private JdbcTemplate jdbcTemplateTest;
    @Autowired
    private PropertyReader queryReaderTest;

    @BeforeEach
    public void init() {
	testCurrencyDao = new CurrencyDao(jdbcTemplateTest, queryReaderTest);
    }

    @Test
    void shouldReturnExpectedCurrencyThenGetByIdCalled() {
	Currency expectedCurrency = new Currency(980, "UAH");
	assertEquals(testCurrencyDao.getById(980), expectedCurrency);
    }

    @Test
    void shouldReturnExpectedCurrencyListThenGetAllCalled() {
	Currency currencyOne = new Currency(643, "RUB");
	Currency currencyTwo = new Currency(840, "USD");
	Currency currencyThree = new Currency(980, "UAH");
	List<Currency> expectedCurrencysList = new ArrayList<>();
	expectedCurrencysList.add(currencyOne);
	expectedCurrencysList.add(currencyTwo);
	expectedCurrencysList.add(currencyThree);
	assertEquals(testCurrencyDao.getAll(), expectedCurrencysList);
    }

    @Test
    void shouldCreateNewDataThenInsertNewCurrencyCalled() {
	Currency addCurrency = new Currency(999, "WTF");
	testCurrencyDao.insert(addCurrency);
	assertEquals(testCurrencyDao.getById(999), addCurrency);
    }

    @Test
    void shouldUpdateExistDataThenUpdateCurrencyCalled() {
	Currency updateCurrency = new Currency(643, "RUH");
	testCurrencyDao.update(updateCurrency);
	assertEquals(testCurrencyDao.getById(643), updateCurrency);
    }

    @Test
    void shouldDeleteExistDataThenDeleteCurrencyCalled() {
	Currency deleteCurrency = new Currency(643, "RUB");
	List<Currency> beforeDeleteCurrencyList = testCurrencyDao.getAll();
	testCurrencyDao.delete(deleteCurrency);
	List<Currency> afterDeleteCurrencyList = testCurrencyDao.getAll();
	assertEquals(beforeDeleteCurrencyList.size(), afterDeleteCurrencyList.size() + 1);
    }
}
