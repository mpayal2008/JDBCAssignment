package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataTable {

    @JsonProperty("ComputersTable")
    private ComputersTable computersTable;

    @JsonProperty("CustomerTable")
    private CustomerTable customerTable;

    @JsonProperty("OrderDataTable")
    private OrderDataTable orderDataTable;

    public ComputersTable getComputersTable() {
        return computersTable;
    }

    public void setComputersTable(ComputersTable computersTable) {
        this.computersTable = computersTable;
    }

    public CustomerTable getCustomerTable() {
        return customerTable;
    }

    public void setCustomerTable(CustomerTable customerTable) {
        this.customerTable = customerTable;
    }

    public OrderDataTable getOrderDataTable() {
        return orderDataTable;
    }

    public void setOrderDataTable(OrderDataTable orderDataTable) {
        this.orderDataTable = orderDataTable;
    }
}
