package org.jghill.timelinesvisualizercollectionscontainer;

import java.util.SortedSet;
import java.util.TreeSet;
import org.jghill.timelinesvisualizercollections.Collection;

/**
 * A collection for holding projects.
 * 
 * @author JGHill
 */
public class CollectionContainer {
    
    private final SortedSet<Collection> collection;
    
    public CollectionContainer() {
        collection = new TreeSet<>();
    }
    
    /**
     * A method for adding projects to the collection.
     * 
     * @param proj the project to be added.
     */
    public void addProject(Collection proj) {
        collection.add(proj);
    }
    
}