package database.mapper;

import database.util.MyBatisUtil;
import models.Computers;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ComputersMapper {

    public List<Computers> getAllComputers(){
        // to open the session
        SqlSession session= MyBatisUtil.getSessionFactory().openSession();
        List<Computers> compList= session.selectList("getDetailsByID", 1006);

        session.commit();
        session.close();
        return compList;

    }

}
