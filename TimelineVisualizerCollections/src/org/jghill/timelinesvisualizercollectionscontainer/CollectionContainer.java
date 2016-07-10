package org.jghill.timelinesvisualizercollectionscontainer;

import java.util.SortedSet;
import java.util.TreeSet;
import org.jghill.timelinesvisualizercollections.Collection;
import org.jghill.timelinesvisualizercollectionsnode.CollectionChildren;

/**
 * A collection for holding projects.
 * 
 * @author JGHill
 */
public class CollectionContainer {
    
    private static final CollectionChildren CHILDREN = new CollectionChildren();
    private static final CollectionContainer CONTAINER = new CollectionContainer();
    private static final SortedSet<Collection> COLLECTION = new TreeSet<>();
    
    private CollectionContainer() {}
    
    /**
     * Returns the single instance of this singleton pattern.
     * 
     * @return the single instance of this container.
     */
    public static CollectionContainer getInstance() {
        return CONTAINER;
    }
    
    /**
     * A method for adding collections to the container.
     * 
     * @param coll the project to be added.
     */
    public void addCollection(Collection coll) {
        COLLECTION.add(coll);
        CHILDREN.update(COLLECTION.toArray(new Collection[COLLECTION.size()]));
    }
    
    /**
     * A method for removing collections from the container.
     * 
     * @param coll the project to be added.
     */
    public void deleteCollection(Collection coll) {
        COLLECTION.remove(coll);
        CHILDREN.update(COLLECTION.toArray(new Collection[COLLECTION.size()]));
    }
    
    /**
     * Returns the size of the collection.
     * 
     * @return the size of the collection.
     */
    public int getSize() {
        return COLLECTION.size();
    }
    
    public CollectionChildren getChildren() {
        return CHILDREN;
    }
    
}