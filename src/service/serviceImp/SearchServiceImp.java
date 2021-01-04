package service.serviceImp;

import dao.SearchDao;
import dao.daoImp.SearchDaoImp;
import domain.Pagebean;
import domain.Trip;
import service.SearchService;

import java.util.List;

public class SearchServiceImp implements SearchService {
    private SearchDao dao=new SearchDaoImp();
    @Override
    public Pagebean SearchPagebean(String type, int row, int currentpage) {

        Pagebean pagebean=new Pagebean();
        pagebean.setCurrentpage(currentpage);
        pagebean.setRows(row);

        int Totalcount=dao.findAllCount(type);
        pagebean.setTotalcount(Totalcount);

        int Totalpage=Totalcount%row==0 ? Totalcount/row: (Totalcount/row)+1;
        pagebean.setTotalpage(Totalpage);

        int star=(currentpage-1)*row;
        List<Trip> list= dao.findList(type,star,row);
        pagebean.setList(list);

        return pagebean;
    }
}
