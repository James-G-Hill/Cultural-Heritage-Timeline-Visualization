package org.jghill.timelinevisualizerentities;

/**
 * A class for representing collections & physical things as components of a
 * composition.
 * 
 * @author JGHill
 */
abstract public class Entities implements Comparable {
    
    private String identifier = "";
    
    public void setName(String identifier) {
        this.identifier = identifier;
    }
    
    public String getName() {
        return identifier;
    }
    
    @Override
    public int compareTo(Object o) {
        Entities e = (Entities) o;
        return identifier.compareTo(e.identifier);
    } 
    
}