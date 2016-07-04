package org.jghill.timelinesvisualizerprojectsgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "org.jghill.timelinesvisualizerprojectsgui.ProjectNew"
)
@ActionRegistration(
        displayName = "#CTL_ProjectNew"
)
@ActionReference(path = "Menu/File", position = 1300)
@Messages("CTL_ProjectNew=New Project")
public final class ProjectNew implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ProjectTopComponent projTC = new ProjectTopComponent();
        projTC.open();
    }
}