package org.jghill.timelinevisualizerqueries;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.netbeans.api.io.IOProvider;
import org.netbeans.api.io.InputOutput;

/**
 * A concrete implementation of the QueryShell class representing a SPARQL query.
 * 
 * @author JGHill
 */
public class SPARQLQueryShell extends QueryShell {
    
    private final String queryString;
    private static final String QUERY_TYPE = "SPARQL Endpoint";
    
    public SPARQLQueryShell(String queryString, String name) {
        this.queryString = queryString;
        super.setQueryName(name);
    }
    
    /**
     * Returns the type of the query.
     * 
     * @return The query type.
     */
    @Override
    public String getQueryType() {
        return QUERY_TYPE;
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
            output(soln.toString());
            
            String owner = soln.getLiteral("owner").getString();
            
            ManMadeObject thing;
            thing = new ManMadeObject(
                    owner
            );
            entities.addThing(thing);
        }
        return entities;
    }

    @Override
    public int compareTo(Object o) {
        QueryShell query = (QueryShell) o;
        return super.getQueryName().compareTo(query.getQueryName());
    }
    
    /**
     * Outputs an explanation of the action.
     * @param name the name of the Collection that was created.
     */
    private void output(String soln) {
        InputOutput io = IOProvider.getDefault().getIO("Main", false);
        io.getOut().println(soln);
    }
    
}