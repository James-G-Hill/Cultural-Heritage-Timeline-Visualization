package org.jghill.timelinevisualizersources;

import org.openide.modules.ModuleInstall;

/**
 * An installer for setting up the Source Collection for use.
 * 
 * @author JGHill
 */
public class Installer extends ModuleInstall {

    SourceCollection sources;
    
    @Override
    public void restored() {
        sources = new SourceCollection();
    }

}