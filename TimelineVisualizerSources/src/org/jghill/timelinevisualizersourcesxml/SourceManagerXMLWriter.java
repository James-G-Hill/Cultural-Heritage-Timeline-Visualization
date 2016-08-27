package org.jghill.timelinevisualizersourcesxml;

/**
 * An XML writer for the Source Manager info.
 * 
 * @author JGHill
 */
public interface SourceManagerXMLWriter {
    
    /**
     * Builds a DOM document for this Source Manager.
     */
    public void build();
    
    /**
     * Prints a DOM document to the system.
     */
    public void print();
    
}