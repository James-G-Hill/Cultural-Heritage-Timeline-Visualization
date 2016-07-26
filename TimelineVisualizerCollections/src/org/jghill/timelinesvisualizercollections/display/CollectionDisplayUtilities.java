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
    public static Calendar calculateEarliest(ManMadeObject[] collection) {
        Calendar earliest = null;
        Calendar temp;
        for(ManMadeObject e : collection) {
            try {
                int year = Integer.parseInt(e.getTimeBegin());
                temp = new GregorianCalendar(year, 1, 1);
                if (earliest == null) {
                    earliest = temp;
                } else if (earliest.after(temp)) {
                    earliest = temp;
                }
            } catch (Exception ex) {}
        }
        return earliest;
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
    public static int countIntervals(Calendar earliest, Calendar latest) {
        int interval = calculateInterval(earliest, latest);
        if (interval == 0) {
            return 1;
        } else {
            int lower = (int) Math.floor(Math.abs(earliest.get(Calendar.YEAR)/interval));
            int higher = (int) Math.ceil(Math.abs(latest.get(Calendar.YEAR)/interval));
            return (higher - lower) / interval;
        }
    }
    
    /**
     * Returns an array of dates from the start date.
     * 
     * @param earliest the earliest Calendar date.
     * @param interval the size of the intervals.
     * @param intervalsCount the number of intervals.
     * @return an array of years.
     */
    public static int[] getArrayOfDates(Calendar earliest, int interval, int intervalsCount) {
        int[] dates = new int[intervalsCount];
        if (interval == 0) {
            dates[0] = 0;
            return dates;
        } else {
            int startYear = (int) Math.floor(Math.abs(earliest.get(Calendar.YEAR)/interval)) * interval;
            for(int i = 0; i < intervalsCount; i++) {
                dates[i] = startYear + (i * interval);
            }
            return dates;
        }
    }
    
}