package org.jghill.timelinevisualizersourcesgui;

import org.jghill.timelinevisualizersources.Source;
import org.jghill.timelinevisualizersources.SourceCollection;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
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
    
    public SourceTableModelTest() {}
    
    @Before
    public void setUp() {
        source1 = mock(Source.class);
        source2 = mock(Source.class);
    }
    
    @Test
    public void testGetRowCountReturnsCorrectNumberOfRows() {
        SourceTableModel table;
        SourceCollection sources;
        sources = SourceCollection.getInstance();
        sources.addSource(source1);
        sources.addSource(source2);
        table = new SourceTableModel(sources);
        
        int rowCount = table.getRowCount();
        assertTrue("Count is "+rowCount, rowCount == 2);
    }
    
    @Test
    public void testGetColumnCountReturnsCorrectNumberOfColumns() {
        SourceTableModel table;
        SourceCollection sources;
        sources = SourceCollection.getInstance();
        table = new SourceTableModel(sources);
        
        int colCount = table.getColumnCount();
        assertTrue("Count is "+colCount, colCount == 2);
    }
    
    @Test
    public void testGetValueAt() {
        fail();
    }
    
    @Test
    public void testGetColumnName() {
        fail();
    }
    
}