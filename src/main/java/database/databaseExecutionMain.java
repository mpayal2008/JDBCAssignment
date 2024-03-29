package database;

import java.sql.SQLException;
import java.util.List;

import database.daoimpl.ComputersDAO;
import database.daoimpl.OrderDataDAO;
import models.Computers;
import models.OrderData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import database.services.IComputers;
import database.services.IOrderData;

public class databaseExecutionMain {
	private static final Logger logger = LogManager.getLogger(databaseExecutionMain.class);
	
	public static void main(String[] args) throws SQLException {
		
		//"select * from Computers where computer_id=?";
		IComputers computerInterface = new ComputersDAO();
		Computers comp= computerInterface.getID(1001);
		logger.info(comp);
		
		//list- "SELECT * FROM Computers"
		List<Computers> list1=computerInterface.getAll();
		logger.info(list1);
		
		//"insert into computers(computer_id, internal_config_id,brand_name,model_name) values (?,?,?,?)";
	//	Computers comp1= new Computers(1010,3,"HP","Pavallion dr7");
	//	int result= computerInterface.insert(comp1);
	//	logger.info(result);
		
		IOrderData iorder = new OrderDataDAO();
		//""select * from OrderData where computer_id=?"
		OrderData od= iorder.getID(1);
		logger.info(od);
		
		//list- "SELECT * FROM OrderData"
		List<OrderData> list2=iorder.getAll();
		logger.info(list2);
		
		//"update OrderData set order_id=? ,computer_id=?,order_date=?,order_detail=?,customer_id=? where customer_id=?";
		OrderData order1= new OrderData(3, 1003, null, "HP laptop", "2");
		iorder.update(order1);
		logger.info(order1);
	
		//"delete from OrderData where order_id=?"
		OrderData order2=iorder.getID(7);
		logger.info(order2);
		logger.info(iorder.delete(order2));
		
	}

}
