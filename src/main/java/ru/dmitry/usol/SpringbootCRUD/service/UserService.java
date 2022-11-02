package ru.dmitry.usol.SpringbootCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dmitry.usol.SpringbootCRUD.dao.UserDaoInt;
import ru.dmitry.usol.SpringbootCRUD.models.User;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService implements UserServiceInter {
    private UserDaoInt userDaoInt;
    @Autowired
    public UserService(UserDaoInt userDaoInt) {
        this.userDaoInt = userDaoInt;
    }
    public List<User> allUsers() {
         return userDaoInt.allUsers();
    }
    public User show(long id) {
        return userDaoInt.show(id);
    }
    @Transactional
    public void save(User user) {
        userDaoInt.save(user);
    }
    @Transactional
    public void update(long id,User updateUser) {
        userDaoInt.update(id,updateUser);
    }
    @Transactional
    public void delete(long id) {
        userDaoInt.delete(id);
    }
}
