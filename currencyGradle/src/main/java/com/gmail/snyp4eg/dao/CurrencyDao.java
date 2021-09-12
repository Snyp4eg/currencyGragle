package com.gmail.snyp4eg.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.gmail.snyp4eg.exception.DaoException;
import com.gmail.snyp4eg.model.Currency;
import com.gmail.snyp4eg.reader.PropertyReader;
import com.gmail.snyp4eg.util.CurrencyMapper;

@Component
public class CurrencyDao implements GenericDao<Currency, Integer>{
    private static final Logger logger = LoggerFactory.getLogger(BankDao.class);
    private static final String GET_BY_ID_KEY = "currency.get-by-id";
    private static final String GET_ALL_KEY = "currency.get-all";
    private static final String INSERT_KEY = "currency.insert";
    private static final String UPDATE_KEY = "currency.update";
    private static final String DELETE_KEY = "currency.delete";
    private JdbcTemplate jdbcTemplate;
    private PropertyReader queryReader;
    
    @Autowired
    public CurrencyDao(JdbcTemplate jdbcTemplate, PropertyReader queryReader) {
	this.jdbcTemplate = jdbcTemplate;
	this.queryReader = queryReader;
    }

    @Override
    public Currency getById(Integer id) {
	Currency currency;
	try {
	    currency = jdbcTemplate.queryForObject(queryReader.read(GET_BY_ID_KEY), new CurrencyMapper(), id);
	} catch (EmptyResultDataAccessException ex) {
	    logger.error(ex.getMessage(), ex);
	    throw new DaoException(ex);
	}
	return currency;
    }

    @Override
    public List<Currency> getAll() {
	return jdbcTemplate.query(queryReader.read(GET_ALL_KEY), new CurrencyMapper());
    }

    @Override
    public void insert(Currency currency) {
	jdbcTemplate.update(queryReader.read(INSERT_KEY), currency.getCurrencyId(), currency.getCurrencyName());
    }

    @Override
    public void update(Currency currency) {
	jdbcTemplate.update(queryReader.read(UPDATE_KEY), currency.getCurrencyName(), currency.getCurrencyId());
    }

    @Override
    public void delete(Currency currency) {
	jdbcTemplate.update(queryReader.read(DELETE_KEY), currency.getCurrencyId());
    }
}
