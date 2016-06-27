package org.jghill.timelinevisualizersourcesgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Tools",
        id = "org.jghill.timelinevisualizersourcesgui.SourceManagementOpen"
)
@ActionRegistration(
        displayName = "#CTL_SourceManagementOpen"
)
@ActionReference(path = "Menu/Tools", position = 0)
@Messages("CTL_SourceManagementOpen=Source Management")
public final class SourceManagementOpen implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        SourceManagementTool s;
        s = new SourceManagementTool(new javax.swing.JFrame(), true);
        s.setVisible(true);
    }
}