package dao;

import domain.Place;
import domain.Theme;
import domain.trip2;

import java.util.List;

public interface TravelDao {
    List<Place> FinallPlace();

    List<Theme> finallTheme();

    List<trip2> findallInf();
}
