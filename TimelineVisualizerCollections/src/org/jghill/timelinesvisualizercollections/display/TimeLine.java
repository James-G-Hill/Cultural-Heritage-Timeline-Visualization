package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Displays the timeline relevant to the selection.
 * 
 * @author JGHill
 */
public class TimeLine extends JPanel {
    
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
        g.drawLine(10, 10, width - 10, 10);
        
        int lineLength = width - 20;
        int x;
        for(int i = 0; i < intervals.length; i++) {
            x = 10 + ((lineLength / intervals.length) * i);
            g.drawLine(x, x - 5, x, x + 15);
        }
        
    }
    
}