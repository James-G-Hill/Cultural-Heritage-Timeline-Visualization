package org.jghill.timelinevisualizersources;

/**
 * A concrete class representing a SPARQL endpoint.
 * 
 * @author JGHill
 */
public class SPARQLEndpoint extends Source {
    
    private String webAddress;
    
    /**
     * A getter class for returning the web address.
     */
    public String getWebAddress() {
        return webAddress;
    }
    
    /**
     * A setter class for assigning a web address.
     * 
     * @param address The web address.
     */
    public void setWebAddress(String address) {
        webAddress = address;
    }
    
}