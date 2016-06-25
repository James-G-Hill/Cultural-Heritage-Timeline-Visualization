package org.jghill.timelinevisualizersourcesgui;

import org.jghill.timelinevisualizersources.Source;
import org.jghill.timelinevisualizersources.SourceCollection;
import static org.junit.Assert.assertEquals;
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
    String sparql = "SPARQL Endpoint";
    
    public SourceTableModelTest() {}
    
    @Before
    public void setUp() {
        source1 = mock(Source.class);
        when(source1.getSourceName()).thenReturn(museum);
        when(source1.getSourceType()).thenReturn(sparql);
        source2 = mock(Source.class);
    }
    
    @Test
    public void testGetRowCountReturnsCorrectNumberOfRows() {
        SourceCollection sources = mock(SourceCollection.class);
        when(sources.getSize()).thenReturn(2);
        SourceTableModel table = new SourceTableModel(sources);
        assertEquals(2, table.getRowCount());
    }
    
    @Test
    public void testGetColumnCountReturnsCorrectNumberOfColumns() {
        SourceCollection sources = mock(SourceCollection.class);
        SourceTableModel table = new SourceTableModel(sources);
        assertEquals(2, table.getColumnCount());
    }
    
    @Test
    public void testGetValueAtFirstColumn() {
        SourceCollection sources = SourceCollection.getInstance();
        sources.addSource(source1);
        SourceTableModel table = new SourceTableModel(sources);
        int row = 0;
        int col = 0;
        assertEquals(museum, table.getValueAt(row, col));
    }
    
    @Test
    public void testGetValueAtSecondColumn() {
        SourceCollection sources = SourceCollection.getInstance();
        sources.addSource(source1);
        SourceTableModel table = new SourceTableModel(sources);
        int row = 0;
        int col = 1;
        assertEquals(sparql, table.getValueAt(row, col));
    }
    
}