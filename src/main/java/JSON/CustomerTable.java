package JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import models.Customer;

public class CustomerTable {
	  @JsonProperty("Customer")
	    private Customer[] customers;

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}
}
