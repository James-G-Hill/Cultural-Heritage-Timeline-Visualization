package org.jghill.timelinesvisualizerviewer;

import java.util.ArrayList;
import org.jghill.timelinesvisualizercollections.Collection;
import org.openide.nodes.Index;
import org.openide.nodes.Node;

/**
 * An index system for managing the Collection nodes.
 * 
 * @author JGHill
 */
public class CollectionChildren extends Index.ArrayChildren {
    
    private final ArrayList<Node> coll;
    
    public CollectionChildren() {
        this.coll = new ArrayList<>();
    }
    
    /**
     * Add a collection into the ArrayList.
     * 
     * @param c a collection to be added.
     */
    public void addCollection(Collection c) {
        coll.add(new CollectionNode(c));
    }
    
    @Override
    protected java.util.List<Node> initCollection() {
        return coll;
    }
    
}