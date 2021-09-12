package com.gmail.snyp4eg.model;

public class Operation {
    private String operationId;
    private Integer buyPrice;
    private Integer sellPrice;

    public Operation() {
    }

    public Operation(String operationId, Integer buyPrice, Integer sellPrice) {
	this.setOperationId(operationId);
	this.setBuyPrice(buyPrice);
	this.setSellPrice(sellPrice);
    }

    public String getOperationId() {
	return operationId;
    }

    public void setOperationId(String operationId) {
	this.operationId = operationId;
    }

    public Integer getBuyPrice() {
	return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
	this.buyPrice = buyPrice;
    }

    public Integer getSellPrice() {
	return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
	this.sellPrice = sellPrice;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	Operation operation = (Operation) o;
	return (this.operationId.equals(operation.operationId) && this.buyPrice.equals(operation.buyPrice)
		&& this.sellPrice.equals(operation.sellPrice));
    }

    @Override
    public int hashCode() {
	int result = 17;
	result = 31 * result + operationId.hashCode();
	result = 31 * result + buyPrice.hashCode();
	result = 31 * result + sellPrice.hashCode();
	return result;
    }

    @Override
    public String toString() {
	return ("Operation { Operation ID = " + operationId + ", Buy price = " + buyPrice + ", Sell price = "
		+ sellPrice + "}");
    }
}
