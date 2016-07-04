package org.jghill.timelinesvisualizerqueries;

import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.jghill.timelinevisualizerqueriescollection.QueriesCollection;

/**
 * A project for holding data from a set of queries.
 * 
 * @author JGHill
 */
public class Project implements ProjectInt {

    private String name;
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public EntitiesCollection getEntitiesCollection() {
        
    }

    @Override
    public void setEntitiesCollection(EntitiesCollection collection) {
        
    }

    @Override
    public QueriesCollection getQueriesCollection() {
        
    }

    @Override
    public void setQueriesCollection(QueriesCollection collection) {
        
    }
    
}