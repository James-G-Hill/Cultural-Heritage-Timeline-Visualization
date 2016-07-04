package org.jghill.timelinevisualizerqueries;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A collection for holding a set of AbstractQueries.
 * 
 * @author JGHill
 */
public class QueryCollection {
    
    private final SortedSet<AbstractQuery> collection;
    
    public QueryCollection() {
        collection = new TreeSet<>();
    }
    
}