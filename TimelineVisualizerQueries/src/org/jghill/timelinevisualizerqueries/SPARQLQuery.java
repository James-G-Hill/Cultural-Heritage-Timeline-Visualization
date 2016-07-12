package org.jghill.timelinevisualizerqueries;

import org.apache.jena.query.*;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;

/**
 * A concrete implementation of the Query class representing a SPARQL query.
 * 
 * @author JGHill
 */
public class SPARQLQuery extends Query {
    
    Query sparqlQuery;
    
    public SPARQLQuery(Query q) {
        sparqlQuery = q;
    }
    
    public SPARQLQuery(Query q, String name) {
        sparqlQuery = q;
        super.setQueryName(name);
    }

    @Override
    public EntitiesCollection run() {
        
    }
    
}