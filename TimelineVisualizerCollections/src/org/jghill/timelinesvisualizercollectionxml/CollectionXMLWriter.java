package org.jghill.timelinesvisualizercollectionxml;

/**
 * A writer for collections.
 * 
 * @author JGHill
 */
public interface CollectionXMLWriter {
    
    /**
     * Builds a DOM document for this Collection.
     */
    public void build();
    
    /**
     * Prints a DOM document to the system.
     */
    public void print();
    
}