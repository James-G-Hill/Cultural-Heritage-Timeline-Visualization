package org.jghill.timelinevisualizersources;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A test class for the SourceCollection class.
 * 
 * @author JGHill
 */
public class SourceCollectionTest {
    
    static SourceCollection instance;
    static Source source1;
    static Source source2;
    
    public SourceCollectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = SourceCollection.getInstance();
        source1 = mock(Source.class);
        source2 = mock(Source.class);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testAddSourceReturnsTrueWhenSourceNotFound() {
        assertTrue(instance.addSource(source1));
    }
    
    @Test
    public void testAddSourceReturnsFalseWhenSourceFound() {
        instance.addSource(source1);
        assertFalse(instance.addSource(source1));
    }
    
    @Test
    public void testDeleteSourceReturnsTrueWhenSourceFound() {
        instance.addSource(source1);
        assertTrue(instance.deleteSource(source1));
    }
    
    @Test
    public void testDeleteSourceReturnsFalseWhenSourceNotFound() {
        assertFalse(instance.deleteSource(source1));
    }
    
    @Test
    public void testGetSizeReturnsCorrectNumberOfSources() {
        instance.addSource(source2);
        assertTrue(instance.getSize() == 2);
    }
    
}