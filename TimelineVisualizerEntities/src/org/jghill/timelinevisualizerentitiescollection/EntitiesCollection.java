package org.jghill.timelinevisualizerentitiescollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jghill.timelinevisualizerentities.Entities;

/**
 * Holds collections of other Entities, whether PhysicalThings or other
 * EntitiesCollections.
 * 
 * @author JGHill
 */
public class EntitiesCollection extends Entities {
    
    private final List<Entities> list;
    
    /**
     * Constructor.
     * 
     * @param name of this collection of Entities.
     */
    public EntitiesCollection(String name) {
        super(name, "", "", "");
        list = new ArrayList<>();
    }
    
    /**
     * Allows other entities to be added to this entity.
     * 
     * @param e another entity to be added.
     */
    public void addThing(Entities e) {
        list.add(e);
        Collections.sort(list);
    }
    
    /**
     * Allows a count of the entities to be returned.
     * 
     * @return a count of the entities within the list.
     */
    public int count() {
        return list.size();
    }
    
    /**
     * Return the entire list.
     * 
     * @return the entity list.
     */
    public List<Entities> getCollectionSet() {
        List<Entities> arr = new ArrayList<>();
        list.stream().forEach((e) -> {
            if(e instanceof EntitiesCollection) {
                arr.addAll(entitiesFlatten((EntitiesCollection)e));
            } else {
                arr.add(e);
            }
        });
        return arr;
    }
    
    /**
     * Flattens the entities collection into a single list.
     * 
     * @param coll the EntitiesCollection.
     * @return a list containing all internal non-collections.
     */
    private List<Entities> entitiesFlatten(EntitiesCollection coll) {
        List<Entities> arr = new ArrayList<>();
        coll.getCollectionSet().stream().forEach((e) -> {
            if(e instanceof EntitiesCollection) {
                arr.addAll(entitiesFlatten((EntitiesCollection)e));
            } else {
                arr.add(e);
            }
        });
        return arr;
    }
    
    /**
     * Remove all Entities which match the passed Query name.
     * 
     * @param queryName 
     */
    public void removeQuery(String queryName) {
        List removable = new ArrayList<>();
        list.stream().forEach((entity) -> {
            if (entity instanceof EntitiesCollection) {
                ((EntitiesCollection) entity).removeQuery(queryName);
            } else {
                if (entity != null) {
                    if (entity.getQueryName().equals(queryName)) {
                        removable.add(entity);
                    }
                }
            }
        });
        list.removeAll(removable);
    }
    
}