package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Displays the timeline relevant to the selection.
 * 
 * @author JGHill
 */
public class TimeLine extends JPanel {
    
    private final static int DIAMETER = 6;
    private final static int RADIUS = DIAMETER / 2;
    private final static int IMAGE_UPPER = 150;
    private final static int INDENT = 10;
    private final static int UPNOTCH = 5;
    private final static int DOWNNOTCH = 15;
    
    private int[] intervals;
    private JLabel[] labels;
    private EntityDisplay[] eDisplays;
    
    private CollectionDisplayPanel cdp;
    
    private int vertical;
    private int lineLength;
    
    public TimeLine() {}
    
    /**
     * Sets the arrays used to create this TimeLine.
     * 
     * @param intervals
     * @param entities 
     */
    public void setArray(CollectionDisplayPanel cdp) {
        this.setLayout(null);
        this.cdp = cdp;
        this.intervals = cdp.getDateArray();
        
        labels = new JLabel[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            labels[i] = new JLabel();
            this.add(labels[i]);
        }
        
        eDisplays = new EntityDisplay[cdp.getCollection().length];
        for(int i = 0; i < cdp.getCollection().length; i++) {
            eDisplays[i] = new EntityDisplay();
            eDisplays[i].setEntity(cdp.getCollection()[i]);
            if (eDisplays[i].getYear() != null) {
                this.add(eDisplays[i]);
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (intervals != null && intervals.length > 1) {
            paintTimeLine(g);
        }
    }
    
    /**
     * Paints the scale onto the TimeLine.
     * 
     * @param g the Graphics object.
     */
    private void paintTimeLine(Graphics g) {
        
        int height = getHeight();
        int width = getWidth();
        
        vertical = height - 25;
        lineLength = width - (INDENT * 2);
        
        paintScale(g);
        paintEntities(g);
        this.repaint();
    }
    
    /**
     * Adds labels to the scale.
     * 
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param year the label text.
     */
    private void positionLabel(int x, int y, int year, JLabel label) {
        label.setBounds(x + 5, y + 5, 50, 15);
        label.setText(String.valueOf(year));
    }
    
    /**
     * Adds an EntityDisplay to the TimeLine.
     * 
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param ed the EntityDisplay.
     */
    private void positionDisplay(int x, int y, EntityDisplay ed) {
        ed.setBounds(x, y, ed.getWidth(), ed.getHeight());
    }
    
    /**
     * Paints the scale onto the TimeLine.
     * 
     * @param g the Graphics component.
     */
    private void paintScale(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(INDENT, vertical, INDENT + lineLength, vertical);
        int x, y;
        y = vertical;
        for(int i = 0; i < intervals.length; i++) {
            x = INDENT + ((lineLength / intervals.length) * i);
            g.drawLine(x, y - UPNOTCH, x, y + DOWNNOTCH);
            positionLabel(x, y, intervals[i], labels[i]);
        }
        g.drawLine(INDENT + lineLength, y - UPNOTCH, INDENT + lineLength, y + DOWNNOTCH);
    }
    
    /**
     * Paints the entities onto the TimeLine.
     * 
     * @param g the Graphics component.
     */
    private void paintEntities(Graphics g) {
        
        Integer firstYear = cdp.returnStart();
        Integer lastYear = cdp.returnEnd();
        Integer timeSpan = lastYear - firstYear;
        double ratio = ((double) lineLength) / timeSpan;
        
        for (EntityDisplay eDisplay : eDisplays) {
            Integer thisYear = eDisplay.getYear();
            if (thisYear != null) {
                Integer timePosition = thisYear - firstYear;
                int x, y;
                x = INDENT + (int) (timePosition * ratio);
                y = vertical - IMAGE_UPPER;
                positionDisplay(x, y, eDisplay);
                g.setColor(Color.BLACK);
                g.drawLine(x, y + eDisplay.getHeight(), x, vertical);
                g.fillOval(x  - RADIUS, vertical - RADIUS, DIAMETER, DIAMETER);
            }
        }
        
    }
    
}