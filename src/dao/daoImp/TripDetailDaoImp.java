package dao.daoImp;

import dao.TripDetailDao;
import domain.traffic;
import domain.trip2;
import domain.trippicture;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;
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

    @Override
    public traffic FindAllTraffic(int id) {
        String sql="SELECT\n" +
                "t2.id,t2.go_point,t2.go_time,t2.return_point,t2.return_time\n" +
                "FROM\n" +
                "trip t1,traffic t2\n" +
                "WHERE\n" +
                "1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List list=new ArrayList();
        if (id>=0){
            sb.append(" and t1.id=? ");
            list.add(id);
        }
        sb.append(" AND t1.id=t2.id  ");
        sql=sb.toString();
        System.out.println(sql);
        System.out.println(list);
        return template.queryForObject(sql,new BeanPropertyRowMapper<traffic>(traffic.class),list.toArray());
    }

    public List<trippicture> FinadList(){
        String sql="select name from trippicture ";
        return template.query(sql,new BeanPropertyRowMapper<trippicture>(trippicture.class));
    }
}
