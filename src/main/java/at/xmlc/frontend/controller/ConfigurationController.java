package at.xmlc.frontend.controller;

import at.xmlc.frontend.controller.util.AbstractConversationController;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

/**
 * author: Nikola Cakarevic
 * since: XMLC 1.0
 */
@Named("configurationController")
@ConversationScoped
public class ConfigurationController extends AbstractConversationController {

    @Override
    public void load() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
