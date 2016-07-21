package org.jghill.timelinevisualizerentities;

/**
 * A class representing objects that have been designed &  created by humans.
 * 
 * @author JGHill
 */
public class ManMadeObject extends PhysicalThing {
    
    public final String currentOwner;
    
    public ManMadeObject(
            String name,
            String identifier,
            String currentOwner
    ) {
        super(name, identifier);
        this.currentOwner = currentOwner;
    }
    
}