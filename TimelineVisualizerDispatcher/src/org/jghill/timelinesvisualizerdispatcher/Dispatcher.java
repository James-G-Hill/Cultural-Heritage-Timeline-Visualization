package org.jghill.timelinesvisualizerdispatcher;

import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.jghill.timelinevisualizerqueriescollection.QueriesCollection;

/**
 * A dispatcher sends queries and collects the results to create a collection
 * of entities.
 * 
 * @author JGHill
 */
public class Dispatcher {
    
    private static final Dispatcher DISPATCHER = new Dispatcher();
    
    private Dispatcher() {}
    
    /**
     * Returns an instance of this singleton.
     * 
     * @return the instance.
     */
    public Dispatcher getInstance() {
        return DISPATCHER;
    }
    
    /**
     * Runs all queries in a collection.
     * 
     * @param queries the collection to run through.
     * @return a collection of entities built from the queries.
     */
    public EntitiesCollection runQueries(QueriesCollection queries) {
        
        EntitiesCollection entities;
        entities = new EntitiesCollection();
        
        //Enter code here.
        
        return entities;
        
    }
    
}