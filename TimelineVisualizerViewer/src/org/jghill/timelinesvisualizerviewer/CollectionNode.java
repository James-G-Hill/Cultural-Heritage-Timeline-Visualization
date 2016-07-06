package org.jghill.timelinesvisualizerviewer;

import org.jghill.timelinesvisualizercollections.Collection;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.lookup.Lookups;

/**
 * A node for holding a Collection in the Viewer.
 * 
 * @author JGHill
 */
public class CollectionNode extends AbstractNode {
    
    Collection coll;
    
    public CollectionNode(Collection coll) {
        super(Children.LEAF, Lookups.fixed( new Object[] {coll} ));
        this.coll = coll;
        setDisplayName(coll.getName());
    }
    
}