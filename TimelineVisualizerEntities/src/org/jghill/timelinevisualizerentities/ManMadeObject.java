package org.jghill.timelinevisualizerentities;

/**
 * A class representing objects that have been designed &  created by humans.
 * 
 * @author JGHill
 */
public class ManMadeObject extends PhysicalThing {
    
    public ManMadeObject(
            String currentOwner
    ) {
        this.currentOwner = currentOwner;
    }
    
    public final String currentOwner;
    
}