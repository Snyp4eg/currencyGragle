package com.gmail.snyp4eg.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gmail.snyp4eg.model.Currency;

public class CurrencyMapper implements RowMapper<Currency> {
    private static final String ID = "currency_id";
    private static final String NAME = "currency_name";

    @Override
    public Currency mapRow(ResultSet rs, int rowNum) throws SQLException {
	Integer id = rs.getInt(ID);
	String name = rs.getString(NAME);
	return new Currency(id, name);
    }
}