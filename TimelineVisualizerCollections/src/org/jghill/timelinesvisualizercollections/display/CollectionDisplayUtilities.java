package org.jghill.timelinesvisualizercollections.display;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.jghill.timelinevisualizerentities.ManMadeObject;

/**
 * A collection of utilities for use by the collection display classes.
 * 
 * @author JGHill
 */
public final class CollectionDisplayUtilities {
    
    private CollectionDisplayUtilities() {}
    
    /**
     * Calculate the earliest and latest dates to display on the timeline.
     * 
     * @param collection the collection of objects to calculate from.
     */
    public static Calendar calculateEarliest(ManMadeObject[] collection, Calendar earliest) {
        Calendar temp = earliest;
        for(ManMadeObject e : collection) {
            try {
                int year = Integer.parseInt(e.getTimeBegin());
                temp = new GregorianCalendar(year, 1, 1);
                if(earliest.after(temp)) {
                    return temp;
                }
            } catch (Exception ex) {}
        }
        return temp;
    }
    
    /**
     * Calculate the earliest and latest dates to display on the timeline.
     * 
     * @param collection the collection of objects to calculate from.
     */
    public static Calendar calculateLatest(ManMadeObject[] collection, Calendar latest) {
        Calendar temp = latest;
        for(ManMadeObject e : collection) {
            try {
                int year = Integer.parseInt(e.getTimeBegin());
                temp = new GregorianCalendar(year, 1, 1);
                if (latest.before(temp)) {
                    return temp;
                }
            } catch (Exception ex) {}
        }
        return temp;
    }
    
    /**
     * Calculates the intervals size.
     * 
     * @return the size of the interval.
     */
    public static int calculateInterval(Calendar earliest, Calendar latest) {
       int difference = 
               latest.get(Calendar.YEAR) - earliest.get(Calendar.YEAR);
        return (int) Math.floor(difference / 10);
    }
    
    /**
     * Calculates the number of intervals to display on the timeline.
     * 
     * @return the number of intervals.
     */
    public static int countIntervals(Calendar earliest, Calendar latest, int interval) {
        int lower = (int) Math.floor(Math.abs(earliest.get(Calendar.YEAR)/interval));
        int higher = (int) Math.ceil(Math.abs(latest.get(Calendar.YEAR)/interval));
        return (higher - lower) / interval;
    }
    
    /**
     * Returns an array of dates between dates.
     * 
     * @param earliest the earliest Calendar date.
     * @param interval the size of the intervals.
     * @param intervalsCount the number of intervals.
     * @return an array of years.
     */
    public static int[] getArrayOfDates(Calendar earliest, int interval, int intervalsCount) {
        int[] dates = new int[intervalsCount];
        for(int i = 0; i < intervalsCount; i++) {
            dates[i] = earliest.get(Calendar.YEAR) + (i * interval);
        }
        return dates;
    }
    
}