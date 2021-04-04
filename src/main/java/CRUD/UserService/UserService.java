package CRUD.UserService;

import CRUD.model.User;

import java.util.List;

public interface UserService {
    void setUser(User user);
    User getUser(int id);
    void updateUser(int id, User user);
    void deleteUser(int id);
    List<User> getAllUsers();
}
