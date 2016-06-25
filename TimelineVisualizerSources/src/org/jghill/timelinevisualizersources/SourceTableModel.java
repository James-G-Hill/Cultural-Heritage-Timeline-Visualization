package org.jghill.timelinevisualizersources;

import javax.swing.table.AbstractTableModel;
import org.jghill.timelinevisualizersources.Source;
import org.jghill.timelinevisualizersources.SourceCollection;

/**
 * A table model for sources to feed into the source management table.
 * 
 * @author JGHill
 */
public class SourceTableModel extends AbstractTableModel {

    private final Source[] sources;
    
    public SourceTableModel(SourceCollection collection) {
        sources = new Source[collection.getSize()];
        collection.getSourceCollectionSet().toArray(sources);
    }
    
    @Override
    public int getRowCount() {
        return sources.length;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return sources[rowIndex].getSourceName();
            case 1:
                return sources[rowIndex].getSourceType();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Name";
            case 1:
                return "Type";
            default:
                return null;
        }
    }
    
}