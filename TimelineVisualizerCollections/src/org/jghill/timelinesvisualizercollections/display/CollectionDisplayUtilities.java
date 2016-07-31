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
            Integer year = e.getTimeBegin();
            if (year != null) {
                temp = new GregorianCalendar(year, 1, 1);
                if (earliest == null) {
                    earliest = temp;
                } else if (earliest.after(temp)) {
                    earliest = temp;
                }
            }
        }
        return earliest;
    }
    
    /**
     * Calculate the earliest and latest dates to display on the timeline.
     * 
     * @param collection the collection of objects to calculate from.
     */
    public static Calendar calculateLatest(ManMadeObject[] collection) {
        Calendar latest = null;
        Calendar temp;
        for(ManMadeObject e : collection) {
            Integer year = e.getTimeBegin();
            if (year != null) {
                temp = new GregorianCalendar(year, 1, 1);
                if (latest == null) {
                    latest = temp;
                } else if (latest.before(temp)) {
                    latest = temp;
                }
            }
        }
        return latest;
    }
    
    /**
     * Calculates the intervals size.
     * 
     * @return the size of the interval.
     */
    public static int calculateInterval(Calendar earliest, Calendar latest) {
        int difference = 
               latest.get(Calendar.YEAR) - earliest.get(Calendar.YEAR);
        return (int) Math.ceil(difference / 10);
    }
    
    /**
     * Calculates the number of intervals to display on the timeline.
     * 
     * @return the number of intervals.
     */
    public static int countIntervals(Calendar earliest, Calendar latest) {
        return 10;
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