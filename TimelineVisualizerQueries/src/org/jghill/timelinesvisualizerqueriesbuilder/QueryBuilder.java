package org.jghill.timelinesvisualizerqueriesbuilder;

import org.jghill.timelinevisualizerqueries.Query;

/**
 * A singleton for building queries.
 * 
 * @author JGHill
 */
public class QueryBuilder {
    
    QueryBuilder BUILDER = new QueryBuilder();
    
    private QueryBuilder() {}
    
    public QueryBuilder getInstance() {
        return BUILDER;
    }
    
    /**
     * A method for building queries from a QuerySettings object.
     * 
     * @param settings the object containing the settings.
     * @return an object.
     */
    public Query buildQuery(QuerySettings settings) {
        
    }
    
}