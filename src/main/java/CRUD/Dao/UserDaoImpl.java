package CRUD.Dao;

import CRUD.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void setUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void updateUser(int id, User user) {

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }
}
