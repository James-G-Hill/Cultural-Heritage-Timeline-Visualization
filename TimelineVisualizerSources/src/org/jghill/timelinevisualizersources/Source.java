package org.jghill.timelinevisualizersources;

/**
 * An abstract class to represent sources of data.
 * 
 * @author JGHill
 */
abstract class Source {
    
    private String sourceName;
    
    /**
     * Returns the name of this source.
     */
    public String getSourceName() {
        return sourceName;
    }
    
    /**
     * Sets the sourceName to a passed name.
     * 
     * @param name The name for this source.
     */
    public void setSourceName(String name) {
        sourceName = name;
    }
    
}