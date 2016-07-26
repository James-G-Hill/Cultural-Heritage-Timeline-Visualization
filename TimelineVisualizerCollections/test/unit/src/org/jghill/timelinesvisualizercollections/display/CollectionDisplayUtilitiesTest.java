package org.jghill.timelinesvisualizercollections.display;

import java.util.Calendar;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
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
    
    @BeforeClass
    public static void setUpClass() {
        earliest = mock(Calendar.class);
        latest = mock(Calendar.class);
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
        int predicted = 1000;
        int result = CollectionDisplayUtilities.calculateInterval(earliest, latest);
        assertEquals(predicted, result);
    }
    
}