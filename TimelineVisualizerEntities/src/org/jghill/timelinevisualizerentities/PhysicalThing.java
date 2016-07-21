package org.jghill.timelinevisualizerentities;

import java.util.Date;

/**
 * An abstraction of a physical object for subclasses that represent real
 * objects.
 * 
 * @author JamesGHill
 */
public abstract class PhysicalThing extends Entities {
    
    private Date creationDate;
    private Date acquisitionDate;
    
    private String length;
    private String width;
    private String height;
    private String lengthUnit;
    private String widthUnit;
    private String heightUnit;
    
    private String consistsOf;
    private String physicalDescription;
    
    private String mainImage;
    
    private String label;
    private String commentary;

    public PhysicalThing(String name, String identifier) {
        super(name, identifier);
    }
    
}