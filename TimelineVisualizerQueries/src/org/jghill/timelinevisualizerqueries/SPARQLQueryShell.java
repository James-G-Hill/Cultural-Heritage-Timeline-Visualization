package org.jghill.timelinevisualizerqueries;

import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;

/**
 * A concrete implementation of the QueryShell class representing a SPARQL query.
 * 
 * @author JGHill
 */
public class SPARQLQueryShell extends QueryShell {
    
    String queryString;
    
    public SPARQLQueryShell(String queryString, String name) {
        this.queryString = queryString;
        super.setQueryName(name);
    }

    @Override
    public EntitiesCollection run() {
        
    }
    
}