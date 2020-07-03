package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public RoleDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addRole(int user_id, int role_id) {}

}
