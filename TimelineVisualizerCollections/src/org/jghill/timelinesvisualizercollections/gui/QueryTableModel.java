package org.jghill.timelinesvisualizercollections.gui;

import javax.swing.table.AbstractTableModel;
import org.jghill.timelinesvisualizercollections.Collection;
import org.jghill.timelinevisualizerqueries.QueryShell;

/**
 * A model for assisting display of QueryShell in the Query Table.
 * 
 * @author JGHill
 */
public class QueryTableModel extends AbstractTableModel {

    private final Collection collection;
    private QueryShell[] shells;
    
    public QueryTableModel(Collection c) {
        this.collection = c;
        updateDataTable();
    }
    
    @Override
    public int getRowCount() {
        return shells.length;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return shells[rowIndex].getQueryName();
            case 1:
                return shells[rowIndex].getLastRunDate();
            case 2:
                return shells[rowIndex].getQueryType();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int col) {
        switch(col) {
            case 0:
                return "Name";
            case 1:
                return "Last Run";
            case 2:
                return "Query Type";
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
        shells = new QueryShell[collection.getQueriesCollection().getCount()];
        collection.getQueriesCollection().getCollectionSet().toArray(shells);
    }
    
    /**
     * Deletes a source from the underlying collection.
     * 
     * @param index the row number of the source.
     */
    public void deleteSource(int index) {
        collection.getQueriesCollection().deleteQuery(shells[index]);
        fireTableDataChanged();
    }
    
    /**
     * Returns a query from the underlying collection.
     * 
     * @param index the row number identifying the QueryShell.
     * @return The query at the row.
     */
    public QueryShell returnQuery(int index) {
        return shells[index];
    }
    
}