package ru.dmitry.usol.SpringbootCRUD.dao;

import org.springframework.stereotype.Repository;
import ru.dmitry.usol.SpringbootCRUD.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
      return  entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    public User show(long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);

    }

    @Override
    public void update(long id, User updateUser) {
        User user = entityManager.find(User.class,id);
        user.setName(updateUser.getName());
        user.setAge(updateUser.getAge());
        user.setEmail(updateUser.getEmail());

    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("DELETE FROM User WHERE id=?1").setParameter(1,id).executeUpdate();

    }
}
