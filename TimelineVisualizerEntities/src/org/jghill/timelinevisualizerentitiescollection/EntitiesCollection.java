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
    
    private String collectionName;
    private String originalQuery;
    
    private final SortedSet<Entities> collection;
    
    public EntitiesCollection() {
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
     * A getter for the collection name.
     * 
     * @return the name of this collection.
     */
    public String getCollectionName() {
        return  collectionName;
    }
    
    /**
     * A setter for naming the collection
     * 
     * @param name The name of the collection.
     */
    public void setCollectionName(String name) {
        collectionName = name;
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