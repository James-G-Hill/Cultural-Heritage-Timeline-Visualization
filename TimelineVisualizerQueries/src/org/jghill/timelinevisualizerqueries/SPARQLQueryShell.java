package org.jghill.timelinevisualizerqueries;

import org.apache.jena.atlas.web.HttpException;
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
    private final String service;
    private static final String QUERY_TYPE = "SPARQL Endpoint";
    
    public SPARQLQueryShell(String queryString, String service, String name) {
        this.queryString = queryString;
        this.service = service;
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
        output("Running query");
        output(queryString);
        return getResults(QueryFactory.create(queryString));
    }
    
    /**
     * Executes the query and returns the results.
     * 
     * @param query the QueryFactory.
     * @return the entities.
     */
    private EntitiesCollection getResults(Query query) throws HttpException {
        output("getting results");
        ResultSet results;
        try(QueryExecution qexec = QueryExecutionFactory.sparqlService(service, query)) {
            results = qexec.execSelect();
            return buildEntities(results);
        } catch (HttpException ex) {
            throw new HttpException("502 Proxy Error: ");
        }
    }
    
    /**
     * Builds the collection of entities.
     * 
     * @param results the ResultSet
     * @return the entities.
     */
    private EntitiesCollection buildEntities(ResultSet results) {
        EntitiesCollection entities;
        entities = new EntitiesCollection(this.getQueryName());
        for(; results.hasNext();) {
            QuerySolution soln = results.next();
            
            output("Solution: " + soln.toString());
            
            String identity = soln.get("identifier").toString();
            String title = soln.get("title").toString();
            
            String image = "";
            if(soln.get("image") != null) {
                image = soln.get("image").toString();
            }
            
            String begin = soln.get("begin").toString();
            String finish = soln.get("finish").toString();
            
            output("Identifier  : " + identity);
            output("Title       : " + title);
            output("Image       : " + image);
            output("Begin       : " + begin);
            output("Finish      : " + finish);
            
            ManMadeObject thing;
            thing = new ManMadeObject(
                    title,
                    identity,
                    image,
                    begin,
                    finish
            );
            entities.addThing(thing);
        }
        return entities;
    }
    
    /**
     * Outputs an explanation of the action.
     * 
     * @param text toString of the returned entity.
     */
    private void output(String text) {
        InputOutput io = IOProvider.getDefault().getIO("Main", false);
        io.getOut().println(text);
    }
    
}