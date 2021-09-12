package com.gmail.snyp4eg.model;

public class Currency {
    private Integer currencyId;
    private String currencyName;

    public Currency() {
    }

    public Currency(Integer currencyId, String currencyName) {
	this.setCurrencyId(currencyId);
	this.setCurrencyName(currencyName);
    }

    public Integer getCurrencyId() {
	return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
	this.currencyId = currencyId;
    }

    public String getCurrencyName() {
	return currencyName;
    }

    public void setCurrencyName(String currencyName) {
	this.currencyName = currencyName.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	Currency currency = (Currency) o;
	return (this.currencyId.equals(currency.currencyId) && this.currencyName.equals(currency.currencyName));
    }

    @Override
    public int hashCode() {
	int result = 17;
	result = 31 * result + currencyId.hashCode();
	result = 31 * result + currencyName.hashCode();
	return result;
    }

    @Override
    public String toString() {
	return ("Currency { ID = " + currencyId + ", name = " + currencyName + "}");
    }
}
