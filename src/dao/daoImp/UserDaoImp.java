package dao.daoImp;

import dao.UserDao;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import until.DBuntil;

public class UserDaoImp implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(DBuntil.getDataSource());
    @Override
    public User findbyphone(String tid) {
        User use = null;
        try {
            String sql="SELECT *FROM user WHERE phone=? or email=?";
            use= template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), tid, tid);
        } catch (Exception e) {

        }
        return use;
    }

    @Override
    public void register(String tid) {
        String str="^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        boolean b = tid.matches(str);
        String sql="";
        if (b){
            System.out.println("是邮箱！");
            sql="insert into user(email) VALUE(?)";
            template.update(sql,tid);
        }else {
            System.out.println("是手机号！");
            sql="insert into user(phone) VALUE(?)";
            template.update(sql,tid);
        }

    }

    @Override
    public User login(String tid, String pwd) {
        String str="^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        boolean b=false;
        if (tid!=null){
            b= tid.matches(str);
        }
        String sql="";
        User use=null;
        try {
            if (b){
                System.out.println("是邮箱！");
                sql="select * from user where email=? and password=?";
                use=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),tid,pwd);
             }else {
                System.out.println("是手机号！");
                sql="select * from user where phone=? and password=?";
                use=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),tid,pwd);
            }

        }catch (Exception e) {

        }
        return use;
    }

    @Override
    public void insert(User user,String tid) {
        String str="^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        boolean b=false;
        if (tid!=null){
            b= tid.matches(str);
        }
        String sql="";
        if (b){
            System.out.println("是邮箱！");
            sql="update user set phone=?,name=?,sex=?,real_name=? ,birthday=? where email=?";
            template.update(sql,user.getPhone(),user.getName(),user.getSex(),user.getReal_name(),user.getBirthday(),tid);
        }else {
            System.out.println("是手机号！");
            System.out.println("dao:"+user.toString());
            sql="update user set name=?,sex=?,email=?,real_name=?,birthday=? where phone=?";
            template.update(sql,user.getName(),user.getSex(),user.getEmail(),user.getReal_name(),user.getBirthday(),tid);
        }
    }

    @Override
    public User selectAll(String tid) {
        String str="^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        boolean b=false;
        User user=null;
        if (tid!=null){
            b= tid.matches(str);
        }
        String sql="";
        try {
        if (b){
            sql="select *from user where email=?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), tid);
        }else {
            sql="select *from user where phone=?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), tid);
        }
        }catch (Exception e) {

        }
        return user;
    }

    @Override
    public void updateheadshout(String tid, String newname) {
        String str="^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        boolean b=false;
        User user=null;
        if (tid!=null){
            b= tid.matches(str);
        }
        String sql="";
        if (b){
            sql="update user set img_path=? where email=?";
            template.update(sql,newname,tid);
        }else {
            sql="update user set img_path=? where phone=?";
            template.update(sql,newname,tid);
        }
    }

}
