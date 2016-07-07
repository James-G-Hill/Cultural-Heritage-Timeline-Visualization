package org.jghill.timelinesvisualizercollectionscontainer;

import java.util.SortedSet;
import java.util.TreeSet;
import org.jghill.timelinesvisualizercollections.CollectionInt;
import org.openide.nodes.Index;

/**
 * A collection for holding projects.
 * 
 * @author JGHill
 */
public class CollectionContainer extends Index.ArrayChildren {
    
    private static final CollectionContainer CONTAINER = new CollectionContainer();
    private static final SortedSet<CollectionInt> COLLECTION = new TreeSet<>();
    
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
    public boolean addCollection(CollectionInt coll) {
        return COLLECTION.add(coll);
    }
    
    /**
     * A method for removing collections from the container.
     * 
     * @param coll the project to be added.
     */
    public boolean deleteCollection(CollectionInt coll) {
        return COLLECTION.remove(coll);
    }
    
}