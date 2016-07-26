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
    
    private Calendar earliest = null;
    private Calendar latest = null;
    private int interval;
    private int intervalsCount;
    
    public void setArray(ManMadeObject[] collection, TimeLine tm) {
        earliest = calculateEarliest(collection, earliest);
        latest = calculateLatest(collection, latest);
        interval = calculateInterval(earliest, latest);
        intervalsCount = countIntervals(earliest, latest);
        int[] dateArray = getArrayOfDates(earliest, interval, intervalsCount);
        tm.setArray(dateArray);
    }
    
}