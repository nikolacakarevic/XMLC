package at.xmlc.dao;

import at.xmlc.model.xml.authentication.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bert
 * Date: 23.12.14
 * Time: 14:22
 * To change this template use File | Settings | File Templates.
 */
public class UserDao extends AbstractDao<User, Long> {

    public User find(String username, String password) {
        List<User> found = en.createNamedQuery("User.find", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();
        return found.isEmpty() ? null : found.get(0);
    }


    public List<User> list() {
        return en.createNamedQuery("User.list", User.class).getResultList();
    }
}
