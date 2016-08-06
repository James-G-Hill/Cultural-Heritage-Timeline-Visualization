package org.jghill.timelinesvisualizercollections;

import org.jghill.timelinesvisualizercollections.container.CollectionContainer;
import org.jghill.timelinesvisualizercollections.gui.CollectionTopComponent;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.jghill.timelinevisualizerqueriescollection.QueriesCollection;
import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

/**
 * A project for holding data from a set of queries.
 * 
 * @author JGHill
 */
public class CollectionImpl implements Collection, Comparable<CollectionImpl>, Lookup.Provider {

    private String name;
    private String notes;
    private final Lookup lu;
    private final InstanceContent instanceContent;
    private EntitiesCollection entities;
    private final QueriesCollection queries;
    private CollectionTopComponent tc;
    
    /**
     * A constructor accepting containers.
     * @param name a name for the project.
     * @param entities an entities container.
     * @param queries a queries container.
     */
    public CollectionImpl(
            String name,
            EntitiesCollection entities,
            QueriesCollection queries) {
        
        this.name = name;
        this.entities = entities;
        this.queries = queries;
        instanceContent = new InstanceContent();
        lu = new AbstractLookup(instanceContent);
        
        instanceContent.add(
            new CanOpen() {
                @Override
                public void open(Collection coll) {
                    if(!tc.isOpened() || tc == null) {
                        CollectionContainer.addToLookup(coll);
                        CollectionTopComponent collTC = new CollectionTopComponent();
                        collTC.open();
                        collTC.requestActive();
                    }
                }
            }
        );
        
        instanceContent.add(
            new CanDelete() {
                @Override
                public void delete(Collection coll) {
                    CollectionContainer.deleteCollection(coll);
                    tc.close();
                    tc = null;
                }
            }
        );
        
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

    @Override
    public int compareTo(CollectionImpl o) {
        return name.compareTo(o.getName());
    }

    @Override
    public Lookup getLookup() {
        return lu;
    }
    
    @Override
    public void setTopComponent(CollectionTopComponent tc) {
        this.tc = tc;
    }

    @Override
    public void clearEntitiesCollection() {
        entities = new EntitiesCollection("Collection");
    }
    
}