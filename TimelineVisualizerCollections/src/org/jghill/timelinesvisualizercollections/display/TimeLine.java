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
    private JLabel[] labels;
    
    public TimeLine() {}
    
    public void setArray(int[] intervals) {
        this.setLayout(null);
        this.intervals = intervals;
        labels = new JLabel[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            labels[i] = new JLabel();
            this.add(labels[i]);
        }
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
            addLabel(x, y, intervals[i], labels[i]);
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
    private void addLabel(int x, int y, int year, JLabel label) {
        label.setBounds(x + 5, y + 5, 50, 15);
        label.setText(String.valueOf(year));
    }
    
}