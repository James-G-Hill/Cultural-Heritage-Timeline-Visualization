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
    
    /**
     * A method for returning a count of the queries in the collection.
     * 
     * @return the count of queries.
     */
    public int getCount() {
        return collection.size();
    }
    
}