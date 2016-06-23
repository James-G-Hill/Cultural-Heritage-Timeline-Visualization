package org.jghill.timelinevisualizersourcesgui;

import org.jghill.timelinevisualizersources.Source;
import org.jghill.timelinevisualizersources.SourceCollection;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
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
    
    Source source1;
    Source source2;
    
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
        source1 = mock(Source.class);
        source2 = mock(Source.class);
    }
    
    @After
    public void tearDown() {
        //sources.deleteSource(source1);
        //sources.deleteSource(source2);
    }

    /**
     * Test of getRowCount method, of class SourceTableModel.
     */
    @Test
    public void testGetRowCount() {
        SourceTableModel table;
        SourceCollection sources;
        sources = SourceCollection.getInstance();
        sources.addSource(source1);
        sources.addSource(source2);
        table = new SourceTableModel(sources);
        
        int rowCount = table.getRowCount();
        assertTrue("Count is "+rowCount, rowCount == 2);
    }

    /**
     * Test of getColumnCount method, of class SourceTableModel.
     */
    @Test
    public void testGetColumnCount() {
        SourceTableModel table;
        SourceCollection sources;
        sources = SourceCollection.getInstance();
        table = new SourceTableModel(sources);
        
        int colCount = table.getColumnCount();
        assertTrue("Count is "+colCount, colCount == 2);
    }

    /**
     * Test of getValueAt method, of class SourceTableModel.
     */
    @Test
    public void testGetValueAt() {
        fail();
    }

    /**
     * Test of getColumnName method, of class SourceTableModel.
     */
    @Test
    public void testGetColumnName() {
        fail();
    }
    
}