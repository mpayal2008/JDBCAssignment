package database;

import database.imapper.IComputersMapper;
import database.mapper.ComputersMapper;
import models.Computers;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisRunner {
    public static void main(String[] args)  {
        try {
            Reader reader = Resources.getResourceAsReader("myBatisConfig.xml");
            SqlSessionFactory sessionFactory = null;
            SqlSession session = null;
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);

            // Get the computersMapper instance
         //   sessionFactory.getConfiguration().addMapper(IComputersMapper.class);
            session = sessionFactory.openSession();
            IComputersMapper computersMapper = session.getMapper(IComputersMapper.class);

            Computers computers = new Computers();

            // Retrieve a user by ID
            Computers comp = computersMapper.getDetailsByID(1006);
            System.out.println("comp : " + comp);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
