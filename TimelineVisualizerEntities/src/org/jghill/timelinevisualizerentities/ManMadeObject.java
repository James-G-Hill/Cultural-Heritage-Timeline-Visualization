package org.jghill.timelinevisualizerentities;

/**
 * A class representing objects that have been designed & created by humans.
 * 
 * @author JGHill
 */
public class ManMadeObject extends PhysicalThing {
    
    public ManMadeObject(
            String name,
            String identifier,
            String source,
            String query,
            String depicts,
            String consists,
            String type,
            String technique,
            String image,
            String timeSpan,
            String creator,
            String object,
            String description,
            String curatorial
    ) {
        super(
                name,
                identifier,
                source,
                query,
                depicts,
                consists,
                type,
                technique,
                image,
                timeSpan,
                creator,
                object,
                description,
                curatorial
        );
    }
    
}