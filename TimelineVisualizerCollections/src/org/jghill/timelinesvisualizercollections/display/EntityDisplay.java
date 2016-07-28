package org.jghill.timelinesvisualizercollections.display;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.jghill.timelinevisualizerentities.Entities;

/**
 * A component for displaying entities.
 * 
 * @author JGHill
 */
public class EntityDisplay extends JPanel {
    
    Entities entity;
    BufferedImage fullSize;
    BufferedImage reSize;
    
    public EntityDisplay(Entities entity) {
        this.entity = entity;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintBase(g);
        paintPhoto(g);
        paintConnection(g);
    }
    
    private void paintBase(Graphics g) {
        
    }
    
    private void paintPhoto(Graphics g) {
        
    }
    
    private void paintConnection(Graphics g) {
        
    }
    
}