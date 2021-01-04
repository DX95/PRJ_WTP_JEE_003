package dao;

import domain.Place;
import domain.Theme;

import java.util.List;

public interface TravelDao {
    List<Place> FinallPlace();

    List<Theme> finallTheme();
}
