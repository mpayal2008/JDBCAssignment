package models;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "computer")
@XmlAccessorType(XmlAccessType.FIELD)
public class ComputerData  {
	@JsonProperty("DataTable")
	private DataTable dataTable;

	public AccessoriesTable getAccessoriesTable() {
		return accessoriesTable;
	}

	public void setAccessoriesTable(AccessoriesTable accessoriesTable) {
		this.accessoriesTable = accessoriesTable;
	}

	public CustomerTable getCustomerTable() {
		return customerTable;
	}

	public void setCustomerTable(CustomerTable customerTable) {
		this.customerTable = customerTable;
	}

	public MaintenanceTable getMaintenanceTable() {
		return maintenanceTable;
	}

	public void setMaintenanceTable(MaintenanceTable maintenanceTable) {
		this.maintenanceTable = maintenanceTable;
	}

	@XmlElement(name = "AccessoriesTable")
	private AccessoriesTable accessoriesTable;

	@XmlElement(name = "CustomerTable")
	private CustomerTable customerTable;

	@XmlElement(name = "MaintenanceTable")
	private MaintenanceTable maintenanceTable;

	public DataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(DataTable dataTable) {
		this.dataTable = dataTable;
	}
}
