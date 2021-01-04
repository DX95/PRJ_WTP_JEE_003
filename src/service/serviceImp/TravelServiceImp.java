package service.serviceImp;

import dao.TravelDao;
import dao.daoImp.TravelDaoImp;
import domain.Place;
import domain.Theme;
import service.TravelService;

import java.sql.SQLOutput;
import java.util.List;

public class TravelServiceImp implements TravelService {
    TravelDao dao=new TravelDaoImp();
    @Override
    public List<Place> FinallPlace() {
        List<Place> list=dao.FinallPlace();
        return list;
    }

    @Override
    public List<Theme> finallTheme() {
        List<Theme> list =dao.finallTheme();
        return list;
    }
}
