package dao;

import domain.Trip;
import domain.trip2;

import java.util.List;

public interface SearchDao {

    int findAllCount(String type);

    List<trip2> findList(String type, int row, int currentpage);
}
