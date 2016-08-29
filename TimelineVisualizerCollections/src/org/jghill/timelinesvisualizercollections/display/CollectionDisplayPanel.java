package org.jghill.timelinesvisualizercollections.display;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import javax.swing.JSlider;
import javax.swing.JViewport;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A Panel for displaying the results.
 * 
 * @author JGHill
 */
public class CollectionDisplayPanel extends JPanel implements ChangeListener {
    
    private final static int MAX_SIZE = 10000;
    private final static int TIMELINE_HEIGHT = 200;
    
    private boolean level1 = false;
    private boolean level2 = true;
    private boolean level3 = true;
    private boolean update = true;
    
    private int size;
    
    private JSlider zoom;
    
    private ManMadeObject[] collection;
    private TimeLine[] timeLines;
    private int[] dateArray;
    
    private int dateDifference;
    
    private ScaleBuilder scaleBuilder;
    
    private JViewport viewer;
    
    /**
     * The constructor.
     */
    public CollectionDisplayPanel() {
        setUp();
    }
    
    /**
     * Sets the initial settings when constructed.
     */
    private void setUp() {
        setLayout(null);
        scaleBuilder = new ScaleBuilder();
    }
    
    /**
     * Sets the slider for this object.
     * 
     * @param zoom the slider.
     */
    public void setSlider(JSlider zoom) {
        this.zoom = zoom;
        this.zoom.addChangeListener(this);
    }
    
    /**
     * Sets the Collection that this panel will display.
     * 
     * @param timeLinesCollection that will be displayed.
     * @param filter the string to filter by.
     */
    public void setArray(TimeLineCollection timeLinesCollection) {
        clear();
        this.collection = timeLinesCollection.getAllTimeLineObjects();
        this.timeLines = timeLinesCollection.getTimeLines();
        viewer = (JViewport) this.getParent();
        dateArray = scaleBuilder.createScaleInfo(collection, 1);
        dateDifference = dateArray[dateArray.length-1] - dateArray[0];
        for (TimeLine tm : timeLines) {
            this.add(tm);
        }
        revalidate();
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (timeLines != null) {
            if (size < viewer.getSize().width) {
                size = viewer.getSize().width;
            }
            modifyScaleZoom();
            paintTimeLines();
            changeSize();
        }
        revalidate();
    }
    
    /**
     * Places the TimeLines onto the panel.
     */
    protected void paintTimeLines() {
        int tlCount = 0;
        for (TimeLine tm : timeLines) {
            tm.setBounds(
                    0,
                    TIMELINE_HEIGHT * tlCount,
                    size,
                    TIMELINE_HEIGHT
            );
            tlCount++;
        }
        update = true;
    }
    
    /**
     * Check the zoom level and modify the scale if necessary.
     */
    private void modifyScaleZoom() {
        int scale = size / viewer.getSize().width;
        if (scale <= 4 && !level1) {
            level1 = true;
            level2 = false;
            level3 = false;
            update = true;
            dateArray = scaleBuilder.createScaleInfo(collection, 1);
        } else if (scale > 4 && scale <= 40 && !level2) {
            level1 = false;
            level2 = true;
            level3 = false;
            update = true;
            dateArray = scaleBuilder.createScaleInfo(collection, 10);
        } else if (scale > 40 && !level3) {
            level1 = false;
            level2 = false;
            level3 = true;
            update = true;
            dateArray = scaleBuilder.createScaleInfo(collection, 100);
        } else {
            update = false;
        }
    }
    
    /**
     * Returns the status of the 'update' variable.
     * 
     * @return the update variable.
     */
    public boolean getUpdate() {
        return update;
    }
  
    /**
     * Returns the array of dates associated with this display.
     * 
     * @return the dateArray.
     */
    public int[] getDateArray() {
        return dateArray;
    }
    
    /**
     * Clears this panel.
     */
    public void clear() {
        collection = null;
        dateArray = null;
        removeAll();
        timeLines = null;
        revalidate();
        repaint();
    }
    
    /**
     * Update the scaleZoom level when reacting to the slider changing.
     * 
     * @param e the event that's changed.
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        
        JSlider source = (JSlider) e.getSource();
        
        if (source.getValueIsAdjusting() && timeLines != null) {
            
            int interval = (getDateArray()[getDateArray().length-1] - getDateArray()[0]);
            int viewerWidth = viewer.getSize().width;
            int scaleZoom = (int) ((int) viewerWidth + (source.getValue() * (viewerWidth * ((double) interval / 100))));
            
            if (scaleZoom >= viewerWidth && scaleZoom <= MAX_SIZE + viewerWidth && dateDifference > 10) {
                
                int position = viewer.getViewPosition().x;
                int halfWidth = viewerWidth / 2;
                int oldCentre = position + halfWidth;
                double ratio = (double) scaleZoom / size;
                int newX = Math.max(0, (int) (Math.round(oldCentre * ratio) - halfWidth));
                size = scaleZoom;
                changeSize();
                
                viewer.setViewPosition(
                        new Point(
                                newX,
                                viewer.getViewPosition().y
                        )
                );
                
                repaint();
                
            }
            
        }
        
    }
    
    /**
     * Changes the size of this panel.
     */
    private void changeSize() {
        this.setPreferredSize(
                new Dimension(
                        size,
                        timeLines.length * TIMELINE_HEIGHT
                )
        );
    }
    
}