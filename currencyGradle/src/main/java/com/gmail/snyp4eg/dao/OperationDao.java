package com.gmail.snyp4eg.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.gmail.snyp4eg.exception.DaoException;
import com.gmail.snyp4eg.model.Operation;
import com.gmail.snyp4eg.reader.PropertyReader;
import com.gmail.snyp4eg.util.OperationMapper;

@Component
public class OperationDao implements OperationsExtendedDao {
    private static final Logger logger = LoggerFactory.getLogger(OperationDao.class);
    private static final String GET_BY_ID_KEY = "operations.get-by-id";
    private static final String GET_ALL_KEY = "operations.get-all";
    private static final String INSERT_KEY = "operations.insert";
    private static final String UPDATE_KEY = "operations.update";
    private static final String DELETE_KEY = "operations.delete";
    private JdbcTemplate jdbcTemplate;
    private PropertyReader queryReader;

    @Autowired
    public OperationDao(JdbcTemplate jdbcTemplate, PropertyReader queryReader) {
	this.jdbcTemplate = jdbcTemplate;
	this.queryReader = queryReader;
    }

    @Override
    public Operation getById(String id) {
	Operation operation;
	try {
	    operation = jdbcTemplate.queryForObject(queryReader.read(GET_BY_ID_KEY), new OperationMapper(), id);
	} catch (EmptyResultDataAccessException ex) {
	    logger.error(ex.getMessage(), ex);
	    throw new DaoException(ex);
	}
	return operation;
    }

    @Override
    public List<Operation> getAll() {
	return jdbcTemplate.query(queryReader.read(GET_ALL_KEY), new OperationMapper());
    }

    @Override
    public void insert(Operation operation) {
	jdbcTemplate.update(queryReader.read(INSERT_KEY), operation.getOperationId(), operation.getBuyPrice(),
		operation.getSellPrice());
    }

    @Override
    public void update(Operation operation) {
	jdbcTemplate.update(queryReader.read(UPDATE_KEY), operation.getBuyPrice(),
		operation.getSellPrice(), operation.getOperationId());
	}

    @Override
    public void delete(Operation operation) {
	jdbcTemplate.update(queryReader.read(DELETE_KEY), operation.getOperationId());
    }
}
