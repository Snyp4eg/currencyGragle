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
import com.gmail.snyp4eg.model.Operation;
import com.gmail.snyp4eg.reader.PropertyReader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class OperationDaoTest {
    private OperationDao testOperationDao;
    @Autowired
    private JdbcTemplate jdbcTemplateTest;
    @Autowired
    private PropertyReader queryReaderTest;

    @BeforeEach
    public void init() {
	testOperationDao = new OperationDao(jdbcTemplateTest, queryReaderTest);
    }

    @Test
    void shouldReturnExpectedOperationThenGetByIdCalled() {
	Operation expectedOperation = new Operation("322001_840_980_2021-09-01T16:20:35.023", 2659, 2700);
	assertEquals(testOperationDao.getById("322001_840_980_2021-09-01T16:20:35.023"), expectedOperation);
    }

    @Test
    void shouldReturnExpectedOperationListThenGetAllCalled() {
	Operation operationOne = new Operation("322001_840_980_2021-09-01T16:20:35.023", 2659, 2700);
	Operation operationTwo = new Operation("322001_643_980_2021-09-01T16:20:35.023", 28, 32);
	Operation operationThree = new Operation("305299_840_980_2021-09-01T16:20:35.023", 2566, 2672);
	Operation operationFour = new Operation("305299_643_980_2021-09-01T16:20:35.023", 26, 30);
	Operation operationFive = new Operation("999999_840_980_2021-09-01T16:20:35.023", 2685, 2713);
	Operation operationSix = new Operation("999999_643_980_2021-09-01T16:20:35.023", 23, 29);
	List<Operation> expectedOperationList = new ArrayList<>();
	expectedOperationList.add(operationOne);
	expectedOperationList.add(operationTwo);
	expectedOperationList.add(operationThree);
	expectedOperationList.add(operationFour);
	expectedOperationList.add(operationFive);
	expectedOperationList.add(operationSix);
	assertEquals(testOperationDao.getAll(), expectedOperationList);
    }

    @Test
    void shouldCreateNewDataThenInsertNewOperationCalled() {
	Operation addOperation = new Operation("999999_840_980_2021-09-02T17:25:35.023", 2695, 2783);
	testOperationDao.insert(addOperation);
	assertEquals(testOperationDao.getById("999999_840_980_2021-09-02T17:25:35.023"), addOperation);
    }

    @Test
    void shouldUpdateExistDataThenUpdateOperationCalled() {
	Operation updateOperation = new Operation("999999_840_980_2021-09-01T16:20:35.023", 2785, 2813);
	testOperationDao.update(updateOperation);
	assertEquals(testOperationDao.getById("999999_840_980_2021-09-01T16:20:35.023"), updateOperation);
    }

    @Test
    void shouldDeleteExistDataThenDeleteOperationCalled() {
	Operation deleteOperation = new Operation("999999_840_980_2021-09-01T16:20:35.023", 2785, 2813);
	List<Operation> beforeDeleteOperationList = testOperationDao.getAll();
	testOperationDao.delete(deleteOperation);
	List<Operation> afterDeleteOperationList = testOperationDao.getAll();
	assertEquals(beforeDeleteOperationList.size(), afterDeleteOperationList.size() + 1);
    }
}
