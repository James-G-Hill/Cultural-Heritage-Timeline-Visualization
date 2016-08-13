package org.jghill.timelinevisualizerentities;

/**
 * A class representing objects that have been designed &  created by humans.
 * @author JGHill
 */
public class ManMadeObject extends PhysicalThing {
    
    public ManMadeObject(
            String name,
            String identifier,
            String source,
            String query,
            String image,
            String timeSpan
    ) {
        super(name, identifier, source, query, image, timeSpan);
    }
    
}