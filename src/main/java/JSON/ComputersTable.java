package JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

import models.Computers;

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
