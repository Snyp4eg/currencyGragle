package com.gmail.snyp4eg.model;

public class Bank {
    private Integer bankId;
    private String bankName;

    public Bank() {
    }

    public Bank(Integer bankId, String bankName) {
	this.setBankId(bankId);
	this.setBankName(bankName);
    }

    public Integer getBankId() {
	return bankId;
    }

    public void setBankId(Integer bankId) {
	this.bankId = bankId;
    }

    public String getBankName() {
	return bankName;
    }

    public void setBankName(String bankName) {
	this.bankName = bankName.toUpperCase();
    }
    
    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Bank bank = (Bank) o;
      return (this.bankId.equals(bank.bankId) && this.bankName.equals(bank.bankName));
    }

    @Override
    public int hashCode() {
      int result = 17;
      result = 31 * result + bankId.hashCode();
      result = 31 * result + bankName.hashCode();
      return result;
    }

    @Override
    public String toString() {
      return ("Bank { ID = " + bankId + ", name = " + bankName + "}");
    }
}
