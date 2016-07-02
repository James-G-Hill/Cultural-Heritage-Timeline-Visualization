package org.jghill.timelinevisualizersources;

/**
 * A concrete class representing a SPARQL endpoint.
 * 
 * @author JGHill
 */
public class SPARQLEndpoint extends Source {
    
    private static final String SOURCE_TYPE = "SPARQL Endpoint";
    private String webAddress;
    
    /**
     * Constructor for the SPARQL endpoint.
     * 
     * @param name A name for the source.
     */
    public SPARQLEndpoint(String name, String webText) {
        super.setSourceName(name);
        this.webAddress = webText;
    }
    
    /**
     * Returns the type of the source.
     * 
     * @return The source type of this source.
     */
    @Override
    public String getSourceType() {
        return SOURCE_TYPE;
    }
    
    /**
     * A getter class for returning the web address.
     * 
     * @return The web address of the SPARQL endpoint.
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