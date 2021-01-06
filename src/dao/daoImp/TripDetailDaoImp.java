package dao.daoImp;

import dao.TripDetailDao;
import domain.trip2;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import until.DBuntil;

import java.util.ArrayList;
import java.util.List;

public class TripDetailDaoImp implements TripDetailDao {
    private JdbcTemplate template=new JdbcTemplate(DBuntil.getDataSource());
    @Override
    //and t.id=p.id  and t.id=pic.id and t.id=1
    public trip2 findTripDetail(int id) {
        String sql="SELECT \n" +
                "title,traffic,hotel,price,time,pic.name,good_rate,p.date\n" +
                "FROM \n" +
                "trip t, price p ,trippicture pic\n" +
                "WHERE \n" +
                "1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List list=new ArrayList();
        if (id>=0){
            sb.append(" and t.id=? ");
            list.add(id);
        }
        sb.append(" and t.id=p.id ");
        sb.append(" and t.id=pic.id ");
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(list);
        trip2 trip2 = template.queryForObject(sql, new BeanPropertyRowMapper<trip2>(trip2.class), list.toArray());
        return trip2;
    }
}
