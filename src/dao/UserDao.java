package dao;

import domain.User;

public interface UserDao {
    User findbyphone(String tid);

    void register(String tid);

    User login(String tid, String pwd);

    void insert(User user,String tid);

    User selectAll(String tid);

    void updateheadshout(String tid, String newname);
}
