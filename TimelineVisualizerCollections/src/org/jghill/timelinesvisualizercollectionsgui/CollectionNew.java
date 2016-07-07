package org.jghill.timelinesvisualizercollectionsgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import org.jghill.timelinesvisualizercollections.CollectionImpl;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.jghill.timelinevisualizerqueriescollection.QueriesCollection;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.jghill.timelinesvisualizercollectionscontainer.CollectionContainer;
import org.jghill.timelinesvisualizercollections.Collection;

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
        EntitiesCollection entities = new EntitiesCollection();
        QueriesCollection queries = new QueriesCollection();
        Collection coll = new CollectionImpl("New " + LocalDateTime.now(), entities, queries);
        CollectionTopComponent collTC = new CollectionTopComponent();
        collTC.setCollection(coll);
        collTC.open();
        CollectionContainer container = CollectionContainer.getInstance();
        container.addCollection(coll);
    }
    
}