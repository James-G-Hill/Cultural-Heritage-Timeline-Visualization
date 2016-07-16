package org.jghill.timelinevisualizerqueries;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;

/**
 * A concrete implementation of the QueryShell class representing a SPARQL query.
 * 
 * @author JGHill
 */
public class SPARQLQueryShell extends QueryShell {
    
    private final String queryString;
    
    public SPARQLQueryShell(String queryString, String name) {
        this.queryString = queryString;
        super.setQueryName(name);
    }

    @Override
    public EntitiesCollection run() {
        return getResults(QueryFactory.create(queryString));
    }
    
    /**
     * Executes the query and returns the results.
     * 
     * @param query the QueryFactory.
     * @return the entities.
     */
    private EntitiesCollection getResults(Query query) {
        try(QueryExecution qexec = QueryExecutionFactory.create(query)) {
            ResultSet results = qexec.execSelect();
            return buildEntities(results);
        }
    }
    
    /**
     * Builds the collection of entities.
     * 
     * @param results the ResultSet
     * @return the entities.
     */
    private EntitiesCollection buildEntities(ResultSet results) {
        EntitiesCollection entities = new EntitiesCollection();
        for(; results.hasNext();) {
            QuerySolution soln = results.next();
            
            String owner = soln.getLiteral("owner").getString();
            
            ManMadeObject thing;
            thing = new ManMadeObject(
                    owner
            );
            entities.addThing(thing);
        }
        return entities;
    }
    
}