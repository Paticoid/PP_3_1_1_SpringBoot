package ru.dmitry.usol.SpringbootCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dmitry.usol.SpringbootCRUD.models.User;
import ru.dmitry.usol.SpringbootCRUD.dao.UserRepositoryDao;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService implements UserServiceInter {
    private UserRepositoryDao userRepositoryDao;
    @Autowired
    public UserService(UserRepositoryDao userRepositoryDao) {
        this.userRepositoryDao = userRepositoryDao;
    }
    public List<User> allUsers() {
         return userRepositoryDao.findAll();
    }
    public User show(long id) {
        Optional<User> user = userRepositoryDao.findById(id);
        return user.orElse(null);
    }
    @Transactional
    public void save(User user) {
        userRepositoryDao.save(user);
    }
    @Transactional
    public void update(long id,User updateUser) {
        updateUser.setId(id);
        userRepositoryDao.save(updateUser);
    }
    @Transactional
    public void delete(long id) {
        userRepositoryDao.deleteById(id);
    }
}
