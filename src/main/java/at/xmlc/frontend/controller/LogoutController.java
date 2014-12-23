package at.xmlc.frontend.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.shiro.SecurityUtils;

import java.io.IOException;

/**
 * author: Nikola Cakarevic
 * since: XMLC 1.0
 */
@Named("logoutController")
@RequestScoped
public class LogoutController {
    public static final String HOME_URL = "login.xhtml";

    public void submit() throws IOException {
        SecurityUtils.getSubject().logout();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect(HOME_URL);
    }

}
