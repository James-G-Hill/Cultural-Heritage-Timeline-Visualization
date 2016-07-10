package org.jghill.timelinesvisualizercollectionsnode;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.jghill.timelinesvisualizercollections.CanOpen;
import org.jghill.timelinesvisualizercollections.Collection;
import org.openide.util.Lookup;

/**
 * Opens a Collection.
 * 
 * @author JGHill
 */
public class ViewerOpenAction extends AbstractAction {

    private final Collection coll;
    
    public ViewerOpenAction(Lookup lu) {
        coll = lu.lookup(Collection.class);
        putValue(NAME, "Open");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(coll != null) {
            CanOpen opener = coll.getLookup().lookup(CanOpen.class);
            if(opener != null){
                opener.open(coll);
            }
        }
    }
    
}