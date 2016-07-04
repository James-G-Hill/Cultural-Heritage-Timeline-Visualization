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
    private EntitiesCollection entities;
    private QueriesCollection queries;
    
    public void Project(
            String name,
            EntitiesCollection entities,
            QueriesCollection queries) {
        
        this.entities = entities;
        this.queries = queries;
    }
    
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
        return entities;
    }

    @Override
    public QueriesCollection getQueriesCollection() {
        return queries;
    }
    
}