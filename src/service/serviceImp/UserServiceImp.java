package service.serviceImp;

import dao.UserDao;
import dao.daoImp.UserDaoImp;
import domain.User;
import service.UserService;

public class UserServiceImp implements UserService {
    private UserDao dao=new UserDaoImp();
    @Override
    public Boolean register(String tid) {
        User use=dao.findbyphone(tid);
        if (use!=null){
            return false;
        }
        dao.register(tid);
        return true;
    }

    @Override
    public User login(String tid, String pwd) {
        User use=dao.login(tid,pwd);
        return use;
    }

    @Override
    public void insert(User user,String tid) {
        dao.insert(user,tid);
    }

    @Override
    public User selectAll(String tid) {
        User user=dao.selectAll(tid);
        return user;
    }

    @Override
    public void updateheadshout(String tid, String newname) {
        dao.updateheadshout(tid,newname);
    }
}
