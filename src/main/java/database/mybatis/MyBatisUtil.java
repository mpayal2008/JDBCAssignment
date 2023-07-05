package database.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {

    public static SqlSessionFactory sessionFactory;
    Reader reader;
    //to read configuration file
    {
        try {
            reader = Resources.getResourceAsReader("src/main/resources/myBatisConfig.xml");
            sessionFactory= new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //to get sqlsessionfactory to perform database operation
    public static SqlSessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
