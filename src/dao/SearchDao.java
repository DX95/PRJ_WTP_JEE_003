package dao;

import domain.Trip;

import java.util.List;

public interface SearchDao {
    int findAllCount(String type);

    List<Trip> findList(String type, int row, int currentpage);
}
