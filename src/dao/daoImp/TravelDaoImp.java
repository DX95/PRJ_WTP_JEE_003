package dao.daoImp;

import dao.TravelDao;
import domain.Place;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
}
