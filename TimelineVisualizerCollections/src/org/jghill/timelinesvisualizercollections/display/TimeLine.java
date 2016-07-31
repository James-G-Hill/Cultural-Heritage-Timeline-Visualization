package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jghill.timelinevisualizerentities.Entities;

/**
 * Displays the timeline relevant to the selection.
 * 
 * @author JGHill
 */
public class TimeLine extends JPanel {
    
    private final static int INDENT = 10;
    private final static int UPNOTCH = 5;
    private final static int DOWNNOTCH = 15;
    
    private int[] intervals;
    private JLabel[] labels;
    private EntityDisplay[] eDisplays;
    
    public TimeLine() {}
    
    public void setArray(int[] intervals, Entities[] entities) {
        this.setLayout(null);
        this.intervals = intervals;
        
        labels = new JLabel[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            labels[i] = new JLabel();
            this.add(labels[i]);
        }
        
        eDisplays = new EntityDisplay[entities.length];
        for(int i = 0; i < entities.length; i++) {
            eDisplays[i] = new EntityDisplay();
            eDisplays[i].setEntity(entities[i]);
            this.add(eDisplays[i]);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (intervals != null && intervals.length > 1) {
            paintScale(g);
        }
    }
    
    /**
     * Paints the scale onto the TimeLine.
     * 
     * @param g the Graphics object.
     */
    private void paintScale(Graphics g) {
        
        int height = getHeight();
        int width = getWidth();
        
        int vertical = height - 25;
        
        g.setColor(Color.BLACK);
        g.drawLine(INDENT, vertical, width - INDENT, vertical);
        
        int lineLength = width - (INDENT * 2);
        for(int i = 0; i < intervals.length; i++) {
            int x, y;
            x = INDENT + ((lineLength / intervals.length) * i);
            y = vertical;
            g.drawLine(x, y - UPNOTCH, x, y + DOWNNOTCH);
            positionLabel(x, y, intervals[i], labels[i]);
        }
        for (EntityDisplay eDisplay : eDisplays) {
            int x, y;
            int thisYear = eDisplay.getYear();
            int firstYear = intervals[0];
            int lastYear = intervals[intervals.length - 1];
            int timeSpan = lastYear - firstYear;
            int timePosition = thisYear - firstYear;
            int ratio = lineLength / timeSpan;
            if (ratio > 0) {
                x = INDENT + (timePosition * ratio);
                y = vertical - 110;
                positionDisplay(x, y, eDisplay);
            }
        }
        g.drawLine(width - INDENT, vertical - UPNOTCH, width - INDENT, vertical + DOWNNOTCH);
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
    
}