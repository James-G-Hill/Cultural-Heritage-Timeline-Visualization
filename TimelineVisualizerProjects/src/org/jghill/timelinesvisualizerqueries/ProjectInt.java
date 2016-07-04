package org.jghill.timelinesvisualizerqueries;

import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.jghill.timelinevisualizerqueriescollection.QueriesCollection;

/**
 * An interface for Projects.
 * 
 * @author JGHill
 */
public interface ProjectInt {
    
    public String getName();
    
    public void setName(String name);
    
    public EntitiesCollection getEntitiesCollection();
    
    public void setEntitiesCollection(EntitiesCollection collection);
    
    public QueriesCollection getQueriesCollection();
    
    public void setQueriesCollection(QueriesCollection collection);
    
}