package IntefaceDAO;

import models.OrderData;

public interface IOrderData extends IGenericDAO<OrderData> {
public void getOrderDetailsByDate();
}
