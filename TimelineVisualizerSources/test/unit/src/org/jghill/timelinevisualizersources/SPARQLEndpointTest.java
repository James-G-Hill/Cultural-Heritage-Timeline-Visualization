package org.jghill.timelinevisualizersources;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing class for the SPARQL Endpoint class.
 * 
 * @author JGHill
 */
public class SPARQLEndpointTest {
    
    public SPARQLEndpointTest() {
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
    
    @Test
    public void testCompareToEquals() {
        SPARQLEndpoint sparql1 = new SPARQLEndpoint("British Museum");
        SPARQLEndpoint sparql2 = new SPARQLEndpoint("British Museum");
        int expected = 0;
        assertEquals(sparql1.compareTo(sparql2), expected);
    }
    
    @Test
    public void testCompareToLessThan() {
        SPARQLEndpoint sparql1 = new SPARQLEndpoint("British Museum");
        SPARQLEndpoint sparql2 = new SPARQLEndpoint("Victoria and Albert");
        int expected = 0;
        assertTrue(sparql1.compareTo(sparql2) < expected);
    }
    
    @Test
    public void testCompareToGreaterThan() {
        SPARQLEndpoint sparql1 = new SPARQLEndpoint("Victoria and Albert");
        SPARQLEndpoint sparql2 = new SPARQLEndpoint("British Museum");
        int expected = 0;
        assertTrue(sparql1.compareTo(sparql2) > expected);
    }
    
}