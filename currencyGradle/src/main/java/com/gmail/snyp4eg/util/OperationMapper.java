package com.gmail.snyp4eg.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gmail.snyp4eg.model.Operation;

public class OperationMapper implements RowMapper<Operation> {
    private static final String OPERATION_ID = "operations_id";
    private static final String BUY_PRICE = "buy_price";
    private static final String SELL_PRICE = "sell_price";

    @Override
    public Operation mapRow(ResultSet rs, int rowNum) throws SQLException {
	String operationId = rs.getNString(OPERATION_ID);
	Integer buyPrice = rs.getInt(BUY_PRICE);
	Integer sellPrice = rs.getInt(SELL_PRICE);
	return new Operation(operationId, buyPrice, sellPrice);
    }
}
