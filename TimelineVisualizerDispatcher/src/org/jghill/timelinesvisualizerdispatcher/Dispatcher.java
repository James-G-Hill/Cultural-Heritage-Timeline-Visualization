package org.jghill.timelinesvisualizerdispatcher;

import java.util.Date;
import java.util.concurrent.Callable;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.jghill.timelinevisualizerqueries.QueryShell;
import org.jghill.timelinevisualizerqueriescollection.QueriesCollection;
import org.netbeans.api.io.IOProvider;
import org.netbeans.api.io.InputOutput;

/**
 * A dispatcher sends queries and collects the results to create a collection
 * of entities.
 * 
 * @author JGHill
 */
public class Dispatcher implements Callable {
    
    private final QueriesCollection queries;
    
    /**
     * The Constructor.
     * 
     * @param queries to be dispatched to endpoints.
     */
    public Dispatcher(QueriesCollection queries) {
        this.queries = queries;
    }
    
    /**
     * Runs all queries in a collection.
     * 
     * @return a collection of entities built from the queries.
     */
    @Override
    public EntitiesCollection call() {
        
        EntitiesCollection entities;
        entities = new EntitiesCollection("Collection");
        
        output("Running campaigns");
        output("");
        for(QueryShell q : queries) {
            output("Running query: " + q.getQueryName());
            EntitiesCollection queryResults;
            queryResults = q.run();
            entities.addThing(queryResults);
            q.setLastRunDate(new Date());
        }
        output("");
        output("All campaigns run");
        output("");
        
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