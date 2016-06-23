package org.jghill.timelinevisualizersources;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A singleton pattern holding a collections of sources.
 * 
 * @author JGHill
 */
public class SourceCollection {
    
    private static SortedSet<Source> sources = new TreeSet<>();
    private static SourceCollection collection = new SourceCollection();
    
    private SourceCollection() {}
    
    /**
     * Returns the single instance of this singleton pattern.
     * 
     * @return 
     */
    public static SourceCollection getInstance() {
        return collection;
    }
    
    /**
     * Return the entire collection.
     * 
     * @return The source collection.
     */
    public SortedSet<Source> getSourceCollectionSet() {
        return sources;
    }
    
    /**
     * Add a source to the collection.
     * 
     * @param newSource The new source to be added.
     */
    public boolean addSource(Source newSource) {
        return sources.add(newSource);
    }
    
    /**
     * Delete a source from the collection & return 'true' to confirm
     * 
     * @param source The source to be deleted.
     */
    public boolean deleteSource(Source source) {
        return sources.remove(source);
    }
    
    /**
     * Returns the number of sources in the SourceCollection.
     * 
     * @return the size of the collection.
     */
    public int getSize() {
        return sources.size();
    }
    
}