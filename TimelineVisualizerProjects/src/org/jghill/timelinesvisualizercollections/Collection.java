package org.jghill.timelinesvisualizercollections;

import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.jghill.timelinevisualizerqueriescollection.QueriesCollection;

/**
 * A project for holding data from a set of queries.
 * 
 * @author JGHill
 */
public class Collection implements CollectionInt {

    private String name;
    private String notes;
    private final EntitiesCollection entities;
    private final QueriesCollection queries;
    
    /**
     * A constructor accepting containers.
     * 
     * @param entities an entities container.
     * @param queries a queries container.
     */
    public Collection(
            EntitiesCollection entities,
            QueriesCollection queries) {
        
        this.entities = entities;
        this.queries = queries;
    }
    
    /**
     * A constructor accepting containers.
     * 
     * @param name a name for the project.
     * @param entities an entities container.
     * @param queries a queries container.
     */
    public Collection(
            String name,
            EntitiesCollection entities,
            QueriesCollection queries) {
        
        this.name = name;
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
    public String getNotes() {
        return notes;
    }
    
    @Override
    public void setNotes(String notes) {
        this.notes = notes;
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