package org.jghill.timelinevisualizerviewergui;

import org.jghill.timelinesvisualizercollections.container.CollectionContainer;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.nodes.AbstractNode;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Viewer for the manipulation of Collections.
 */
@ConvertAsProperties(
        dtd = "-//org.jghill.timelinesvisualizercollectionsgui//CollectionViewer//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "ViewerTopComponent",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "org.jghill.timelinesvisualizercollectionsgui.ViewerTopComponent")
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_CollectionViewerAction",
        preferredID = "ViewerTopComponent"
)
@Messages({
    "CTL_CollectionViewerAction=Viewer",
    "CTL_CollectionViewerTopComponent=Viewer",
    "HINT_CollectionViewerTopComponent=This is a Viewer"
})
public final class ViewerTopComponent extends TopComponent implements ExplorerManager.Provider {
    
    private final ExplorerManager manager = new ExplorerManager();
    
    public ViewerTopComponent() {
        
        initComponents();
        setName(Bundle.CTL_CollectionViewerTopComponent());
        setToolTipText(Bundle.HINT_CollectionViewerTopComponent());
        
        putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);
        
        associateLookup(ExplorerUtils.createLookup(manager, getActionMap()));
        manager.setRootContext(new AbstractNode(CollectionContainer.getChildren()));
        manager.getRootContext().setDisplayName("Collections");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewerScrollPane = new BeanTreeView();

        setPreferredSize(new java.awt.Dimension(200, 500));

        ViewerScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ViewerScrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ViewerScrollPane.setHorizontalScrollBar(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ViewerScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ViewerScrollPane;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void componentOpened() {}

    @Override
    public void componentClosed() {}

    @Override
    protected void componentActivated() {
        ExplorerUtils.activateActions(manager, true);
    }
    
    @Override
    protected void componentDeactivated() {
        ExplorerUtils.activateActions(manager, false);
    }
    
    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    public ExplorerManager getExplorerManager() {
        return manager;
    }
    
}