package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JViewport;
import org.apache.commons.lang3.text.WordUtils;
import org.jghill.timelinesvisualizercollections.gui.CollectionTopComponent;
import org.jghill.timelinevisualizerentities.ManMadeObject;

/**
 * Displays the timeline relevant to the selection.
 * 
 * @author JGHill
 */
public class TimeLine extends JLayeredPane {
    
    private final static int DIAMETER = 6;
    private final static int RADIUS = DIAMETER / 2;
    private final static int IMAGE_UPPER = 140;
    private final static int LINE_INDENT = 20;
    private final static int SCALE_INDENT = 40;
    private final static int UPNOTCH = 5;
    private final static int DOWNNOTCH = 15;
    
    private final static int DESCRIPTION_INDENT = 5;
    private final static int DESCRIPTION_LENGTH = 400;
    private final static int DESCRIPTION_HEIGHT = 15;
    
    private final String name;
    
    private int[] intervals;
    private final ManMadeObject[] objects;
    private final JLabel description = new JLabel();
    private JLabel[] labels;
    private EntityDisplay[] eDisplays;
    
    private final CollectionDisplayPanel cdp;
    
    private int vertical;
    private int lineLength;
    private int scaleLength;
    
    private final Color color;
    
    /**
     * Constructor for the TimeLine.
     * 
     * @param name to appear on the TimeLine.
     * @param objects to represent on the TimeLine.
     * @param color of the TimeLine background.
     */
    public TimeLine(
            String name,
            ManMadeObject[] objects,
            Color color,
            CollectionDisplayPanel cdp
    ) {
        this.name = name;
        this.objects = objects;
        this.color = color;
        this.cdp = cdp;
        setUp();
    }
    
    /**
     * Sets the arrays used to create this TimeLine.
     */
    private void setUp() {
        
        this.setLayout(null);
        this.setOpaque(true);
        this.setBackground(color);
        this.intervals = cdp.getDateArray();
        
        this.add(description);
        description.setVisible(true);
        description.setText(WordUtils.capitalize(name));
        
        labels = new JLabel[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            labels[i] = new JLabel();
            this.add(labels[i]);
        }
        
        eDisplays = new EntityDisplay[objects.length];
        for(int i = 0; i < eDisplays.length; i++) {
            eDisplays[i] = new EntityDisplay();
            eDisplays[i].setEntity(objects[i]);
            eDisplays[i].addFocusListener(
                    (CollectionTopComponent) cdp.getParent().getParent().getParent().getParent().getParent());
        }
        
        Arrays.sort(eDisplays);
        for (int i = 0; i < eDisplays.length; i++) {
            if (eDisplays[i].getYear() != null) {
                this.add(eDisplays[i]);
                setComponentZOrder(eDisplays[i], i);
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
        lineLength = width - (LINE_INDENT * 2);
        scaleLength = lineLength - (SCALE_INDENT * 2);
        
        paintDescription();
        paintScale(g);
        paintEntities(g);
        this.repaint();
    }
    
    /**
     * Places the description onto the TimeLine.
     */
    private void paintDescription() {
        JViewport viewPort  = (JViewport) cdp.getParent();
        description.setBounds(
                viewPort.getViewPosition().x + DESCRIPTION_INDENT,
                DESCRIPTION_INDENT,
                DESCRIPTION_LENGTH,
                DESCRIPTION_HEIGHT
        );
    }
    
    /**
     * Adds labels to the scale.
     * 
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param year the label text.
     * @param label the label to position.
     */
    private void positionLabel(
            int x,
            int y,
            int year,
            JLabel label
    ) {
        label.setBounds(
                x + 5,
                y + 5,
                50,
                15
        );
        label.setText(String.valueOf(year));
    }
    
    /**
     * Adds an EntityDisplay to the TimeLine.
     * 
     * @param x horizontal coordinate.
     * @param y vertical coordinate.
     * @param ed the EntityDisplay.
     */
    private void positionDisplay(
            int x,
            int y,
            EntityDisplay ed
    ) {
        int w = ed.getWidth();
        int h = ed.getHeight();
        ed.setBounds(
                x - (w / 2),
                y,
                w,
                h
        );
    }
    
    /**
     * Paints the scale onto the TimeLine.
     * 
     * @param g the Graphics component.
     */
    private void paintScale(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(LINE_INDENT, vertical, LINE_INDENT + lineLength, vertical);
        int x, y;
        y = vertical;
        for(int i = 0; i < intervals.length; i++) {
            x = LINE_INDENT + SCALE_INDENT + (int) (((double) scaleLength / (intervals.length - 1)) * i);
            g.drawLine(x, y - UPNOTCH, x, y + DOWNNOTCH);
            positionLabel(x, y, intervals[i], labels[i]);
        }
    }
    
    /**
     * Paints the entities onto the TimeLine.
     * 
     * @param g the Graphics component.
     */
    private void paintEntities(Graphics g) {
        
        Integer firstYear = cdp.returnStart();
        Integer lastYear = cdp.returnEnd();
        
        int timeSpan = lastYear - firstYear;
        double ratio = ((double) scaleLength / timeSpan);
        
        for (EntityDisplay eDisplay : eDisplays) {
            Integer thisYear = eDisplay.getYear();
            if (thisYear != null) {
                int timePosition = thisYear - firstYear;
                int x, y;
                x = LINE_INDENT + SCALE_INDENT + (int) (timePosition * ratio);
                y = vertical - IMAGE_UPPER;
                positionDisplay(x, y, eDisplay);
                g.setColor(Color.BLACK);
                g.drawLine(x, y + eDisplay.getHeight(), x, vertical);
                g.fillOval(x  - RADIUS, vertical - RADIUS, DIAMETER, DIAMETER);
            }
        }
        
    }
    
    /**
     * Return the name of this TimeLine.
     * 
     * @return the name.
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Returns the Entities displayed by this TimeLine.
     * 
     * @return the Entities.
     */
    public ManMadeObject[] getEntities() {
        return objects;
    }
    
}