package service;

import domain.traffic;
import domain.trip2;

public interface TripDetailService {
    trip2 findTripDetail(int id);

    traffic FindAllTraffic(int id);
}
