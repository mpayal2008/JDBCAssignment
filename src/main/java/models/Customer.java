package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
	@XmlElement(name = "customer_id")
	@JsonProperty("customer_id")
	private int customer_id;
	@XmlElement(name = "username")
	@JsonProperty("username")
	private String username;
	@XmlElement(name = "password")
	@JsonProperty("password")
	private String password;
	@XmlElement(name = "full_name")
	@JsonProperty("full_name")
	private String full_name;
	@XmlElement(name = "email")
	@JsonProperty("email")
	private String email;
	
	public void customer() {
		
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;

	}
}
