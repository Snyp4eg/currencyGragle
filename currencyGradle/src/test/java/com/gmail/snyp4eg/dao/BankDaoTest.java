package com.gmail.snyp4eg.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gmail.snyp4eg.config.DaoTestConfig;
import com.gmail.snyp4eg.model.Bank;
import com.gmail.snyp4eg.reader.PropertyReader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class BankDaoTest {
    private BankDao testBankDao;
    @Autowired
    private JdbcTemplate jdbcTemplateTest;
    @Autowired
    private PropertyReader queryReaderTest;

    @BeforeEach
    public void init() {
	testBankDao = new BankDao(jdbcTemplateTest, queryReaderTest);
    }

    @Test
    void shouldReturnExpectedBankThenGetByIdCalled() {
	Bank expectedBank = new Bank(322001, "MONOBANK");
	assertEquals(testBankDao.getById(322001), expectedBank);
    }

    @Test
    void shouldReturnExpectedBankListThenGetAllCalled() {
	Bank bankOne = new Bank(305299, "PRIVATBANK");
	Bank bankTwo = new Bank(322001, "MONOBANK");
	Bank bankThree = new Bank(999999, "NBU");
	List<Bank> expectedBanksList = new ArrayList<>();
	expectedBanksList.add(bankOne);
	expectedBanksList.add(bankTwo);
	expectedBanksList.add(bankThree);
	assertEquals(testBankDao.getAll(), expectedBanksList);
    }

    @Test
    void shouldCreateNewDataThenInsertNewBankCalled() {
	Bank addBank = new Bank(000001, "somebank");
	testBankDao.insert(addBank);
	assertEquals(testBankDao.getById(000001), addBank);
    }

    @Test
    void shouldUpdateExistDataThenUpdateBankCalled() {
	Bank updateBank = new Bank(999999, "NATIONAL BANK OF UKRAINE");
	testBankDao.update(updateBank);
	assertEquals(testBankDao.getById(999999), updateBank);
    }

    @Test
    void shouldDeleteExistDataThenDeleteBankCalled() {
	Bank deleteBank = new Bank(322001, "MONOBANK");
	List<Bank> beforeDeleteBankList = testBankDao.getAll();
	testBankDao.delete(deleteBank);
	List<Bank> afterDeleteBankList = testBankDao.getAll();
	assertEquals(beforeDeleteBankList.size(), afterDeleteBankList.size() + 1);
    }
}
