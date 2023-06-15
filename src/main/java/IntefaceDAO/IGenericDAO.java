package IntefaceDAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO<T> {

	T getID(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
	List<T> getAll()throws SQLException;
	int insert(T t)throws SQLException;
	int update(T t)throws SQLException;
	int delete(T t)throws SQLException;
	
}
