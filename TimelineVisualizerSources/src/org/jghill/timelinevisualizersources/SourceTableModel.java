package org.jghill.timelinevisualizersources;

import javax.swing.table.AbstractTableModel;

/**
 * A table model for sources to feed into the source management table.
 * 
 * @author JGHill
 */
public class SourceTableModel extends AbstractTableModel {

    private Source[] sources;
    
    /**
     * Constructor.
     * 
     * @param c the Collection.
     */
    public SourceTableModel(SourceCollection c) {
        updateDataTable();
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
    
    @Override
    public void fireTableDataChanged() {
        updateDataTable();
        super.fireTableDataChanged();
    }
    
    /**
     * Updates the array fed from the data table.
     */
    private void updateDataTable() {
        sources = new Source[SourceCollection.getSize()];
        SourceCollection.getSourceCollectionSet().toArray(sources);
    }
    
    /**
     * Deletes a source from the underlying collection.
     * 
     * @param index the row number of the source.
     */
    public void deleteSource(int index) {
        SourceCollection.deleteSource(sources[index]);
        fireTableDataChanged();
    }
    
    /**
     * Returns a source from the underlying collection.
     * 
     * @param index the row number identifying the Source.
     * @return The source at the row.
     */
    public Source returnSource(int index) {
        return sources[index];
    }
    
}