package org.jghill.timelinevisualizerentities;

/**
 * A class representing objects that have been designed & created by humans.
 * 
 * @author JGHill
 */
public class ManMadeObject extends PhysicalThing {
    
    /**
     * Constructor for the class.
     * 
     * @param name of the object.
     * @param identifier to recognise the object.
     * @param source of the object.
     * @param query that collected the object.
     * @param depicts some visual entity.
     * @param consists of some material.
     * @param type of the object.
     * @param technique used to produce the object.
     * @param image representing the object.
     * @param year the object is estimated to have been produced.
     * @param creator of the object.
     * @param object address for identification online.
     * @param description of the object.
     * @param curatorial comments about the object.
     */
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
            String year,
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
                year,
                creator,
                object,
                description,
                curatorial
        );
    }
    
}