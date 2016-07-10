package org.jghill.timelinesvisualizercollectionsnode;

import javax.swing.Action;
import org.jghill.timelinesvisualizercollections.Collection;
import org.openide.actions.DeleteAction;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

/**
 * A node for holding a Collection in the Viewer.
 * 
 * @author JGHill
 */
public class CollectionNode extends AbstractNode {
    
    private Collection coll;
    private InstanceContent ic;
    
    public CollectionNode(Collection coll) {
        this(coll, new InstanceContent());
    }
    
    public CollectionNode(Collection coll, InstanceContent ic) {
        super(Children.LEAF, new AbstractLookup(ic));
        this.coll = coll;
        this.ic = ic;
        this.ic.add(coll);
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
            new ViewerOpenAction(getLookup()),
            SystemAction.get(DeleteAction.class)
        };
    }
    
}