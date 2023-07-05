package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Accessories {
	@XmlElement(name="brand_id")
	private int brand_id;
	@XmlElement(name="brand_name")
	private String brand_name;
	@XmlElement(name = "item_names")
	private String item_names;
	@XmlElement(name = "item_description")
	private String item_description;
	@XmlElement(name = "item_price")
	private float item_price;

	public Accessories(int brand_id, String brand_name, String item_names, String item_description, float item_price) {
		this.brand_id = brand_id;
		this.brand_name = brand_name;
		this.item_names = item_names;
		this.item_description = item_description;
		this.item_price = item_price;
	}

	public Accessories(){

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
