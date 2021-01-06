package service.serviceImp;

import dao.TripDetailDao;
import dao.daoImp.TripDetailDaoImp;
import domain.trip2;
import service.TripDetailService;

public class TripDetailServiceImp implements TripDetailService {
    private TripDetailDao dao=new TripDetailDaoImp();
    @Override
    public trip2 findTripDetail(int id) {
        return dao.findTripDetail(id);
    }
}
