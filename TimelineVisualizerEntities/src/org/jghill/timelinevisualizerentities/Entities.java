package org.jghill.timelinevisualizerentities;

import javax.management.Query;
import javax.xml.transform.Source;

/**
 * A class for representing collections & physical things as components of a
 * composition.
 * @author JGHill
 */
abstract public class Entities implements Comparable {
    
    private final String name;
    private final String identifier;
    private final Source source;
    private final Query query;
    
    public Entities(
            String name,
            String identifier,
            Source source,
            Query query
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
     * Returns the Source from which the entity was obtained.
     * @return the Source.
     */
    public Source getSource() {
        return source;
    }
    
    /**
     * Returns the Query which the entity was returned from.
     * @return the Query.
     */
    public Query getQuery() {
        return query;
    }
    
    @Override
    public int compareTo(Object o) {
        Entities e = (Entities) o;
        return name.compareTo(e.name);
    }
    
}