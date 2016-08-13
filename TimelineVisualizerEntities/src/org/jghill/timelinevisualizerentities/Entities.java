package org.jghill.timelinevisualizerentities;

/**
 * A class for representing collections & physical things as components of a
 * composition.
 * @author JGHill
 */
abstract public class Entities implements Comparable {
    
    private final String name;
    private final String identifier;
    private final String source;
    private final String query;
    
    public Entities(
            String name,
            String identifier,
            String source,
            String query
    ) {
        this.name = name;
        this.identifier = identifier;
        this.source = source;
        this.query = query;
    }
    
    /**
     * Returns the name of the entity.
     * @return the name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the identifier that the institution applied to the entity.
     * @return the identifier.
     */
    public String getIdentifier() {
        return identifier;
    }
    
    /**
     * Returns the Source name from which the entity was obtained.
     * @return the Source name.
     */
    public String getSourceName() {
        return source;
    }
    
    /**
     * Returns the Query name which the entity was returned from.
     * @return the Query name.
     */
    public String getQueryName() {
        return query;
    }
    
    @Override
    public int compareTo(Object o) {
        Entities e = (Entities) o;
        return name.compareTo(e.name);
    }
    
}