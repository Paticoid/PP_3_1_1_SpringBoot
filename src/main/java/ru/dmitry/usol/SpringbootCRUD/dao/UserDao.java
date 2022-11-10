package ru.dmitry.usol.SpringbootCRUD.dao;

import ru.dmitry.usol.SpringbootCRUD.models.User;

import java.util.List;

public interface UserDao {
    public List<User> allUsers();
    public User show(long id);
    public void save(User user);
    public void update(long id,User updateUser);
    public void delete(long id);
}
