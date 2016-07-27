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
    
    private final static int INDENT = 10;
    private final static int UPNOTCH = 5;
    private final static int DOWNNOTCH = 15;
    
    private int[] intervals;
    
    public TimeLine() {}
    
    public void setArray(int[] intervals) {
        this.intervals = intervals;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (intervals != null) {
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
        int x, y;
        for(int i = 0; i < intervals.length; i++) {
            x = INDENT + ((lineLength / intervals.length) * i);
            y = vertical;
            g.drawLine(x, y - UPNOTCH, x, y + DOWNNOTCH);
            addLabel(x, y, intervals[i]);
        }
        g.drawLine(width - INDENT, vertical - UPNOTCH, width - INDENT, vertical + DOWNNOTCH);
        
    }
    
    /**
     * Adds labels to the scale.
     * 
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param year the label text.
     */
    private void addLabel(int x, int y, int year) {
        JLabel yearLabel = new JLabel();
        yearLabel.setLocation(x + 5, y + 5);
        yearLabel.setText(String.valueOf(year));
        this.add(yearLabel);
    }
    
}