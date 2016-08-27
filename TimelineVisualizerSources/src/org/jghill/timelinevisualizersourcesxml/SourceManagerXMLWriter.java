package org.jghill.timelinevisualizersourcesxml;

import org.jghill.timelinevisualizersources.SourceCollection;

/**
 * An XML writer for the Source Manager info.
 * 
 * @author JGHill
 */
public interface SourceManagerXMLWriter {
    
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