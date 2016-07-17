package org.jghill.timelinesvisualizercollectionsgui;

import javax.swing.table.AbstractTableModel;
import org.jghill.timelinevisualizerentities.Entities;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;

/**
 * A model for assisting display of Entities in the Entity Table.
 * 
 * @author JGHill
 */
public class EntityTableModel extends AbstractTableModel {

    private final EntitiesCollection entitiesCollection;
    private Entities[] entities;
    
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
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
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
        entities = new Entities[entitiesCollection.count()];
        entitiesCollection.getCollectionSet().toArray(entities);
    }
    
    
    /**
     * Returns an entity from the underlying collection.
     * 
     * @param index the row number identifying the Entities.
     * @return The entity at the row.
     */
    public Entities returnQuery(int index) {
        return entities[index];
    }
    
}