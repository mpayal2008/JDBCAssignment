package models;

public class Accessories {
	private int brand_id;
	private String brand_name;
	private String item_names;
	private String item_description;
	private float item_price;
	
	
	public Accessories(int brand_id, String brand_name, String item_names, String item_description, float item_price) {
	
		this.brand_id = brand_id;
		this.brand_name = brand_name;
		this.item_names = item_names;
		this.item_description = item_description;
		this.item_price = item_price;
	}
	public Accessories() {

	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getItem_names() {
		return item_names;
	}
	public void setItem_names(String item_names) {
		this.item_names = item_names;
	}
	public String getItem_description() {
		return item_description;
	}
	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
	public float getItem_price() {
		return item_price;
	}
	public void setItem_price(float item_price) {
		this.item_price = item_price;
	}


}
