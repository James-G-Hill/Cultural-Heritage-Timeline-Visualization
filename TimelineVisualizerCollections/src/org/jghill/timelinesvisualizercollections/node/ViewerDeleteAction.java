package org.jghill.timelinesvisualizercollections.node;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.jghill.timelinesvisualizercollections.CanDelete;
import org.jghill.timelinesvisualizercollections.Collection;
import org.openide.util.Lookup;

/**
 * Deletes a Collection.
 * 
 * @author JGHill
 */
public class ViewerDeleteAction extends AbstractAction {
    
    private final Collection coll;
    private final String actionName = "Delete";
    
    /**
     * Constructor.
     * 
     * @param lu lookup for the object.
     */
    public ViewerDeleteAction(Lookup lu) {
        coll = lu.lookup(Collection.class);
        putValue(NAME, actionName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(coll != null) {
            CanDelete deleter = coll.getLookup().lookup(CanDelete.class);
            if(deleter != null){
                deleter.delete(coll);
            }
        }
    }

}