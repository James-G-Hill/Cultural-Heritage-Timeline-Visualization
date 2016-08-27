package org.jghill.timelinevisualizersourcesxml;

import org.jghill.timelinevisualizersources.SourceCollection;

/**
 * An interface for XML parsing the Source Manager information.
 * 
 * @author JGHill
 */
public interface SourceManagerXMLParser {
    
    /**
     * Builds a DOM document for this Source Manager.
     * 
     * @param collection of Sources to be built from.
     */
    public void build(SourceCollection collection);
    
    /**
     * Prints a DOM document to the system.
     */
    public void print();
    
}