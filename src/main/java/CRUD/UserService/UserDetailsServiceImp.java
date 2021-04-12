package CRUD.UserService;

import CRUD.Dao.UserDao;

import CRUD.model.Role;
import CRUD.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    private UserDao userDao;

    public UserDetailsServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        if (login.equals("ADMIN")) {
            User user = new User("ADMIN", "ADMIN", "adm", "adm");
            System.out.println(user.getRoles().isEmpty());
            user.addRole(new Role(2L, "ADMIN"));
            return user;
        }
        return userDao.getUserByLogin(login).orElse(null);
    }
}