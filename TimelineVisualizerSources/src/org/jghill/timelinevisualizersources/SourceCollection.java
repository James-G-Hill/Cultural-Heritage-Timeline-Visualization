package org.jghill.timelinevisualizersources;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Holds collections of sources.
 * 
 * @author JGHill
 */
public class SourceCollection {
    
    private final SortedSet<Source> sources;
    
    public SourceCollection() {
        sources = new TreeSet<>();
    }
    
    /**
     * Add a source to the collection.
     * 
     * @param newSource The new source to be added.
     */
    public void addSource(Source newSource) {
        sources.add(newSource);
    }
    
    /**
     * Delete a source from the collection & return 'true' to confirm
     * 
     * @param source The source to be deleted.
     */
    public boolean deleteSource(Source source) {
        return sources.remove(source);
    }
    
}