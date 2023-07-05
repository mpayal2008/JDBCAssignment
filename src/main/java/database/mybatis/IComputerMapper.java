package database.mybatis;

import models.Computers;

import java.util.List;

public interface IComputerMapper {
   Computers getDetailsByID(int id);

}
