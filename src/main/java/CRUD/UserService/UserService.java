package CRUD.UserService;

import CRUD.model.User;

import java.util.List;

public interface UserService {
    void setUser(User user);
    User getUser(long id);
    void updateUser(User user);
    void deleteUser(long id);
    List<User> getAllUsers();
}
