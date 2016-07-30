package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.awt.FlowLayout;
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
    private static final int BOUNDARY = 5;
    
    private Entities entity;
    
    private BufferedImage fullSize;
    private int thumbWidth = MAX_DIMENSION;
    private int thumbHeight = MAX_DIMENSION;
    
    public EntityDisplay() {}
    
    public void setEntity(Entities entity) {
        this.entity = entity;
        setUpDisplay();
    }
    
    private void setUpDisplay() {
        this.setLayout(new FlowLayout());
        this.setOpaque(true);
        getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.LIGHT_GRAY);
        this.setSize(thumbWidth + (BOUNDARY * 2), thumbHeight + (BOUNDARY * 2));
        if (fullSize != null) {
            g.drawImage(fullSize, BOUNDARY, BOUNDARY, thumbWidth, thumbHeight, null);
        }
    }
    
    /**
     * Requests the image from the entity that this display represents &
     * calculates dimensions.
     */
    private void getImage() {
        PhysicalThing pt = (PhysicalThing) entity;
        fullSize = pt.getImage();
        if (fullSize != null) {
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
    }
    
    /**
     * @return the year from the entity that this display represents.
     */
    public int getYear() {
        PhysicalThing pt = (PhysicalThing) entity;
        return pt.getTimeBegin();
    }
    
    @Override
    public int getWidth() {
        return thumbWidth;
    }
    
    @Override
    public int getHeight() {
        return thumbHeight;
    }
}