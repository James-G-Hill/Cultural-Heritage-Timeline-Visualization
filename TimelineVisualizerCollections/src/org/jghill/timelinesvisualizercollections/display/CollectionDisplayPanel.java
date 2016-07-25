package org.jghill.timelinesvisualizercollections.display;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JPanel;
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
    private int interval;
    private int intervalsCount;
    
    public void setArray(ManMadeObject[] collection) {
        calculateEarliestLatest(collection);
        interval = calculateInterval();
        intervalsCount = countIntervals();
    }
    
    /**
     * 
     * @param collection 
     */
    private void calculateEarliestLatest(ManMadeObject[] collection) {
        
        Calendar temp;
        
        for(ManMadeObject e : collection) {
            try {
                int year = Integer.parseInt(e.getTimeBegin());
                temp = new GregorianCalendar(year, 1, 1);
                if (earliest == null && latest == null) {
                    earliest = temp;
                    latest = temp;
                } else {
                    if(earliest.after(temp)) {
                        earliest = temp;
                    }
                    if (latest.before(temp)) {
                        latest = temp;
                    }
                }
            } catch (Exception ex) {}
        }
        
    }
    
    /**
     * 
     * @return 
     */
    private int calculateInterval() {
       int difference = 
               latest.get(Calendar.YEAR) - earliest.get(Calendar.YEAR);
        return (int) Math.floor(difference/10) * 10;
    }
    
    /**
     * 
     * @return 
     */
    private int countIntervals() {
        int lower = (int) Math.floor(Math.abs(earliest.get(Calendar.YEAR)/interval));
        int higher = (int) Math.ceil(Math.abs(latest.get(Calendar.YEAR)/interval));
        return (higher - lower) / interval;
    }
    
}