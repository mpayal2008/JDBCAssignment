package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class OrderData {
@JsonProperty("order_id")
private int	order_id;
@JsonProperty("computer_id")
private int computer_id;
@JsonProperty("order_date")
private Date order_date;
@JsonProperty("order_detail")
private String order_detail;
@JsonProperty("customer_id")
private String	customer_id;

	public OrderData() {
	}

	@Override
public String toString() {
	return "OrderData [order_id=" + order_id + ", computer_id=" + computer_id + ", order_date=" + order_date
			+ ", order_detail=" + order_detail + ", customer_id=" + customer_id + "]";
}
public OrderData(int order_id, int computerID, Date orderDate, String order_detail, String customer_id) {
	super();
	this.order_id = order_id;
	this.computer_id = computerID;
	this.order_date = orderDate;
	this.order_detail = order_detail;
	this.customer_id = customer_id;
}
public Date getOrder_date() {
	return order_date;
}
public void setOrder_date(Date order_date) {
	this.order_date = order_date;
}
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}
public int getComputer_id() {
	return computer_id;
}
public void setComputer_id(int computer_id) {
	this.computer_id = computer_id;
}

public String getOrder_detail() {
	return order_detail;
}
public void setOrder_detail(String order_detail) {
	this.order_detail = order_detail;
}
public String getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(String customer_id) {
	this.customer_id = customer_id;
}
	

}
