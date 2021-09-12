package com.gmail.snyp4eg.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gmail.snyp4eg.model.Bank;

public class BankMapper implements RowMapper<Bank> {
    private static final String ID = "bank_id";
    private static final String NAME = "bank_name";

    @Override
    public Bank mapRow(ResultSet rs, int rowNum) throws SQLException {
	Integer id = rs.getInt(ID);
	String name = rs.getString(NAME);
	return new Bank(id, name);
    }
}
