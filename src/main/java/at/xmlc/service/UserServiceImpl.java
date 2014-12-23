package at.xmlc.service;

import at.xmlc.dao.UserDao;
import at.xmlc.model.xml.authentication.User;
import org.apache.shiro.crypto.hash.Sha256Hash;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Override
    public User find(Long id) {
        return userDao.findById(User.class, id);
    }

    @Override
    public User find(String username, String password) {
        return userDao.find(username, password);
    }

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public Long create(User user) {

        userDao.create(user);
        return user.getId();
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {

    }

}
