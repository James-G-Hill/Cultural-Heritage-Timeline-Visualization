package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.util.Calendar;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import static org.jghill.timelinesvisualizercollections.display.CollectionDisplayUtilities.*;
import org.jghill.timelinevisualizerentities.ManMadeObject;

/**
 * A Panel for displaying the results.
 * 
 * @author JGHill
 */
public class CollectionDisplayPanel extends JPanel {
    
    private ManMadeObject[] collection;
    private TimeLine[] timelines;
    private int[] dateArray;
    
    private Calendar earliest;
    private Calendar latest;
    
    private Integer start;
    private Integer end;
    
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
        start = getStart(earliest, latest);
        end = getEnd(earliest, latest);
        interval = calculateInterval(start, end);
        intervalsCount = countIntervals(earliest, latest);
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
        tm.setBounds(10, 10, this.getWidth() - 20, this.getHeight() - 20);
    }
    
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
            return start;
        } else {
            return null;
        }
    }
    
    /**
     * @return end.
     */
    public Integer returnEnd() {
        if (end != null) {
            return end;
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