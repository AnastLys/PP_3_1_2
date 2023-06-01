package web.SpringBootApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.SpringBootApp.dao.UserDao;
import web.SpringBootApp.model.User;


import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;
    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Transactional(readOnly = true)
    @Override
    public User findUser(long id){ return userDao.findUser(id); }
    @Transactional
    @Override
    public void deleteUser(long id) throws NullPointerException { userDao.deleteUser(id); }
    @Transactional
    @Override
    public void updeteUser(User user) {
        userDao.updeteUser(user);
    }
}
