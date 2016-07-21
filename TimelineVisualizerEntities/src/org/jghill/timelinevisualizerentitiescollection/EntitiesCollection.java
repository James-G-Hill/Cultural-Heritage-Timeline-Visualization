package org.jghill.timelinevisualizerentitiescollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    
    private final List<Entities> list;
    
    public EntitiesCollection(String name) {
        super(name);
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
    public SortedSet<Entities> getCollectionSet() {
        SortedSet<Entities> sorted = new TreeSet<>();
        sorted.addAll(list);
        return sorted;
    }
    
}