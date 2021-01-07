package service.serviceImp;

import dao.TripDetailDao;
import dao.daoImp.TripDetailDaoImp;
import domain.traffic;
import domain.trip2;
import service.TripDetailService;

public class TripDetailServiceImp implements TripDetailService {
    private TripDetailDao dao=new TripDetailDaoImp();
    @Override
    public trip2 findTripDetail(int id) {
        return dao.findTripDetail(id);
    }

    @Override
    public traffic FindAllTraffic(int id) {
        return dao.FindAllTraffic(id);
    }
}
