package dao.daoImp;

import dao.TravelDao;
import domain.Place;
import domain.Theme;
import domain.trip2;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import until.DBuntil;

import java.util.List;

public class TravelDaoImp implements TravelDao {
    private JdbcTemplate template=new JdbcTemplate(DBuntil.getDataSource());
    @Override
    public List<Place> FinallPlace() {
        String sql="select *from place where id<=10";
        List<Place> query = template.query(sql, new BeanPropertyRowMapper<Place>(Place.class));
        return query;
    }

    @Override
    public List<Theme> finallTheme() {
        String sql="select *from theme where id<=10";
        List<Theme> query = template.query(sql, new BeanPropertyRowMapper<Theme>(Theme.class));
        return query;
    }

    @Override
    public List<trip2> findallInf() {
        String sql="SELECT\n" +
                "t.id,pic.name,price,s_title\n" +
                "FROM\n" +
                "trip t,price p,trippicture pic\n" +
                "WHERE\n" +
                "1=1 and t.id=p.id AND t.id=pic.id  LIMIT 0,6";
        List<trip2> query = template.query(sql, new BeanPropertyRowMapper<trip2>(trip2.class));
        return query;
    }
}
