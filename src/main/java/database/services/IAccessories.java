package database.services;

import models.Accessories;

public interface IAccessories extends IGenericDAO<Accessories>{

	public void getItemsByBrandName();
	
}
