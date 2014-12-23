package at.xmlc.frontend.controller;

import at.xmlc.frontend.controller.util.AbstractConversationController;
import at.xmlc.model.xml.authentication.Role;
import at.xmlc.model.xml.authentication.User;
import at.xmlc.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.primefaces.component.messages.Messages;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("registerUserController")
@ConversationScoped
public class RegisterUserController extends AbstractConversationController {

    private static final Logger log = org.apache.log4j.Logger.getLogger(RegisterUserController.class);

    private User user;

    @EJB
    private UserService service;

    @Override
    public void load() {
        //To change body of implemented methods use File | Settings | File Templates.
        user = new User();
    }


    public void submit() {

        List<Role> roles = new ArrayList<>();

        user.setRoles(roles);
        user.getRoles().add(Role.MANAGER);

        try {
            user.setPassword(new Sha256Hash(user.getPassword()).toHex());

            service.create(user);

        }
        catch (RuntimeException e) {

            e.printStackTrace(); // TODO: logger.
        }
    }

    public void selectRole(ValueChangeEvent event) {

        String role = (String) event.getNewValue();

        if (role.equals("ADMIN")) {
            user.getRoles().add(Role.ADMIN);
        }
        if (role.equals("EMPLOYEE")) {
            user.getRoles().add(Role.EMPLOYEE);
        }
        if (role.equals("MANAGER")) {
            user.getRoles().add(Role.MANAGER);
        }

    }

    public User getUser() {
        return user;
    }

}
