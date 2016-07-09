package org.jghill.timelinesvisualizercollectionsnode;

import org.jghill.timelinesvisualizercollections.Collection;
import org.jghill.timelinesvisualizercollectionscontainer.CollectionContainer;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 * An index system for managing the Collection nodes.
 * 
 * @author JGHill
 */
public class CollectionChildren extends Children.Keys {
    
    private static final CollectionChildren CHILDREN = new CollectionChildren();
    
    private CollectionChildren() {}
    
    /**
     * Returns the single instance of this singleton pattern.
     * 
     * @return the single instance.
     */
    public static CollectionChildren getInstance() {
        return CHILDREN;
    }
    
    @Override
    protected Node[] createNodes(Object key) {
        Collection obj = (Collection) key;
        return new Node[] { new CollectionNode(obj) };
    }
    
    @Override
    protected void addNotify() {
        super.addNotify();
        CollectionContainer cont = CollectionContainer.getInstance();
        Collection[] objs = cont.collectionsToArray();
        setKeys(objs);
    }
    
    /**
     * Refreshes the model.
     */
    public void update() {
        addNotify();
    }
    
}