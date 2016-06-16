package org.jghill.timelinevisualizersources;

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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addSource method, of class SourceCollection.
     */
    @Test
    public void testAddSource() {
        System.out.println("addSource");
        Source newSource = null;
        SourceCollection instance = new SourceCollection();
        instance.addSource(newSource);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
