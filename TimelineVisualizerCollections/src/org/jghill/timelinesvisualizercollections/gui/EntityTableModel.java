package org.jghill.timelinesvisualizercollections.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.jghill.timelinevisualizerentities.Entities;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;

/**
 * A model for assisting display of Entities in the Entity Table.
 * 
 * @author JGHill
 */
public class EntityTableModel extends AbstractTableModel {

    private final EntitiesCollection collection;
    private ManMadeObject[] entities;
    
    private static final int COL_COUNT = 5;
    
    public EntityTableModel(EntitiesCollection e) {
        this.collection = e;
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
                String urlString = "";
                if (entities[rowIndex].getImageURL() != null) {
                    urlString = entities[rowIndex].getImageURL().toString();
                }
                return urlString;
            case 3:
                year = entities[rowIndex].getTimeBegin();
                return formatYear(year);
            case 4:
                year = entities[rowIndex].getTimeFinal();
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
                return "Image";
            case 3:
                return "Time Start";
            case 4:
                return "Time Finish";
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
        List flat = entitiesFlatten(collection);
        entities = new ManMadeObject[flat.size()];
        flat.toArray(entities);
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
    
    /**
     * Flattens the entities collection into a single list.
     * 
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
     * 
     * @param i the year as int.
     * @return text to represent the year.
     */
    private String formatYear(int i) {
        if (i == -1) {
            return "";
        } else {
            return String.valueOf(i);
        }
    }
}