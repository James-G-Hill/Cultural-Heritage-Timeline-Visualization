package org.jghill.timelinesvisualizercollectionsgui;

import org.jghill.timelinesvisualizercollections.gui.EntityTableModel;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A testing class for the EntityTableModel.
 * 
 * @author JGHill
 */
public class EntityTableModelTest {
    
    int rowCount = 4;
    
    static EntitiesCollection coll1;
    static EntitiesCollection coll2;
    static EntitiesCollection coll3;
    static EntitiesCollection coll4;
    
    static ManMadeObject mmo1;
    static ManMadeObject mmo2;
    static ManMadeObject mmo3;
    static ManMadeObject mmo4;
    
    static EntityTableModel table;
    
    public EntityTableModelTest() {}
    
    @Before
    public void setUp() {
        
        coll1 = new EntitiesCollection("Test1");
        coll2 = new EntitiesCollection("Test2");
        coll3 = new EntitiesCollection("Test3");
        coll4 = new EntitiesCollection("Test4");
        
        mmo1 = new ManMadeObject("A", "A", "A", "A", "A");
        mmo2 = new ManMadeObject("B", "B", "B", "B", "B");
        mmo3 = new ManMadeObject("C", "C", "C", "C", "C");
        mmo4 = new ManMadeObject("D", "D", "D", "D", "D");
        
    }

    @Test
    public void testEntitiesFlattenReturnsCorrectArraySizeOneLayer() {
        coll1.addThing(mmo1);
        coll1.addThing(mmo2);
        coll1.addThing(mmo3);
        coll1.addThing(mmo4);
        table = new EntityTableModel(coll1);
        assertEquals(rowCount, table.getRowCount());
    }
    
    @Test
    public void testEntitiesFlattenReturnsCorrectArraySizeFourLayers() {
        coll1.addThing(coll2);
        coll2.addThing(coll3);
        coll3.addThing(coll4);
        coll1.addThing(mmo1);
        coll2.addThing(mmo2);
        coll3.addThing(mmo3);
        coll4.addThing(mmo4);
        table = new EntityTableModel(coll1);
        assertEquals(rowCount, table.getRowCount());
    }
    
    @Test
    public void testEntitiesFlattenReturnsCorrectArraySizeAllSecondLayer() {
        coll1.addThing(coll2);
        coll1.addThing(coll3);
        coll2.addThing(mmo1);
        coll2.addThing(mmo2);
        coll3.addThing(mmo3);
        coll3.addThing(mmo4);
        table = new EntityTableModel(coll1);
        assertEquals(rowCount, table.getRowCount());
    }
    
    @Test
    public void testEntitiesFlattenReturnsCorrectArraySizeAllFourthLayer() {
        coll1.addThing(coll2);
        coll2.addThing(coll3);
        coll3.addThing(coll4);
        coll4.addThing(mmo1);
        coll4.addThing(mmo2);
        coll4.addThing(mmo3);
        coll4.addThing(mmo4);
        table = new EntityTableModel(coll1);
        assertEquals(rowCount, table.getRowCount());
    }
    
}