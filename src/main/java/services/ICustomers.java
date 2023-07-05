package services;

import java.sql.SQLException;

import models.Customer;

public interface ICustomers extends IGenericDAO<Customer>{

	Customer getID(int id) throws SQLException;

}
