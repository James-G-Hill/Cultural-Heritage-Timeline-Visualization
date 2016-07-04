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
    
    /**
     * A method for adding new queries into the collection.
     * 
     * @param q A query.
     */
    public void addQuery(AbstractQuery q) {
        collection.add(q);
    }
    
}