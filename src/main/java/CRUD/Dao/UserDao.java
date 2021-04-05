package CRUD.Dao;

import CRUD.model.User;

import java.util.List;

public interface UserDao {
    void setUser(User user);
    User getUser(long id);
    void updateUser(User user);
    void deleteUser(long id);
    List<User> getAllUsers();
}
