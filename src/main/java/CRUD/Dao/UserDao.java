package CRUD.Dao;

import CRUD.model.User;

import java.util.List;

public interface UserDao {
    void setUser(User user);
    User getUser(int id);
    void updateUser(int id, User user);
    void deleteUser(int id);
    List<User> getAllUsers();
}
