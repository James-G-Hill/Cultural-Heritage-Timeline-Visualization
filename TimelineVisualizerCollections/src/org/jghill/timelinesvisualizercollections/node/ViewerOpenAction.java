package org.jghill.timelinesvisualizercollections.node;

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
    private final String actionName = "Open";
    
    /**
     * Constructor.
     * 
     * @param lu the Lookup.
     */
    public ViewerOpenAction(Lookup lu) {
        coll = lu.lookup(Collection.class);
        setup();
    }
    
    /**
     * Completes the construction.
     */
    private void setup() {
        putValue(NAME, actionName);
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