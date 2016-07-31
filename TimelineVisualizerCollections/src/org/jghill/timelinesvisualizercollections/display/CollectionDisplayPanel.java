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
    
    private Calendar earliest;
    private Calendar latest;
    
    private int start;
    private int end;
    
    private int interval;
    private int intervalsCount;
    
    public void setArray(ManMadeObject[] collection, TimeLine tm) {
        earliest = calculateEarliest(collection);
        latest = calculateLatest(collection);
        start = getStart(earliest, latest);
        end = getEnd(earliest, latest);
        interval = calculateInterval(start, end);
        intervalsCount = countIntervals(earliest, latest);
        int[] dateArray = getArrayOfDates(start, interval, intervalsCount);
        tm.setArray(dateArray, collection);
    }
    
}