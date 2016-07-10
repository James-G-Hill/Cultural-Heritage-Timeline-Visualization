package org.jghill.timelinesvisualizercollectionsnode;

import javax.swing.Action;
import org.jghill.timelinesvisualizercollections.Collection;
import org.openide.actions.DeleteAction;
import org.openide.nodes.AbstractNode;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.Lookups;

/**
 * A node for holding a Collection in the Viewer.
 * 
 * @author JGHill
 */
public class CollectionNode extends AbstractNode {
    
    public CollectionNode(Collection coll) {
        super(new CollectionChildren(), Lookups.singleton(coll));
        setDisplayName(coll.getName());
    }
    
    public CollectionNode() {
        super(new CollectionChildren());
        setDisplayName("Collections");
    }
    
    @Override
    public boolean canDestroy() {
        return true;
    }
    
    @Override
    public Action[] getActions(boolean popup) {
        return new Action[] {
            new ViewerOpenAction(),
            SystemAction.get(DeleteAction.class)
        };
    }
    
}