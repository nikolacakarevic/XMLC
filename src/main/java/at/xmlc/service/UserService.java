package at.xmlc.service;

import at.xmlc.model.xml.authentication.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserService {

    public User find(Long id);

    public User find(String username, String password);

    public List<User> list();

    public Long create(User user);

    public void update(User user);

    public void delete(User user);
}
