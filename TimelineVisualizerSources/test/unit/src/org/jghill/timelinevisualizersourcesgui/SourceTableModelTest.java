package org.jghill.timelinevisualizersourcesgui;

import org.jghill.timelinevisualizersources.Source;
import org.jghill.timelinevisualizersources.SourceCollection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * A class for testing the SourceTableModel.
 * 
 * @author JGHill
 */
public class SourceTableModelTest {
    
    Source source1;
    Source source2;
    
    String museum = "British Museum";
    
    public SourceTableModelTest() {}
    
    @Before
    public void setUp() {
        source1 = mock(Source.class);
        when(source1.getSourceName()).thenReturn(museum);
        when(source1.getSourceType()).thenReturn("SPARQL Endpoint");
        
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
        SourceCollection sources = SourceCollection.getInstance();
        SourceTableModel table = new SourceTableModel(sources);
        
        int colCount = table.getColumnCount();
        assertTrue("Count is "+colCount, colCount == 2);
    }
    
    @Test
    public void testGetValueAtForFirstSource() {
        SourceCollection sources = SourceCollection.getInstance();
        sources.addSource(source1);
        SourceTableModel table = new SourceTableModel(sources);
        int firstRow = 0;
        int firstCol = 0;
        assertEquals(museum, table.getValueAt(firstRow, firstCol));
    }
    
    @Test
    public void testGetColumnName() {
        fail();
    }
    
}