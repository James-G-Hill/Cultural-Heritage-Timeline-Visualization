package org.jghill.timelinesvisualizerdispatcher;

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
public class Dispatcher {
    
    private static final Dispatcher DISPATCHER = new Dispatcher();
    
    private Dispatcher() {}
    
    /**
     * Returns an instance of this singleton.
     * 
     * @return the instance.
     */
    public static Dispatcher getInstance() {
        return DISPATCHER;
    }
    
    /**
     * Runs all queries in a collection.
     * 
     * @param queries the collection to run through.
     * @return a collection of entities built from the queries.
     */
    public EntitiesCollection runQueries(QueriesCollection queries) {
        
        EntitiesCollection entities;
        entities = new EntitiesCollection();
        
        output("Running campaigns");
        for(QueryShell q : queries) {
            output("Running query: " + q.getQueryName());
            entities.addThing(q.run());
        }
        output("All campaigns run");
        
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