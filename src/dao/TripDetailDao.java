package dao;

import domain.traffic;
import domain.trip2;

public interface TripDetailDao  {
    trip2 findTripDetail(int id);

    traffic FindAllTraffic(int id);
}
