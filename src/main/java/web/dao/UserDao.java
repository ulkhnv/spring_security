package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void delete(Long id) {
        sessionFactory.getCurrentSession().delete(getUserById(id));
    }

    @SuppressWarnings("unchecked")
    public User getUserById(Long id ) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE id=:id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public UserDetails findByUsername(String username) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE username=:username");
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}

