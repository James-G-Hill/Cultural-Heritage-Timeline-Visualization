package org.jghill.timelinesvisualizerviewer;

import javax.swing.Action;
import org.jghill.timelinesvisualizercollections.CollectionImpl;
import org.openide.actions.CopyAction;
import org.openide.actions.CutAction;
import org.openide.actions.DeleteAction;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.Lookups;

/**
 * A node for holding a Collection in the Viewer.
 * 
 * @author JGHill
 */
public class CollectionNode extends AbstractNode {
    
    private final CollectionImpl coll;
    
    public CollectionNode(CollectionImpl coll) {
        super(Children.LEAF, Lookups.fixed( new Object[] {coll} ));
        this.coll = coll;
        setDisplayName(coll.getName());
    }
    
    @Override
    public boolean canCut() {
        return true;
    }
    
    @Override
    public boolean canDestroy() {
        return true;
    }
    
    @Override
    public Action[] getActions(boolean popup) {
        return new Action[] {
            SystemAction.get( CopyAction.class),
            SystemAction.get( CutAction.class),
            null,
            SystemAction.get( DeleteAction.class)
        };
    }
    
}