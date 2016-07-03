package org.jghill.timelinevisualizersources;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A singleton pattern holding a collections of sources.
 * 
 * @author JGHill
 */
public class SourceCollection {
    
    private static final SortedSet<Source> SOURCES = new TreeSet<>();
    private static final SourceCollection COLLECTION = new SourceCollection();
    
    private SourceCollection() {}
    
    /**
     * Returns the single instance of this singleton pattern.
     * 
     * @return 
     */
    public static SourceCollection getInstance() {
        return COLLECTION;
    }
    
    /**
     * Return the entire collection.
     * 
     * @return The source collection.
     */
    public SortedSet<Source> getSourceCollectionSet() {
        return SOURCES;
    }
    
    /**
     * Add a source to the collection.
     * 
     * @param newSource The new source to be added.
     */
    public boolean addSource(Source newSource) {
        return SOURCES.add(newSource);
    }
    
    /**
     * Delete a source from the collection & return 'true' to confirm
     * 
     * @param source The source to be deleted.
     */
    public boolean deleteSource(Source source) {
        return SOURCES.remove(source);
    }
    
    /**
     * Returns the number of sources in the SourceCollection.
     * 
     * @return the size of the collection.
     */
    public int getSize() {
        return SOURCES.size();
    }
    
}