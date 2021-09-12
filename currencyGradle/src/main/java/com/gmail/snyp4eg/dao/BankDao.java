package com.gmail.snyp4eg.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.gmail.snyp4eg.exception.DaoException;
import com.gmail.snyp4eg.model.Bank;
import com.gmail.snyp4eg.reader.PropertyReader;
import com.gmail.snyp4eg.util.BankMapper;

@Component
public class BankDao implements GenericDao<Bank, Integer> {
    private static final Logger logger = LoggerFactory.getLogger(BankDao.class);
    private static final String GET_BY_ID_KEY = "banks.get-by-id";
    private static final String GET_ALL_KEY = "banks.get-all";
    private static final String INSERT_KEY = "banks.insert";
    private static final String UPDATE_KEY = "banks.update";
    private static final String DELETE_KEY = "banks.delete";
    private JdbcTemplate jdbcTemplate;
    private PropertyReader queryReader;

    @Autowired
    public BankDao(JdbcTemplate jdbcTemplate, PropertyReader queryReader) {
	this.jdbcTemplate = jdbcTemplate;
	this.queryReader = queryReader;
    }

    @Override
    public Bank getById(Integer id) {
	Bank bank;
	try {
	    bank = jdbcTemplate.queryForObject(queryReader.read(GET_BY_ID_KEY), new BankMapper(), id);
	} catch (EmptyResultDataAccessException ex) {
	    logger.error(ex.getMessage(), ex);
	    throw new DaoException(ex);
	}
	return bank;
    }

    @Override
    public List<Bank> getAll() {
	return jdbcTemplate.query(queryReader.read(GET_ALL_KEY), new BankMapper());
    }

    @Override
    public void insert(Bank bank) {
	jdbcTemplate.update(queryReader.read(INSERT_KEY), bank.getBankId(), bank.getBankName());
    }

    @Override
    public void update(Bank bank) {
	jdbcTemplate.update(queryReader.read(UPDATE_KEY), bank.getBankName(), bank.getBankId());
    }

    @Override
    public void delete(Bank bank) {
	jdbcTemplate.update(queryReader.read(DELETE_KEY), bank.getBankId());
    }
}
