package org.jghill.timelinesvisualizercollections.container;

import java.io.File;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import org.jghill.timelinesvisualizercollections.Collection;
import org.jghill.timelinesvisualizercollections.node.CollectionChildren;
import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

/**
 * A collection for holding projects.
 * 
 * @author JGHill
 */
public class CollectionContainer {
    
    private static final CollectionChildren CHILDREN = new CollectionChildren();
    private static final CollectionContainer CONTAINER = new CollectionContainer();
    private static final SortedSet<Collection> COLLECTION = new TreeSet<>();
    
    private static final InstanceContent CONTENT = new InstanceContent();
    private static final Lookup LKP = new AbstractLookup(CONTENT);
    
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
    public static void addCollection(Collection coll) {
        COLLECTION.add(coll);
        CHILDREN.update(COLLECTION.toArray(new Collection[0]));
    }
    
    /**
     * A method for removing collections from the container.
     * 
     * @param coll the project to be added.
     */
    public static void deleteCollection(Collection coll) {
        COLLECTION.remove(coll);
        CHILDREN.update(COLLECTION.toArray(new Collection[0]));
        File file = new File("Collections/" + coll.getName() + ".xml");
        file.delete();
    }
    
    /**
     * Returns the size of the collection.
     * 
     * @return the size of the collection.
     */
    public static int getSize() {
        return COLLECTION.size();
    }
    
    /**
     * Returns all the CollectionChildren.
     * 
     * @return the CollectionChildren.
     */
    public static CollectionChildren getChildren() {
        return CHILDREN;
    }
    
    /**
     * Returns the Lookup for this container.
     * 
     * @return the Lookup.
     */
    public static Lookup getLookup() {
        return LKP;
    }
    
    /**
     * Adds a Collection to the lookup for the container.
     * 
     * @param coll to be added.
     */
    public static void addToLookup(Collection coll) {
        CONTENT.set(Collections.EMPTY_LIST, null);
        CONTENT.add(coll);
    }
    
}