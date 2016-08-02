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
    
    private final static int NUMBER_INTERVALS = 10;
    
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
            Integer year = e.getTimeSpan();
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
            Integer year = e.getTimeSpan();
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
     * Returns the start date for the scale.
     * 
     * @param earliest the earliest date.
     * @param latest the latest date.
     * @return the first year date for the scale.
     */
    public static Integer getStart(Calendar earliest, Calendar latest) {
        int earlyYear = earliest.get(Calendar.YEAR);
        int laterYear = latest.get(Calendar.YEAR);
        int difference = laterYear - earlyYear;
        return (int) ((int) earlyYear - (difference * 0.05));
    }
    
    /**
     * Returns the end date for the scale.
     * 
     * @param earliest
     * @param latest
     * @return the last year date for the scale.
     */
    public static Integer getEnd(Calendar earliest, Calendar latest) {
        int earlyYear = earliest.get(Calendar.YEAR);
        int laterYear = latest.get(Calendar.YEAR);
        int difference = laterYear - earlyYear;
        return (int) ((int) laterYear + (difference * 0.1));
    }
    
    /**
     * Calculates the intervals size.
     * 
     * @return the size of the interval.
     */
    public static int calculateInterval(int start, int end) {
        int difference = end - start;
        if (difference < 10) {
            return 1;
        } else {
            return (int) Math.ceil(difference / NUMBER_INTERVALS);
        }
    }
    
    /**
     * Calculates the number of intervals to display on the timeline.
     * 
     * @return the number of intervals.
     */
    public static int countIntervals(Calendar earliest, Calendar latest) {
        return NUMBER_INTERVALS;
    }
    
    /**
     * Returns an array of dates from the start date.
     * 
     * @param earliest the earliest Calendar date.
     * @param interval the size of the intervals.
     * @param intervalsCount the number of intervals.
     * @return an array of years.
     */
    public static int[] getArrayOfDates(int start, int interval, int intervalsCount) {
        int[] dates = new int[intervalsCount];
        if (interval == 0) {
            dates[0] = 0;
            return dates;
        } else {
            for(int i = 0; i < intervalsCount; i++) {
                dates[i] = start + (i * interval);
            }
            return dates;
        }
    }
    
}