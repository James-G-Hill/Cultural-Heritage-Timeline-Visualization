package org.jghill.timelinevisualizersources;

/**
 * An abstract class to represent sources of data.
 * 
 * @author JGHill
 */
public abstract class Source implements Comparable<Source> {
    
    private String sourceName;
    
    /**
     * Returns the type of the source.
     * 
     * @return The type of the source.
     */
    public abstract String getSourceType();
    
    /**
     * Returns the name of this source.
     * 
     * @return The name of the source.
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
    
    @Override
    public int compareTo(Source o) {
        return sourceName.compareTo(o.getSourceName());
    }
    
    @Override
    public String toString() {
        return sourceName;
    }
    
}