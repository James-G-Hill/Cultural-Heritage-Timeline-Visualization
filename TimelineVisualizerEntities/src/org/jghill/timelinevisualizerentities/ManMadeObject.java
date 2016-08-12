package org.jghill.timelinevisualizerentities;

import javax.management.Query;
import javax.xml.transform.Source;

/**
 * A class representing objects that have been designed &  created by humans.
 * @author JGHill
 */
public class ManMadeObject extends PhysicalThing {
    
    public ManMadeObject(
            String name,
            String identifier,
            Source source,
            Query query,
            String image,
            String timeSpan
    ) {
        super(name, identifier, source, query, image, timeSpan);
    }
    
}