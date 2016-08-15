package org.jghill.timelinesvisualizercollections.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.jghill.timelinesvisualizercollections.Collection;
import org.jghill.timelinevisualizerentities.Entities;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;

/**
 * A model for assisting display of Entities in the Entity Table.
 * @author JGHill
 */
public class EntityTableModel extends AbstractTableModel {

    private final Collection collection;
    private ManMadeObject[] entities;
    
    private static final int COL_COUNT = 6;
    
    public EntityTableModel(Collection c) {
        this.collection = c;
        updateDataTable();
    }
    
    @Override
    public int getRowCount() {
        return entities.length;
    }

    @Override
    public int getColumnCount() {
        return COL_COUNT;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        Integer year;
        switch(columnIndex){
            case 0:
                return entities[rowIndex].getIdentifier();
            case 1:
                return entities[rowIndex].getName();
            case 2:
                return entities[rowIndex].getQueryName();
            case 3:
                return entities[rowIndex].getSourceName();
            case 4:
                String urlString = "";
                if (entities[rowIndex].getImageURL() != null) {
                    urlString = entities[rowIndex].getImageURL().toString();
                }
                return urlString;
            case 5:
                year = entities[rowIndex].getTimeSpan();
                return formatYear(year);
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int col) {
        switch(col) {
            case 0:
                return "Identifier";
            case 1:
                return "Name";
            case 2:
                return "Query";
            case 3:
                return "Source";
            case 4:
                return "Image";
            case 5:
                return "Time Span";
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
        List flat = entitiesFlatten(collection.getEntitiesCollection());
        entities = new ManMadeObject[flat.size()];
        flat.toArray(entities);
    }
    
    /**
     * Returns an entity from the underlying collection.
     * @param index the row number identifying the Entities.
     * @return The entity at the row.
     */
    public Entities returnQuery(int index) {
        return entities[index];
    }
    
    /**
     * Flattens the entities collection into a single list.
     * @param coll the EntitiesCollection.
     * @return a list containing all internal non-collections.
     */
    private List<Entities> entitiesFlatten(EntitiesCollection coll) {
        List<Entities> arr = new ArrayList<>();
        for (Entities e : coll.getCollectionSet()) {
            if(e instanceof EntitiesCollection) {
                arr.addAll(entitiesFlatten((EntitiesCollection)e));
            } else {
                arr.add(e);
            }
        }
        return arr;
    }
    
    /**
     * @return the flattened collection as an array.
     */
    public ManMadeObject[] getFlattenedCollection() {
        return entities;
    }
    
    /**
     * Formats the year.
     * @param i the year as int.
     * @return text to represent the year.
     */
    private String formatYear(Integer i) {
        if (i == null) {
            return "";
        } else {
            return String.valueOf(i);
        }
    }
    
    /**
     * Clears all entities.
     */
    public void clearAll() {
        collection.clearEntitiesCollection();
        fireTableDataChanged();
    }
    
}