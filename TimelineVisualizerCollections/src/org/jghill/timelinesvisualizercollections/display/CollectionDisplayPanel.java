package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import static org.jghill.timelinesvisualizercollections.display.CollectionDisplayUtilities.*;
import org.jghill.timelinevisualizerentities.ManMadeObject;

/**
 * A Panel for displaying the results.
 * @author JGHill
 */
public class CollectionDisplayPanel extends JPanel {
    
    private ManMadeObject[] collection;
    private TimeLine[] timelines;
    private int[] dateArray;
    
    private Calendar earliest;
    private Calendar latest;
    
    private Calendar start;
    private Calendar end;
    
    private int interval;
    private int intervalsCount;
    
    public CollectionDisplayPanel() {
        setUp();
    }
    
    public void setArray(ManMadeObject[] collection) {
        clear();
        this.collection = collection;
        calculateTimePeriod();
        createTimeLines();
        revalidate();
        repaint();
    }
    
    /**
     * Calculates the time period for this collection display panel.
     */
    private void calculateTimePeriod() {
        earliest = calculateEarliest(collection);
        latest = calculateLatest(collection);
        interval = calculateInterval(earliest, latest);
        start = getStart(earliest, interval);
        end = getEnd(latest, interval);
        intervalsCount = countIntervals(start, end, interval);
        dateArray = getArrayOfDates(start, interval, intervalsCount);
    }
    
    /**
     * Creates all timelines for this collection display panel.
     */
    private void createTimeLines() {
        TimeLine tm = new TimeLine(this, Color.pink);
        timelines = new TimeLine[1];
        timelines[0] = tm;
        this.add(tm);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintTimeLines();
    }
    
    /**
     * Places the TimeLines onto the panel.
     */
    protected void paintTimeLines() {
        if (timelines != null) {
            for(TimeLine tm : timelines) {
                tm.setBounds(10, 10, this.getWidth() - 20, this.getHeight() - 20);
            }
        }
    }
    
    /**
     * Sets the layout.
     */
    private void setUp() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
    
    /**
     * @return the dateArray.
     */
    public int[] getDateArray() {
        return dateArray;
    }
    
    /**
     * @return the collection.
     */
    public ManMadeObject[] getCollection() {
        return collection;
    }
    
    /**
     * @return start.
     */
    public Integer returnStart() {
        if (start != null) {
            return start.get(Calendar.YEAR);
        } else {
            return null;
        }
    }
    
    /**
     * @return end.
     */
    public Integer returnEnd() {
        if (end != null) {
            return end.get(Calendar.YEAR);
        } else {
            return null;
        }
    }
    
    /**
     * Clears this panel.
     */
    public void clear() {
        this.collection = null;
        this.dateArray = null;
        this.removeAll();
        timelines = null;
        revalidate();
        repaint();
    }
    
}