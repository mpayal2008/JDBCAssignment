package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Computers {
	@JsonProperty("computer_id")
	private int computer_id;
	@JsonProperty("internal_config_id")
	private int internal_config_id;
	@JsonProperty("brand_name")
	private String brand_name;
	@JsonProperty("model_name")
	private String model_name;


	@Override
	public String toString() {
		return "Computers [computer_id=" + computer_id + ", internal_config_id=" + internal_config_id + ", brand_name="
				+ brand_name + ", model_name=" + model_name + "]";
	}
	public Computers(int computer_id, int config_id, String brand_name, String model_name) {

		this.computer_id = computer_id;
		this.internal_config_id = config_id;
		this.brand_name = brand_name;
		this.model_name = model_name;
	}
	public Computers() {
		// TODO Auto-generated constructor stub
	}
	public int getComputer_id() {
		return computer_id;
	}
	public void setComputer_id(int computer_id) {
		this.computer_id = computer_id;
	}
	public int getInternal_config_id() {
		return internal_config_id;
	}
	public void setInternal_config_id(int internal_config_id) {
		this.internal_config_id = internal_config_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

}
