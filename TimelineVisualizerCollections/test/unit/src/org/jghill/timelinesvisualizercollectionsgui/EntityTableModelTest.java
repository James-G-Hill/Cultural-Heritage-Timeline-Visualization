package org.jghill.timelinesvisualizercollectionsgui;

import org.jghill.timelinevisualizerentities.ManMadeObject;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * A testing class for the EntityTableModel.
 * 
 * @author JGHill
 */
public class EntityTableModelTest {
    
    EntitiesCollection coll1;
    EntitiesCollection coll2;
    EntitiesCollection coll3;
    EntitiesCollection coll4;
    
    ManMadeObject mmo1;
    ManMadeObject mmo2;
    ManMadeObject mmo3;
    ManMadeObject mmo4;
    
    EntityTableModel table;
    
    public EntityTableModelTest() {}
    
    @Before
    public void setUp() {
        
        coll1 = mock(EntitiesCollection.class);
        coll2 = mock(EntitiesCollection.class);
        coll3 = mock(EntitiesCollection.class);
        coll4 = mock(EntitiesCollection.class);
        
        mmo1 = mock(ManMadeObject.class);
        mmo2 = mock(ManMadeObject.class);
        mmo3 = mock(ManMadeObject.class);
        mmo4 = mock(ManMadeObject.class);
        
        coll1.addThing(coll2);
        coll1.addThing(coll3);
        coll2.addThing(coll4);
        coll1.addThing(mmo1);
        coll2.addThing(mmo2);
        coll3.addThing(mmo3);
        coll4.addThing(mmo4);
        table = new EntityTableModel(coll1);
        
    }

    @Test
    public void testEntitiesFlattenReturnsCorrectArraySize() {
        int rowCount = 4;
        assertTrue(table.getRowCount() == rowCount);
    }
    
}