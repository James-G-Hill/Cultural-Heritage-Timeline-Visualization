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
    
    private static final CollectionContainer CONTAINER = new CollectionContainer();
    private static final SortedSet<Collection> COLLECTION = new TreeSet<>();
    
    private CollectionContainer() {}
    
    /**
     * Returns the single instance of this singleton pattern.
     * 
     * @return 
     */
    public static CollectionContainer getInstance() {
        return CONTAINER;
    }
    
    /**
     * A method for adding collections to the container.
     * 
     * @param coll the project to be added.
     */
    public boolean addCollection(Collection coll) {
        return COLLECTION.add(coll);
    }
    
    /**
     * A method for removing collections from the container.
     * 
     * @param coll the project to be added.
     */
    public boolean deleteCollection(Collection coll) {
        return COLLECTION.remove(coll);
    }
    
    /**
     * Returns the size of the collection.
     * 
     * @return the size of the collection.
     */
    public int getSize() {
        return COLLECTION.size();
    }
    
    /**
     * Returns the container contents as an array.
     * 
     * @return the contents of the container.
     */
    public Collection[] collectionsToArray() {
        return COLLECTION.toArray(new Collection[COLLECTION.size()]);
    }
    
}