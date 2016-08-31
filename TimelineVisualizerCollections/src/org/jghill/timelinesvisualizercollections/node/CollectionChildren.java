package org.jghill.timelinesvisualizercollections.node;

import org.jghill.timelinesvisualizercollections.Collection;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 * An index system for managing the Collection nodes.
 * 
 * @author JGHill
 */
public class CollectionChildren extends Children.Keys {
    
    /**
     * The Constructor.
     */
    public CollectionChildren() {}
    
    @Override
    protected Node[] createNodes(Object key) {
        Collection obj = (Collection) key;
        return new Node[] { new CollectionNode(obj) };
    }
    
    @Override
    protected void addNotify() {
        super.addNotify();
    }
    
    /**
     * Updates the keys for the nodes.
     * 
     * @param colls 
     */
    public void update(Collection[] colls) {
        setKeys(colls);
    }
    
}