
package at.xmlc.model.xml;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.xmlc.model.xml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.xmlc.model.xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Configuration }
     * 
     */
    public Configuration createConfiguration() {
        return new Configuration();
    }

    /**
     * Create an instance of {@link Source }
     * 
     */
    public Source createSource() {
        return new Source();
    }

    /**
     * Create an instance of {@link Owner }
     * 
     */
    public Owner createOwner() {
        return new Owner();
    }

}
