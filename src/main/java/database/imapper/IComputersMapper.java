package database.imapper;

import models.Computers;

public interface IComputersMapper {
    Computers getDetailsByID(int id);
    void insertCompDetails(Computers computer);
}
