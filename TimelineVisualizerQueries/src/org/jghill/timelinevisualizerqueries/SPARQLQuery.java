package org.jghill.timelinevisualizerqueries;

import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;

/**
 * A concrete implementation of the Query class representing a SPARQL query.
 * 
 * @author JGHill
 */
public class SPARQLQuery extends Query {
    
    String queryString;
    
    public SPARQLQuery(String queryString, String name) {
        this.queryString = queryString;
        super.setQueryName(name);
    }

    @Override
    public EntitiesCollection run() {
        
    }
    
}