package com.gmail.snyp4eg.model;

import java.util.Objects;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

@JsonObject
public class Privatbank {
    @JsonField(name="ccy")
    private String ccy;
    @JsonField(name="base_ccy")
    private String baseCcy;
    @JsonField(name="buy")
    private Integer buy;
    @JsonField(name="sale")
    private Integer sale;

    public Privatbank(String ccy, String baseCcy, Integer buy, Integer sale) {
	this.ccy = ccy;
	this.baseCcy = baseCcy;
	this.buy = buy;
	this.sale = sale;
    }

    public String getCcy() {
	return ccy;
    }

    public void setCcy(String ccy) {
	this.ccy = ccy;
    }

    public String getBaseCcy() {
	return baseCcy;
    }

    public void setBaseCcy(String baseCcy) {
	this.baseCcy = baseCcy;
    }

    public Integer getBuy() {
	return buy;
    }

    public void setBuy(Integer buy) {
	this.buy = buy;
    }

    public Integer getSale() {
	return sale;
    }

    public void setSale(Integer sale) {
	this.sale = sale;
    }

    @Override
    public int hashCode() {
	return Objects.hash(baseCcy, buy, ccy, sale);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Privatbank other = (Privatbank) obj;
	return Objects.equals(baseCcy, other.baseCcy) && Objects.equals(buy, other.buy)
		&& Objects.equals(ccy, other.ccy) && Objects.equals(sale, other.sale);
    }

    @Override
    public String toString() {
	return "Privatbank [ccy=" + ccy + ", base_ccy=" + baseCcy + ", buy=" + buy + ", sale=" + sale + "]";
    }
}
