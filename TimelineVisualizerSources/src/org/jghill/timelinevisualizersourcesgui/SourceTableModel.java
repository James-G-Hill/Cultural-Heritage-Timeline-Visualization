package org.jghill.timelinevisualizersourcesgui;

import java.util.SortedSet;
import javax.swing.table.AbstractTableModel;
import org.jghill.timelinevisualizersources.Source;

/**
 * A table model for sources to feed into the source management table.
 * 
 * @author JGHill
 */
public class SourceTableModel extends AbstractTableModel {

    private final Source[] sources;
    
    public SourceTableModel(SortedSet<Source> collection) {
        sources = (Source[]) collection.toArray();
    }
    
    @Override
    public int getRowCount() {
//        return sources.length;
    }

    @Override
    public int getColumnCount() {
//        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        switch(columnIndex) {
//            case 0:
//                return sources[rowIndex].getSourceName();
//            case 1:
//                return sources[rowIndex].getSourceType();
//            default:
//                return "";
//        }
    }
    
    @Override
    public String getColumnName(int col) {
//        switch (col) {
//            case 0:
//                return "Name";
//            case 1:
//                return "Type";
//            default:
//                return "";
//        }
    }
    
}