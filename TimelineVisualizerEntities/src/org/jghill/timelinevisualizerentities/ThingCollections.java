package org.jghill.timelinevisualizerentities;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Holds collections of other Entities, whether PhysicalThigns or other
 * ThingCollections.
 * 
 * @author JGHill
 */
public class ThingCollections extends Entities {
    
    private String collectionName;
    private String originalQuery;
    
    private final SortedSet<Entities> collection;
    
    public ThingCollections() {
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
     * A setter for naming the collection
     * 
     * @param name The name of the collection.
     */
    public void setCollectionName(String name) {
        collectionName = name;
    }
    
}