package database.imapper;

import models.Computers;

import java.util.List;

public interface IComputerMapper {
   Computers getDetailsByID(int id);

}