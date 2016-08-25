package org.jghill.timelinesvisualizercollections.display;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.jghill.timelinevisualizerentities.ManMadeObject;

/**
 * Creates the dimensions for the scale that appears within the TimeLines.
 * 
 * @author JGHill
 */
public class ScaleBuilder {
    
    /**
     * Constructor.
     */
    public ScaleBuilder() {}
    
    /**
     * Creates the info needed for the TimeLine.
     * 
     * @param collection of objects to calculate from.
     * @return an array of dates for the scales.
     */
    public int[] createScaleInfo(ManMadeObject[] collection) {
        Calendar earliest = calculateEarliest(collection);
        Calendar latest = calculateLatest(collection);
        int interval = calculateInterval(
                earliest,
                latest
        );
        Calendar start = getStart(earliest, interval);
        Calendar end = getEnd(latest, interval);
        int intervalsCount = countIntervals(start, end, interval);
        return getArrayOfDates(start, interval, intervalsCount);
    }
    
    /**
     * Calculate the earliest date to display on the timeline.
     * 
     * @param collection the collection of objects to calculate from.
     */
    private Calendar calculateEarliest(ManMadeObject[] collection) {
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
     * Calculate the latest date to display on the TimeLine.
     * 
     * @param collection the collection of objects to calculate from.
     */
    private Calendar calculateLatest(ManMadeObject[] collection) {
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
    private Calendar getStart(
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
    private Calendar getEnd(
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
    private int calculateInterval(
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
     * Calculates the number of intervals to display on the TimeLine.
     * 
     * @return the number of intervals.
     */
    private int countIntervals(
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
    private int[] getArrayOfDates(
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