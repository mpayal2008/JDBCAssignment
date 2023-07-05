package database.daopackage;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import services.IComputers;

import database.jdbc.JdbcConnection;
import models.Computers;

public class ComputersDAO implements IComputers {
	   private static final Logger logger = LogManager.getLogger(IComputers.class);
	   
	@Override
	public Computers getID(int id) throws SQLException {
		
		String query1="select * from Computers where computer_id=?";
		Connection connection= JdbcConnection.getConnection();
		Computers computer= null;
		PreparedStatement ps= connection.prepareStatement(query1);
		ps.setInt(1, id);
		ResultSet resultset= ps.executeQuery();
	try{
		if(resultset.next()) {
			int ID= resultset.getInt(1);
			int config_id= resultset.getInt(2);
			String brandName= resultset.getString(3);
			String modelName= resultset.getString(4);
			computer = new Computers(ID, config_id, brandName,modelName);
		}
	} catch (SQLException e) {
		logger.info(e);
	}finally {
		JdbcConnection.closeResultSet(resultset);
		JdbcConnection.closeStatement(ps);
		JdbcConnection.closeConnection(connection);	
	}
	return computer;
	}

	@Override
	public List<Computers> getAll() throws SQLException {
		
        List<Computers> list1 = new ArrayList<>();
        String query2 = "SELECT * FROM Computers";
        Connection connection1 = null;
        connection1= JdbcConnection.getConnection();
        Computers comp1 = null;
        PreparedStatement ps= connection1.prepareStatement(query2);
        ResultSet resultset = ps.executeQuery(query2);
        	while (resultset.next()) {
                int ID= resultset.getInt(1);
				int config_id= resultset.getInt(2);
				String brandName= resultset.getString(3);
				String modelName= resultset.getString(4);
				comp1 = new Computers(ID, config_id, brandName,modelName);
                list1.add(comp1);
            }
        return list1;
    }

	@Override
	public int save(Computers t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Computers comp) throws SQLException {
        String query3 = "insert into computers(computer_id, internal_config_id,brand_name,model_name) values (?,?,?,?)";
        Connection connection = null;
        connection= JdbcConnection.getConnection();
       
        PreparedStatement ps= connection.prepareStatement(query3);
        ps.setInt(1,comp.getComputer_id());
        ps.setInt(2,comp.getInternal_config_id());
        ps.setString(3, comp.getBrand_name());
        ps.setString(4, comp.getModel_name());
        return (ps.executeUpdate());
	}

	@Override
	public int update(Computers t) throws SQLException {
		return 0;
	
	}

	@Override
	public int delete(Computers t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
