package org.jghill.timelinevisualizersources;

/**
 * A concrete class representing a SPARQL endpoint.
 * 
 * @author JGHill
 */
public class SPARQLEndpoint extends Source {
    
    private static final String SOURCE_TYPE = "SPARQL Endpoint";
    private String webAddress;
    private String cidocAddress;
    
    /**
     * Constructor for the SPARQL endpoint.
     * 
     * @param name A name for the source.
     * @param webAddress the web address.
     * @param cidoc the CIDOC CRM address.
     */
    public SPARQLEndpoint(
            String name,
            String webAddress,
            String cidoc
    ) {
        super.setSourceName(name);
        this.webAddress = webAddress;
        this.cidocAddress = cidoc;
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
     * @return The web address of the SPARQL endpoint.
     */
    public String getWebAddress() {
        return webAddress;
    }
    
    /**
     * @param address The web address.
     */
    public void setWebAddress(String address) {
        webAddress = address;
    }
    
    /**
     * @return the CIDOC CRM address.
     */
    public String getCIDOCAddress() {
        return cidocAddress;
    }
    
    /**
     * @param address The CIDOC CRM address.
     */
    public void setCIDOCAddress(String address) {
        cidocAddress = address;
    }
    
}