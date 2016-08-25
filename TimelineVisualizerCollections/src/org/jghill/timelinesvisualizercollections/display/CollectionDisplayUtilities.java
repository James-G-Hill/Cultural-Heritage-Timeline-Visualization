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
     * Calculate the earliest date to display on the timeline.
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
     * Calculate the latest date to display on the timeline.
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
     * @param earliest date.
     * @param interval the interval.
     * @return the first year date for the scale.
     */
    public static Calendar getStart(
            Calendar earliest,
            int interval
    ) {
        int year = earliest.get(Calendar.YEAR);
        if (interval == 1) {
            return new GregorianCalendar(year - 1, 1, 1);
        } else {
            year = (int) (interval * (Math.floor((double) year / interval)));
            return new GregorianCalendar(year, 1, 1);
        }
    }
    
    /**
     * Returns the end date for the scale.
     * 
     * @param latest date.
     * @param interval the interval.
     * @return the last year date for the scale.
     */
    public static Calendar getEnd(
            Calendar latest,
            int interval
    ) {
        int year = latest.get(Calendar.YEAR);
        if (interval == 1) {
            return new GregorianCalendar(year + 1, 1, 1);
        } else {
            year = (int) (interval * (Math.ceil((double) year / interval)));
            return new GregorianCalendar(year, 1, 1);
        }
    }
    
    /**
     * Calculates the intervals size.
     * 
     * @return the size of the interval.
     */
    public static int calculateInterval(
            Calendar start,
            Calendar end
    ) {
        int difference = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
        if (difference < 10) {
            return 1;
        } else {
            return (int) Math.pow(10, Math.ceil(Math.log10(difference/10)));
        }
    }
    
    /**
     * Calculates the number of intervals to display on the timeline.
     * 
     * @return the number of intervals.
     */
    public static int countIntervals(
            Calendar earliest,
            Calendar latest,
            int interval
    ) {
        int difference = latest.get(Calendar.YEAR) - earliest.get(Calendar.YEAR);
        if (interval == 0) {
            return 10;
        } else {
            return (interval + difference) / interval;
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
    public static int[] getArrayOfDates(
            Calendar start,
            int interval,
            int intervalsCount
    ) {
        int[] dates = new int[intervalsCount];
        if (interval == 0) {
            dates[0] = 0;
            return dates;
        } else {
            for(int i = 0; i < intervalsCount; i++) {
                dates[i] = start.get(Calendar.YEAR) + (i * interval);
            }
            return dates;
        }
    }
    
}