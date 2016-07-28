package org.jghill.timelinesvisualizercollections.display;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static java.lang.Math.min;
import javax.swing.JPanel;
import org.jghill.timelinevisualizerentities.Entities;
import org.jghill.timelinevisualizerentities.PhysicalThing;

/**
 * A component for displaying entities.
 * 
 * @author JGHill
 */
public class EntityDisplay extends JPanel {
    
    private static final int MAX_DIMENSION = 100;
    
    private final Entities entity;
    
    private BufferedImage fullSize;
    private int thumbWidth;
    private int thumbHeight;
    
    public EntityDisplay(Entities entity) {
        this.entity = entity;
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        getImage();
        paintBase(g);
        paintImage(g);
        paintConnection(g);
    }
    
    private void getImage() {
        PhysicalThing pt = (PhysicalThing) entity;
        fullSize = pt.getImage();
        
        int x = fullSize.getWidth();
        int y = fullSize.getHeight();
        double ratio = x / y;
        
        boolean xOversized = (x > MAX_DIMENSION);
        boolean yOversized = (y > MAX_DIMENSION);
        
        if(xOversized || yOversized) {
            thumbWidth = (int) min(MAX_DIMENSION, ratio * MAX_DIMENSION);
            thumbHeight = (int) min(MAX_DIMENSION, MAX_DIMENSION / ratio);
        }
        
    }
    
    private void paintBase(Graphics g) {
        this.setSize(WIDTH, HEIGHT);
    }
    
    private void paintImage(Graphics g) {
        
    }
    
    private void paintConnection(Graphics g) {
        
    }
    
}