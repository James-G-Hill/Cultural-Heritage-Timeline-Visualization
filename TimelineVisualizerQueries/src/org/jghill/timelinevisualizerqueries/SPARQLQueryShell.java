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
    private final String cidoc;
    private final int limit;
    
    private static final String QUERY_TYPE = "SPARQL Endpoint";
    
    /**
     * The constructor.
     * 
     * @param queryString holding the SPARQL query.
     * @param service with the URI for the service address.
     * @param cidoc implementation used.
     * @param name of the Source.
     * @param limit the number of records required.
     */
    public SPARQLQueryShell(
            String queryString,
            String service,
            String cidoc,
            String name,
            int limit
    ) {
        this.queryString = queryString;
        this.service = service;
        this.cidoc = cidoc;
        this.limit = limit;
        super.setQueryName(name);
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
        output("");
        ResultSet results;
        
        try(QueryExecution qexec = QueryExecutionFactory.sparqlService(service, query)) {
            results = qexec.execSelect();
            return buildEntities(results, qexec);
        } catch (Exception ex) {
            System.out.println("Error? " + ex.getMessage());
            throw new HttpException("502 Proxy Error: " + ex.getMessage());
        }
        
    }
    
    /**
     * Builds the collection of entities.
     * 
     * @param results the ResultSet
     * @return the entities.
     */
    private EntitiesCollection buildEntities(
            ResultSet results,
            QueryExecution qexec
    ) {
        
        EntitiesCollection entities;
        entities = new EntitiesCollection(this.getQueryName());
        
        int recordCount = 0;
        
        for(; results.hasNext();) {
            
            QuerySolution soln = results.next();
            
            String identity = "";
            if (soln.get("identifier") != null) {
                identity = soln.get("identifier").toString().trim();
            }
            
            String title = "";
            if (soln.get("name") != null) {
                title = soln.get("name").toString().trim();
            } else {
                title = identity;
            }
            
            String depicts = "";
            if (soln.get("depicts") != null) {
                depicts = soln.get("depicts").toString().trim();
            }
            
            String consists = "";
            if (soln.get("consists") != null) {
                consists = soln.get("consists").toString().trim();
            }
            
            String type = "";
            if (soln.get("type") != null) {
                type = soln.get("type").toString().trim();
            }
            
            String technique = "";
            if (soln.get("technique") != null) {
                technique = soln.get("technique").toString().trim();
            }
            
            String image = "";
            if (soln.get("image") != null) {
                image = soln.get("image").toString();
            }
            
            String year = "";
            if (soln.get("date") != null) {
                year = soln.get("date").toString();
            }
            
            String creator = "";
            if (soln.get("creator") != null) {
                creator = soln.get("creator").toString().trim();
            }
            
            String object = "";
            if (soln.get("object") != null) {
                object = soln.get("object").toString();
            }
            
            String description = "";
            if (soln.get("description") != null) {
                description = soln.get("description").toString().trim();
            }
            
            String curatorial = "";
            if (soln.get("curatorial") != null) {
                curatorial = soln.get("curatorial").toString().trim();
            }
            
            output("");
            
            ManMadeObject thing = new ManMadeObject(
                    title,
                    identity,
                    service,
                    super.getQueryName(),
                    depicts,
                    consists,
                    type,
                    technique,
                    image,
                    year,
                    creator,
                    object,
                    description,
                    curatorial
            );
            
            if (!entities.getCollectionSet().contains(thing)) {
                entities.addThing(thing);
                recordCount++;
                
                output("Identifier  : " + identity.trim());
                output("Title       : " + title.trim());
                output("Depicts     : " + depicts.trim());
                output("Consists    : " + consists.trim());
                output("Type        : " + type.trim());
                output("Technique   : " + technique.trim());
                output("Image       : " + image.trim());
                output("Date        : " + year.trim());
                output("Creator     : " + creator.trim());
                output("Object      : " + object.trim());
                output("Description : " + description.trim());
                output("Curatorial  : " + curatorial.trim());
                
            }
            
            if (recordCount >= limit) {
                break;
            }
            
        }
        
        qexec.abort();
        qexec.close();
        
        return entities;
        
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
    
    /**
     * Returns the query as a String.
     * 
     * @return the query string.
     */
    public String getQueryString() {
        return queryString;
    }
    
    /**
     * Returns the service address.
     * 
     * @return the address.
     */
    public String getServiceAddress() {
        return service;
    }
    
    /**
     * Returns the CIDOC implementation address.
     * 
     * @return the CIDOC implementation.
     */
    public String getCIDOCAddress() {
        return cidoc;
    }
    
    /**
     * Returns the limit passed to this query.
     * 
     * @return the limit.
     */
    public int getLimit() {
        return limit;
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