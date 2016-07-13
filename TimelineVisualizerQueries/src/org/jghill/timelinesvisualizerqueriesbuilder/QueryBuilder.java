package org.jghill.timelinesvisualizerqueriesbuilder;

import org.jghill.timelinevisualizerqueries.Query;
import org.jghill.timelinevisualizersources.Source;

/**
 * A singleton for building queries.
 * 
 * @author JGHill
 */
public class QueryBuilder {
    
    private static final QueryBuilder BUILDER = new QueryBuilder();
    
    private QueryBuilder() {}
    
    public static QueryBuilder getInstance() {
        return BUILDER;
    }
    
    /**
     * A method for building queries from a QuerySettings object.
     * 
     * @param settings the object containing the settings.
     * @return an object.
     */
    public static Query buildQuery(QuerySettings settings) {
        
        Source src = settings.theSource;
        Query qry;
        switch(src.getSourceType()){
            case "SPARQL Endpoint":
                ;
            default:
                ;
        }
        return qry;
    }
    
}