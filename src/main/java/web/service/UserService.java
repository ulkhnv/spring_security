package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    public void delete(long id) {
        userDao.delete(id);
    }

    @Transactional
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

}
