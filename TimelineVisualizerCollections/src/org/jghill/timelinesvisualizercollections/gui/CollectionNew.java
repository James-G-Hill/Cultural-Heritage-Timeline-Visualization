package org.jghill.timelinesvisualizercollections.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import org.jghill.timelinesvisualizercollections.Collection;
import org.jghill.timelinesvisualizercollections.CollectionImpl;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.jghill.timelinesvisualizercollections.container.CollectionContainer;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.jghill.timelinevisualizerqueriescollection.QueriesCollection;
import org.netbeans.api.io.IOProvider;
import org.netbeans.api.io.InputOutput;

@ActionID(
        category = "File",
        id = "org.jghill.timelinesvisualizercollectionsgui.CollectionNew"
)
@ActionRegistration(
        displayName = "#CTL_CollectionNew"
)
@ActionReference(path = "Menu/File", position = 1300)
@Messages("CTL_CollectionNew=New Collection")
public final class CollectionNew implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Collection collection = new CollectionImpl(
                    "New " + LocalDateTime.now(), 
                    new EntitiesCollection("Collection"), 
                    new QueriesCollection());
        CollectionContainer.addCollection(collection);
        CollectionContainer.addToLookup(collection);
        CollectionTopComponent collTC = new CollectionTopComponent();
        collTC.open();
        collTC.getCollection().setTopComponent(collTC);
        output(collTC.getCollection().getName());
    }
    
    /**
     * Outputs an explanation of the action.
     * @param name the name of the Collection that was created.
     */
    private void output(String name) {
        InputOutput io = IOProvider.getDefault().getIO("Main", false);
        io.getOut().println("Collection " + name + " has been created");
    }
    
}