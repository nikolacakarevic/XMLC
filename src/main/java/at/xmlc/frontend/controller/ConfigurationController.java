package at.xmlc.frontend.controller;

import at.xmlc.frontend.controller.util.AbstractConversationController;
import at.xmlc.model.xml.Configuration;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import at.xmlc.model.xml.Owner;
import at.xmlc.model.xml.Source;
import org.apache.log4j.Logger;
import java.io.File;

/**
 * author: Nikola Cakarevic
 * since: XMLC 1.0
 */
@Named("configurationController")
@ConversationScoped
public class ConfigurationController extends AbstractConversationController {

    private static final Logger log = org.apache.log4j.Logger.getLogger(ConfigurationController.class);

    /*
     * Temporary settings file, right now works only on Windows.
     */
    private final static String INIT_FILE = "C:\\tmp\\settings.xml";

    private Configuration configuration;

    private Source selectedSource;

    @Override
    public void load() {

        try {
            // TODO: Create service for data reading
            JAXBContext jc = JAXBContext.newInstance(Configuration.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            configuration = (Configuration) unmarshaller.unmarshal(new File(INIT_FILE));

         } catch(JAXBException e){
            throw new RuntimeException("Exception with unmarshalling file: " + INIT_FILE, e);
        }

    }

    /**
     * Write new Source to configuration
     */
    public void writeToXml() {

        /*
         * Prepare Source object.
         * TODO: Enter new Source object in form
         */
        configuration.getSource().add(prepareNewSourceToWrite());

        /*
         * Marshall new Source object
         */
        try {
            // TODO: Create service for data writing
            JAXBContext jc = JAXBContext.newInstance(Configuration.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(configuration, new File(INIT_FILE));

        } catch (JAXBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    /**
     * Temporary method to manually prepare Source object.
     * Delete when adding Source from page is possible.
     * @return
     */
    private Source prepareNewSourceToWrite() {

        Source source = new Source();
        source.setFileName("Nme3");
        source.setApproved(true);
        source.setEnabled(true);
        source.setFileUrl("hi");
        source.setVisible(true);
        source.setSourceName("Source X");

        Owner o = new Owner();
        o.setName("Tadej");
        o.setLastName("Cakarevic");

        source.setOwner(o);

        return source;

    }

    public void selectSource(Source source) {

        selectedSource = source;

    }

    /*
     * Getters and Setters
     */

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Source getSelectedSource() {
        return selectedSource;
    }

    public void setSelectedSource(Source selectedSource) {
        this.selectedSource = selectedSource;
    }
}
