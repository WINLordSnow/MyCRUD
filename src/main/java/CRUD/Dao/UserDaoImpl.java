package CRUD.Dao;

import CRUD.model.Role;
import CRUD.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager em;

    @Override
    public void setUser(User user) {
        em.persist(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(long id) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        em.remove(getUser(id));
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Set<Role> getAllRoles() {
        return em.createQuery("select r from Role r", Role.class).getResultStream().collect(Collectors.toSet());
    }
}
