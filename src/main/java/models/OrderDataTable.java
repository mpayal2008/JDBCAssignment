package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDataTable {
	 @JsonProperty("OrderData")
	    private OrderData orderData;

	public OrderData getOrderData() {
		return orderData;
	}

	public void setOrderData(OrderData orderData) {
		this.orderData = orderData;
	}
}
