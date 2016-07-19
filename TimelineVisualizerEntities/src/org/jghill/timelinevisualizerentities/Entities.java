package org.jghill.timelinevisualizerentities;

/**
 * A class for representing collections & physical things as components of a
 * composition.
 * 
 * @author JGHill
 */
abstract public class Entities implements Comparable {
    
    private String name;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public int compareTo(Object o) {
        Entities e = (Entities) o;
        return name.compareTo(e.name);
    } 
    
}