package ru.dmitry.usol.SpringbootCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dmitry.usol.SpringbootCRUD.dao.UserDao;
import ru.dmitry.usol.SpringbootCRUD.models.User;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {
    private UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }
    public List<User> allUsers() {
         return userDao.allUsers();
    }
    public User show(long id) {
        return userDao.show(id);
    }
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }
    @Transactional
    public void update(long id,User updateUser) {
        userDao.update(id,updateUser);
    }
    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }
}
