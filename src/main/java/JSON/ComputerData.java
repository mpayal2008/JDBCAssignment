package JSON;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ComputerData  {
	@JsonProperty("DataTable")
	private DataTable dataTable;

	public DataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(DataTable dataTable) {
		this.dataTable = dataTable;
	}
}
