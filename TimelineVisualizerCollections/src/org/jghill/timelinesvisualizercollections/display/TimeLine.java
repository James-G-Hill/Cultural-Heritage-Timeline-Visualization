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
    
    private void paintScale(Graphics g) {
        
        int height = getHeight();
        int width = getWidth();
        
        g.setColor(Color.BLACK);
        g.drawLine(INDENT, INDENT, width - INDENT, INDENT);
        
        int lineLength = width - (INDENT * 2);
        int x;
        for(int i = 0; i < intervals.length; i++) {
            x = INDENT + ((lineLength / intervals.length) * i);
            g.drawLine(x, 10 - UPNOTCH, x, 10 + DOWNNOTCH);
            addLabel(x, intervals[i]);
        }
        
    }
    
    private void addLabel(int x, int year) {
        JLabel yearLabel = new JLabel();
        yearLabel.setLocation(x + 5, x + 5);
        yearLabel.setText("Interval: " + String.valueOf(year));
        this.add(yearLabel);
    }
    
}