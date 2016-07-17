package org.jghill.timelinesvisualizercollectionsgui;

import javax.swing.table.AbstractTableModel;
import org.jghill.timelinevisualizerqueries.QueryShell;
import org.jghill.timelinevisualizerqueriescollection.QueriesCollection;

/**
 * A model for assisting display of QueryShell in the Query Table.
 * 
 * @author JGHill
 */
public class QueryTableModel extends AbstractTableModel {

    private final QueriesCollection queries;
    private QueryShell[] shells;
    
    public QueryTableModel(QueriesCollection queries) {
        this.queries = queries;
        updateDataTable();
    }
    
    @Override
    public int getRowCount() {
        return queries.getCount();
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
        shells = new QueryShell[queries.getCount()];
        queries.getCollectionSet().toArray(shells);
    }
    
    /**
     * Deletes a source from the underlying collection.
     * 
     * @param index the row number of the source.
     */
    public void deleteSource(int index) {
        queries.deleteQuery(shells[index]);
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