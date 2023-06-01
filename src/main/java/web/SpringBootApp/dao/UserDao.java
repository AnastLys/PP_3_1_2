package web.SpringBootApp.dao;


import web.SpringBootApp.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public List<User> listUsers();
    public User findUser(long id);

    public void deleteUser(long id);

    public void updeteUser(User user);


}
