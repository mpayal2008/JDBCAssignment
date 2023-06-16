package IntefaceDAO;

import models.Accessories;

public interface IAccessories extends IGenericDAO<Accessories>{

	public void getItemsByBrandName();
	
}
