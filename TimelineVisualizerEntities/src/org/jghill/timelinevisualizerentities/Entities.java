package org.jghill.timelinevisualizerentities;

/**
 * A class for representing collections & physical things as components of a
 * composition.
 * 
 * @author JGHill
 */
abstract public class Entities implements Comparable {
    
    private static final String NO_IDENTIFIER = "No Identifier";
    
    private final String name;
    private final String identifier;
    
    public Entities(String name) {
        this.name = name;
        this.identifier = NO_IDENTIFIER;
    }
    
    public Entities(String name, String identifier) {
        this.name = name;
        this.identifier = identifier;
    }
    
    public String getName() {
        return name;
    }
    
    public String getIdentifier() {
        return identifier;
    }
    
    @Override
    public int compareTo(Object o) {
        Entities e = (Entities) o;
        return name.compareTo(e.name);
    }
    
}