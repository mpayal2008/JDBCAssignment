package database.mapper;

import database.imapper.IComputersMapper;
import database.util.MyBatisUtil;
import models.Computers;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ComputersMapper implements IComputersMapper {

  /*  public List<Computers> getAllComputers(){
        // to open the session
        SqlSession session= MyBatisUtil.getSessionFactory().openSession();
        List<Computers> compList= session.selectList("getDetailsByID", 1006);

        session.commit();
        session.close();
        return compList;

    }
    */


    @Override
    public Computers getDetailsByID(int id) {
        return null;
    }

    @Override
    public void insertCompDetails(Computers computer) {

    }
}
