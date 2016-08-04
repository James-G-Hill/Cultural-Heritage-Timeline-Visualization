package org.jghill.timelinesvisualizercollections;

import org.jghill.timelinesvisualizercollections.gui.CollectionTopComponent;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.jghill.timelinevisualizerqueriescollection.QueriesCollection;
import org.openide.util.Lookup;

/**
 * An interface for Collections.
 * 
 * @author JGHill
 */
public interface Collection {
    
    public String getName();
    
    public void setName(String name);
    
    public String getNotes();
    
    public void setNotes(String notes);
    
    public EntitiesCollection getEntitiesCollection();
    
    public QueriesCollection getQueriesCollection();
    
    public Lookup getLookup();
    
    public void setTopComponent(CollectionTopComponent tc);
    
    public void clearEntitiesCollection();
    
}