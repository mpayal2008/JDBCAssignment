package database;

import models.Computers;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class MyBatisRunner {
    public static void main(String[] args) {
        String resource = "myBatisConfig.xml";
        try (Reader reader = Resources.getResourceAsReader(resource)) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            // Use the SqlSessionFactory to create SqlSession instances and perform database operations
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Computers comp=sqlSession.selectOne("src.main.resources.mybatis.ComputersMapper.getDetailsByID",1004);
            System.out.println("Computer detail: "+ comp);
            // Perform database operations using the sqlSession

            sqlSession.close(); // Remember to close the SqlSession
        } catch (IOException e) {
            e.printStackTrace();
        }
   /*     SqlSession session= MyBatisUtil.getSessionFactory().openSession();
        List<Computers> compList= session.selectList("getDetailsByID");
        session.commit();
        session.close();
        return compList;

        try {
            InputStream stream= Resources.getResourceAsStream("myBatisConfig.xml");
            SqlSession session= new SqlSessionFactoryBuilder().build(stream).openSession();
            Computers comp=session.selectOne("database/mybatis/ComputersMapper.getDetailsByID",1004);
            System.out.println("Computer detail: "+ comp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/
    }
}
