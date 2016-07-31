package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jghill.timelinevisualizerentities.Entities;
import org.jghill.timelinevisualizerentities.PhysicalThing;
import org.openide.util.Exceptions;
import org.openide.util.Utilities;

/**
 * A component for displaying entities.
 * 
 * @author JGHill
 */
public class EntityDisplay extends JPanel implements Comparable<EntityDisplay> {
    
    private static final int BOUNDARY = 5;
    
    private Entities entity;
    
    private BufferedImage thumb;
    
    private int w = 110;
    private int h = 110;
    
    public EntityDisplay() {}
    
    /**
     * Adds an Entities object to this display.
     * 
     * @param entity the Entities object.
     */
    public void setEntity(Entities entity) {
        this.entity = entity;
        setUpDisplay();
    }
    
    /**
     * Initial setup of the EntityDisplay.
     */
    private void setUpDisplay() {
        this.setLayout(new FlowLayout());
        this.setOpaque(true);
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getImage();
        if (thumb != null) {
            w = thumb.getWidth() + (BOUNDARY * 2);
            h = thumb.getHeight() + (BOUNDARY * 2);
            JLabel picLabel = new JLabel(new ImageIcon(thumb));
            this.add(picLabel);
            PhysicalThing pt = (PhysicalThing) entity;
            try {
                this.setToolTipText(
                        "<html><img src=\"" +
                                Utilities.toURI(pt.getImageFile()).toURL() +
                                "\">"
                );
            } catch (MalformedURLException ex) {
                Exceptions.printStackTrace(ex);
            }
        } else {
            JLabel label = new JLabel(entity.getName());
            w = label.getPreferredSize().width + (BOUNDARY * 2);
            h = label.getPreferredSize().height + (BOUNDARY * 2);
            this.add(label);
        }
        this.setSize(w, h);
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
        thumb = pt.getThumb();
    }
    
    /**
     * @return the year from the entity that this display represents.
     */
    public Integer getYear() {
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

    @Override
    public int compareTo(EntityDisplay o) {
        if (this.getYear() == null || o.getYear() == null) {
            return 0;
        } else {
            return Integer.compare(this.getYear(), o.getYear());
        }
    }
    
}