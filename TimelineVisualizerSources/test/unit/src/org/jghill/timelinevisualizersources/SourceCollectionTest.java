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
        instance = new SourceCollection();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testDeleteSourceReturnsTrueWhenSourceFound() {
        Source newSource = mock(Source.class);
        instance.addSource(newSource);
        assertTrue(instance.deleteSource(newSource));
    }
    
}