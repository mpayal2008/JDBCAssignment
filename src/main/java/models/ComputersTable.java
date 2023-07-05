package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComputersTable {
	@JsonProperty("Computers")
    private Computers[] computers;

	public Computers[] getComputers() {
		return computers;
	}

	public void setComputers(Computers[] computers) {
		this.computers = computers;
	}
	
}
