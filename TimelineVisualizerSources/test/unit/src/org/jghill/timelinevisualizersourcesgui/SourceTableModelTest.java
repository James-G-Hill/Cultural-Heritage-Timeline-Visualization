package org.jghill.timelinevisualizersourcesgui;

import org.jghill.timelinevisualizersources.Source;
import org.jghill.timelinevisualizersources.SourceCollection;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 * A class for testing the SourceTableModel.
 * 
 * @author JGHill
 */
public class SourceTableModelTest {
    
    SourceTableModel table;
    SourceCollection sources;
    
    public SourceTableModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Source newSource = mock(Source.class);
        sources = new SourceCollection();
        sources.addSource(newSource);
        sources.addSource(newSource);
        table = new SourceTableModel(sources.getSourceCollectionSet());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRowCount method, of class SourceTableModel.
     */
    @Test
    public void testGetRowCount() {
        int rowCount = table.getRowCount();
        assertTrue(rowCount == 2);
    }

    /**
     * Test of getColumnCount method, of class SourceTableModel.
     */
    @Test
    public void testGetColumnCount() {

    }

    /**
     * Test of getValueAt method, of class SourceTableModel.
     */
    @Test
    public void testGetValueAt() {

    }

    /**
     * Test of getColumnName method, of class SourceTableModel.
     */
    @Test
    public void testGetColumnName() {

    }
    
}
