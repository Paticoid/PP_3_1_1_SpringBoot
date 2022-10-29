package ru.dmitry.usol.SpringbootCRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmitry.usol.SpringbootCRUD.models.User;

@Repository
public interface UserRepositoryDao extends JpaRepository<User,Long> {
}
