package at.xmlc.frontend.controller.util;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * author: Nikola Cakarevic
 * since: XMLC 1.0
 */
public abstract class AbstractConversationController  implements Serializable {

    private static final Logger log = Logger.getLogger(AbstractConversationController.class);

    private static final long TIMEOUT = 1200000L;

    @Inject
    private Conversation conversation;

    /**
     * This abstract method will be performed in the PreRenderViewEvent.
     */
    public abstract void load();

    @PostConstruct
    public void init() {
        setConversationTimeout();
    }

    /**
     * This method is called on page loading and on Ajax requests.
     * If it is called on Ajax Request method will be stopped.
     */
    public void preRenderView(ComponentSystemEvent e) {

        if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
            log.info("PreRenderViewEvent: Ajax request - Do not start conversation");
            return;
        } else {
            log.info("PreRenderViewEvent: Start conversation");
        }

        startConversation();

        load();

    }

    public void renderResponse() {
        FacesContext.getCurrentInstance().renderResponse();
    }

    public void startConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    public void beginForceConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        } else {
            conversation.end();
            conversation.begin();
        }
    }

    public void endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    private void setConversationTimeout() {
        if(conversation.isTransient() == false) {
            conversation.setTimeout(TIMEOUT);
        }
    }

}