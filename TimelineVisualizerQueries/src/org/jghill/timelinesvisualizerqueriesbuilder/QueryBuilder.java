package org.jghill.timelinesvisualizerqueriesbuilder;

import org.jghill.timelinevisualizerqueries.QueryShell;
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
    public QueryShell buildQuery(QuerySettings settings) {
        
        Source src = settings.theSource;
        QueryTranslator trans;
        
        switch(src.getSourceType()){
            case "SPARQL Endpoint":
                trans = new SPARQLTranslator();
                return trans.translate(settings);
            default:
                return null;
        }
    }
    
}