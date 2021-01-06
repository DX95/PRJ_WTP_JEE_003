package dao.daoImp;

import dao.SearchDao;
import domain.Trip;
import domain.trip2;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.ls.LSInput;
import until.DBuntil;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class SearchDaoImp implements SearchDao {

    private JdbcTemplate template=new JdbcTemplate(DBuntil.getDataSource());

    @Override
    public int findAllCount(String type) {
        String sql="select count(*) from trip where 1=1 ";
        StringBuilder sb=new StringBuilder(sql);
        List<Object> list=new ArrayList<Object>();
        if (type!=null&&!"".equals(type)){
            sb.append(" and title like ? ");
            list.add("%"+type+"%");
        }
        sql=sb.toString();
        return template.queryForObject(sql,Integer.class,list.toArray());
    }

    @Override
    public List<trip2> findList(String type, int star,int row) {
        String sql="SELECT \n" +
                "title,traffic,hotel,price,time,pic.name,good_rate,p.date\n" +
                "FROM \n" +
                "trip t, price p ,trippicture pic \n" +
                "WHERE \n" +
                "1=1";
        //SELECT title,traffic,hotel,price,date FROM trip t, price p WHERE t.id=p.id and title LIKE '%上海%'
        StringBuilder sb=new StringBuilder(sql);
        List list=new ArrayList();
        sb.append(" and t.id=p.id ");
        sb.append(" and pic.id=t.id ");
        //sb.append(" and t1.parent_id=t.id ");
        if (type!=null&&!type.equals("")){
            sb.append(" and title LIKE ? ");
            list.add("%"+type+"%");
        }
        sb.append(" limit ?,? ");
        list.add(star);
        list.add(row);
        sql=sb.toString();
        System.out.println(sql);
        System.out.println(list);
        List<trip2> query = template.query(sql, new BeanPropertyRowMapper<trip2>(trip2.class), list.toArray());
        return query;
    }
}
