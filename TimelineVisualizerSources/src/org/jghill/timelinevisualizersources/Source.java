package org.jghill.timelinevisualizersources;

/**
 * An abstract class to represent sources of data.
 * 
 * @author JGHill
 */
public abstract class Source implements Comparable<Source> {
    
    private String sourceName;
    
    /**
     * @return the type of the source.
     */
    public abstract String getSourceType();
    
    /**
     * @return the name of the source.
     */
    public String getSourceName() {
        return sourceName;
    }
    
    /**
     * @param name the name for this source.
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