package CRUD.UserService;

import CRUD.model.User;

public interface UserService {
    void setUser(User user);
    User getUser(int id);
    void updateUser(int id, User user);
    void deleteUser(int id);
}
