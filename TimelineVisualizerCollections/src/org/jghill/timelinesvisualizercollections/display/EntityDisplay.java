package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jghill.timelinevisualizerentities.Entities;
import org.jghill.timelinevisualizerentities.PhysicalThing;

/**
 * A component for displaying entities.
 * 
 * @author JGHill
 */
public class EntityDisplay extends JPanel {
    
    private static final int BOUNDARY = 5;
    
    private Entities entity;
    
    private BufferedImage fullSize;
    private BufferedImage thumb;
    
    private int w = 110;
    private int h = 110;
    
    public EntityDisplay() {}
    
    public void setEntity(Entities entity) {
        this.entity = entity;
        setUpDisplay();
    }
    
    private void setUpDisplay() {
        this.setLayout(new FlowLayout());
        this.setOpaque(true);
        this.setBackground(Color.LIGHT_GRAY);
        getImage();
        if (thumb != null) {
            w = thumb.getWidth() + (BOUNDARY * 2);
            h = thumb.getHeight() + (BOUNDARY * 2);
            this.setSize(w, h);
            JLabel picLabel = new JLabel(new ImageIcon(thumb));
            this.add(picLabel);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
    /**
     * Requests the image from the entity that this display represents &
     * calculates dimensions.
     */
    private void getImage() {
        PhysicalThing pt = (PhysicalThing) entity;
        fullSize = pt.getImage();
        thumb = pt.getThumb();
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
        return w;
    }
    
    @Override
    public int getHeight() {
        return h;
    }
    
}