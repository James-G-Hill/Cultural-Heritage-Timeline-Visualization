package org.jghill.timelinesvisualizercollectionsgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.jghill.timelinesvisualizercollectionscontainer.CollectionContainer;
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
        CollectionTopComponent collTC = new CollectionTopComponent();
        collTC.open();
        collTC.getCollection().setTopComponent(collTC);
        CollectionContainer container = CollectionContainer.getInstance();
        container.addCollection(collTC.getCollection());
        output(collTC.getCollection().getName());
    }
    
    private void output(String name) {
        InputOutput io = IOProvider.getDefault().getIO("Any", false);
        io.getOut().println("Collection " + name + " has been created");
        io.close();
    }
    
}