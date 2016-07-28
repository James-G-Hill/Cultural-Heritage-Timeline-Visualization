package org.jghill.timelinesvisualizercollections.display;

import java.util.Calendar;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * A testing class for the CollectionDisplayUtilities class.
 * 
 * @author JGHill
 */
public class CollectionDisplayUtilitiesTest {
    
    static Calendar earliest;
    static Calendar latest;
    
    static ManMadeObject[] mmo;
    
    @Before
    public void setUp() {
        
        earliest = mock(Calendar.class);
        latest = mock(Calendar.class);
        
        mmo = new ManMadeObject[3];
        ManMadeObject mmo1 = mock(ManMadeObject.class);
        ManMadeObject mmo2 = mock(ManMadeObject.class);
        ManMadeObject mmo3 = mock(ManMadeObject.class);
        mmo[0] = mmo1;
        mmo[1] = mmo2;
        mmo[2] = mmo3;
        
    }
    
    @Test
    public void testCalculateEarliest() {
        earliest = null;
        when(mmo[0].getTimeBegin()).thenReturn(1985);
        when(mmo[1].getTimeBegin()).thenReturn(1973);
        when(mmo[2].getTimeBegin()).thenReturn(1978);
        int predicted = 1973;
        Calendar result = CollectionDisplayUtilities.calculateEarliest(mmo);
        assertEquals(predicted, result.get(Calendar.YEAR));
    }
    
    @Test
    public void testCalculateLatest() {
        latest = null;
        when(mmo[0].getTimeBegin()).thenReturn(1985);
        when(mmo[1].getTimeBegin()).thenReturn(1973);
        when(mmo[2].getTimeBegin()).thenReturn(1978);
        int predicted = 1985;
        Calendar result = CollectionDisplayUtilities.calculateLatest(mmo);
        assertEquals(predicted, result.get(Calendar.YEAR));
    }
    
    @Test
    public void testCalculateEarliestWithNegative() {
        earliest = null;
        when(mmo[0].getTimeBegin()).thenReturn(-1);
        when(mmo[1].getTimeBegin()).thenReturn(1973);
        when(mmo[2].getTimeBegin()).thenReturn(1978);
        int predicted = 1973;
        Calendar result = CollectionDisplayUtilities.calculateEarliest(mmo);
        assertEquals(predicted, result.get(Calendar.YEAR));
    }
    
    @Test
    public void testCalculateLatestWithNegative() {
        latest = null;
        when(mmo[0].getTimeBegin()).thenReturn(1985);
        when(mmo[1].getTimeBegin()).thenReturn(-1);
        when(mmo[2].getTimeBegin()).thenReturn(1978);
        int predicted = 1985;
        Calendar result = CollectionDisplayUtilities.calculateLatest(mmo);
        assertEquals(predicted, result.get(Calendar.YEAR));
    }
    
    @Test
    public void testCalculateIntervalTen() {
        when(earliest.get(Calendar.YEAR)).thenReturn(1000);
        when(latest.get(Calendar.YEAR)).thenReturn(1010);
        int predicted = 1;
        int result = CollectionDisplayUtilities.calculateInterval(earliest, latest);
        assertEquals(predicted, result);
    }
    
    @Test
    public void testCalculateIntervalHundred() {
        when(earliest.get(Calendar.YEAR)).thenReturn(2000);
        when(latest.get(Calendar.YEAR)).thenReturn(2100);
        int predicted = 10;
        int result = CollectionDisplayUtilities.calculateInterval(earliest, latest);
        assertEquals(predicted, result);
    }
    
    @Test
    public void testCalculateIntervalThousand() {
        when(earliest.get(Calendar.YEAR)).thenReturn(1000);
        when(latest.get(Calendar.YEAR)).thenReturn(2000);
        int predicted = 100;
        int result = CollectionDisplayUtilities.calculateInterval(earliest, latest);
        assertEquals(predicted, result);
    }
    
    @Test
    public void testCalculateIntervalOverEra() {
        when(earliest.get(Calendar.YEAR)).thenReturn(-1000);
        when(latest.get(Calendar.YEAR)).thenReturn(1000);
        int predicted = 200;
        int result = CollectionDisplayUtilities.calculateInterval(earliest, latest);
        assertEquals(predicted, result);
    }
    
    @Test
    public void testCalculateIntervalNotMultipleTen() {
        when(earliest.get(Calendar.YEAR)).thenReturn(1000);
        when(latest.get(Calendar.YEAR)).thenReturn(1015);
        int predicted = 1;
        int result = CollectionDisplayUtilities.calculateInterval(earliest, latest);
        assertEquals(predicted, result);
    }
    
    @Test
    public void testCountIntervals() {
        when(earliest.get(Calendar.YEAR)).thenReturn(1000);
        when(latest.get(Calendar.YEAR)).thenReturn(1015);
        int predicted = 15;
        int result = CollectionDisplayUtilities.countIntervals(earliest, latest);
        assertEquals(predicted, result);
    }
    
    @Test
    public void testCountIntervalsWithZero() {
        when(earliest.get(Calendar.YEAR)).thenReturn(1000);
        when(latest.get(Calendar.YEAR)).thenReturn(1000);
        int predicted = 1;
        int result = CollectionDisplayUtilities.countIntervals(earliest, latest);
        assertEquals(predicted, result);
    }
    
    @Test
    public void testGetArrayOfDates() {
        when(earliest.get(Calendar.YEAR)).thenReturn(1995);
        int predicted1 = 1990;
        int predicted2 = 2000;
        int predicted3 = 2010;
        int[] result = CollectionDisplayUtilities.getArrayOfDates(earliest, 10, 3);
        assertEquals(predicted1, result[0]);
        assertEquals(predicted2, result[1]);
        assertEquals(predicted3, result[2]);
    }
    
}