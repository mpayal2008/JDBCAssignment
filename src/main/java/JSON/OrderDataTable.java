package JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import models.OrderData;

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
