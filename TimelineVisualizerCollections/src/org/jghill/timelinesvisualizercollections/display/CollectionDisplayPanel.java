package org.jghill.timelinesvisualizercollections.display;

import java.util.Calendar;
import javax.swing.JPanel;
import static org.jghill.timelinesvisualizercollections.display.CollectionDisplayUtilities.*;
import org.jghill.timelinevisualizerentities.ManMadeObject;

/**
 * A Panel for displaying the results.
 * 
 * @author JGHill
 */
public class CollectionDisplayPanel extends JPanel {
    
    public CollectionDisplayPanel() {}
    
    private ManMadeObject[] collection;
    private int[] dateArray;
    
    private Calendar earliest;
    private Calendar latest;
    
    private Integer start;
    private Integer end;
    
    private int interval;
    private int intervalsCount;
    
    public void setArray(ManMadeObject[] collection, TimeLine tm) {
        this.collection = collection;
        earliest = calculateEarliest(collection);
        latest = calculateLatest(collection);
        start = getStart(earliest, latest);
        end = getEnd(earliest, latest);
        interval = calculateInterval(start, end);
        intervalsCount = countIntervals(earliest, latest);
        dateArray = getArrayOfDates(start, interval, intervalsCount);
        tm.setArray(this);
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
    
}