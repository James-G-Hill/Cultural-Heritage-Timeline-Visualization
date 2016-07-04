package org.jghill.timelinesvisualizerprojects;

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
    
    public QueriesCollection getQueriesCollection();
    
}