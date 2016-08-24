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
import org.jghill.timelinevisualizersources.SPARQLEndpoint;
import org.netbeans.api.io.IOProvider;
import org.netbeans.api.io.InputOutput;

/**
 * A concrete implementation of the QueryShell class representing a SPARQL query.
 * 
 * @author JGHill
 */
public class SPARQLQueryShell extends QueryShell {
    
    private final String queryString;
    private final SPARQLEndpoint service;
    
    private static final String QUERY_TYPE = "SPARQL Endpoint";
    
    /**
     * The constructor.
     * 
     * @param queryString holding the SPARQL query.
     * @param service with the URI for the service address.
     * @param name of the Source.
     */
    public SPARQLQueryShell(
            String queryString,
            SPARQLEndpoint service,
            String name
    ) {
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
        
        try(QueryExecution qexec = QueryExecutionFactory.sparqlService(service.getWebAddress(), query)) {
            results = qexec.execSelect();
            return buildEntities(results);
        } catch (HttpException ex) {
            throw new HttpException("502 Proxy Error: " + ex.getMessage());
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
            
            String identity = "";
            if (soln.get("identifier") != null) {
                identity = soln.get("identifier").toString();
                output("Identifier  : " + identity);
            }
            
            String title = "";
            if (soln.get("name") != null) {
                title = soln.get("name").toString();
                output("Title       : " + title);
            } else {
                title = identity;
            }
            
            String depicts = "";
            if (soln.get("depictsSample") != null) {
                depicts = soln.get("depictsSample").toString();
                output("Depicts     : " + depicts);
            }
            
            String consists = "";
            if (soln.get("consistsSample") != null) {
                consists = soln.get("consistsSample").toString();
                output("Consists    : " + consists);
            }
            
            String type = "";
            if (soln.get("typeSample") != null) {
                type = soln.get("typeSample").toString();
                output("Type        : " + type);
            }
            
            String technique = "";
            if (soln.get("techniqueSample") != null) {
                technique = soln.get("techniqueSample").toString();
                output("Technique   : " + technique);
            }
            
            String image = "";
            if (soln.get("image") != null) {
                image = soln.get("image").toString();
                output("Image       : " + image);
            }
            
            String year = "";
            if (soln.get("dateSample") != null) {
                year = soln.get("dateSample").toString();
                output("Date        : " + year);
            }
            
            String description = "";
            if (soln.get("description") != null) {
                description = soln.get("description").toString();
                output("Description : " + description);
            }
            
            String curatorial = "";
            if (soln.get("curatorial") != null) {
                curatorial = soln.get("curatorial").toString();
                output("Curatorial  : " + curatorial);
            }
            
            ManMadeObject thing;
            thing = new ManMadeObject(
                    title,
                    identity,
                    service.getSourceName(),
                    super.getQueryName(),
                    depicts,
                    consists,
                    type,
                    technique,
                    image,
                    year,
                    description,
                    curatorial
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