package org.jghill.timelinesvisualizercollectionsgui;

import javax.swing.table.AbstractTableModel;
import org.jghill.timelinevisualizerentities.Entities;
import org.jghill.timelinevisualizerentities.PhysicalThing;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;

/**
 * A model for assisting display of Entities in the Entity Table.
 * 
 * @author JGHill
 */
public class EntityTableModel extends AbstractTableModel {

    private final EntitiesCollection entitiesCollection;
    private Entities[] things;
    
    private final int columnCount = 2;
    
    public EntityTableModel(EntitiesCollection entities) {
        this.entitiesCollection = entities;
        updateDataTable();
    }
    
    @Override
    public int getRowCount() {
        return entitiesCollection.count();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return things[rowIndex].getName();
            case 1:
                return things[rowIndex].getName();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int col) {
        switch(col) {
            case 0:
                return "identifier";
            case 1:
                return "name";
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
        things = new PhysicalThing[entitiesCollection.count()];
        entitiesCollection.getCollectionSet().toArray(things);
    }
    
    
    /**
     * Returns an entity from the underlying collection.
     * 
     * @param index the row number identifying the Entities.
     * @return The entity at the row.
     */
    public Entities returnQuery(int index) {
        return things[index];
    }
    
}