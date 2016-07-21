package org.jghill.timelinevisualizerentitiescollection;

import java.util.SortedSet;
import java.util.TreeSet;
import org.jghill.timelinevisualizerentities.Entities;

/**
 * Holds collections of other Entities, whether PhysicalThings or other
 * EntitiesCollections.
 * 
 * @author JGHill
 */
public class EntitiesCollection extends Entities {
    
    private String originalQuery;
    
    private final SortedSet<Entities> collection;
    
    public EntitiesCollection(String name) {
        super(name);
        collection = new TreeSet<>();
    }
    
    /**
     * Allows other entities to be added to this entity.
     * 
     * @param e another entity to be added.
     */
    public void addThing(Entities e) {
        collection.add(e);
    }
    
    /**
     * Allows a count of the entities to be returned.
     * 
     * @return a count of the entities within the collection.
     */
    public int count() {
        return collection.size();
    }
    
    /**
     * Return the entire collection.
     * 
     * @return the entity collection.
     */
    public SortedSet<Entities> getCollectionSet() {
        return collection;
    }
    
}