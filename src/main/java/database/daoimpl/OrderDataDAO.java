package database.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.services.IOrderData;
import database.jdbc.JdbcConnection;

import models.OrderData;

public class OrderDataDAO implements IOrderData {

	@Override
	public OrderData getID(int id) throws SQLException {
		String query1="select * from OrderData where order_id=?";
		Connection connection= JdbcConnection.getConnection();
		OrderData orderData= null;
		PreparedStatement ps= connection.prepareStatement(query1);
		ps.setInt(1, id);
		ResultSet resultset= ps.executeQuery();
		if(resultset.next()) {
			int ID= resultset.getInt(1);
			int computerID= resultset.getInt(2);
			Date orderDate= resultset.getDate(3);
			String detail= resultset.getString(4);
			String customerID= resultset.getString(5);
			orderData = new OrderData(ID, computerID,orderDate,detail,customerID);
		}
		JdbcConnection.closeResultSet(resultset);
		JdbcConnection.closeStatement(ps);
		JdbcConnection.closeConnection(connection);	
		return orderData;
	}

	@Override
	public List<OrderData> getAll() throws SQLException {

        List<OrderData> list1 = new ArrayList<>();
        String query2 = "SELECT * FROM OrderData";
        Connection connection1 = null;
        connection1= JdbcConnection.getConnection();
        OrderData orderData = null;
        PreparedStatement ps= connection1.prepareStatement(query2);
        ResultSet resultset = ps.executeQuery(query2);
    	while (resultset.next()) {
            int ID= resultset.getInt(1);
			int computerID= resultset.getInt(2);
			Date orderDate= resultset.getDate(3);
			String detail= resultset.getString(4);
			String customerID=resultset.getString(5);
			orderData = new OrderData(ID, computerID,orderDate,detail,customerID);
            list1.add(orderData);
        }
    	JdbcConnection.closeResultSet(resultset);
		JdbcConnection.closeStatement(ps);
		JdbcConnection.closeConnection(connection1);	
        return list1;
	}

	@Override
	public int save(OrderData t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(OrderData t) throws SQLException {
		return 0;
		
	}

	@Override
	public int update(OrderData order) throws SQLException {
		String query="update OrderData set order_id=? ,computer_id=?,order_date=?,order_detail=? where customer_id=?";
        Connection connection = null;
        connection= JdbcConnection.getConnection(); 
	    PreparedStatement ps= connection.prepareStatement(query);
	    ps.setInt(1, order.getOrder_id());
	    ps.setInt(2, order.getComputer_id());
	    ps.setDate(3, order.getOrder_date());
	    ps.setString(4, order.getOrder_detail());
	    ps.setString(5, order.getCustomer_id());
	    int result= ps.executeUpdate();
		
		JdbcConnection.closeStatement(ps);
		JdbcConnection.closeConnection(connection);	
		return result;
	}

	@Override
	public int delete(OrderData order) throws SQLException {
		String query="delete from OrderData where order_id=?";
		Connection connection = null;
		connection= JdbcConnection.getConnection(); 
		PreparedStatement ps= connection.prepareStatement(query);
		ps.setInt(1, order.getOrder_id());
		int result= ps.executeUpdate();
    
		JdbcConnection.closeStatement(ps);
		JdbcConnection.closeConnection(connection);	
		return result;
	}

	@Override
	public void getOrderDetailsByDate() {
		// TODO Auto-generated method stub
		
	}

}
