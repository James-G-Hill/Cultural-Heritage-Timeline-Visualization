package org.jghill.timelinevisualizerqueriescollection;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import org.jghill.timelinevisualizerqueries.Query;

/**
 * A collection for holding a set of AbstractQueries.
 * 
 * @author JGHill
 */
public class QueriesCollection implements Iterable<Query> {
    
    private final SortedSet<Query> collection;
    
    public QueriesCollection() {
        collection = new TreeSet<>();
    }
    
    /**
     * A method for adding new queries into the collection.
     * 
     * @param q A query.
     */
    public void addQuery(Query q) {
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

    @Override
    public Iterator iterator() {
        return collection.iterator();
    }
    
}