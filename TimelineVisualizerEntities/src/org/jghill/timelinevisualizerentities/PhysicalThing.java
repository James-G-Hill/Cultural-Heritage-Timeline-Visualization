package org.jghill.timelinevisualizerentities;

import java.util.Date;

/**
 * An abstraction of a physical object for subclasses that represent real
 * objects.
 * 
 * @author JamesGHill
 */
public abstract class PhysicalThing extends Entities {
    
    /**
     * Dates
     */
    private Date creationDate;
    private Date acquisitionDate;
    
    /**
     * Dimensions
     */
    private String length;
    private String width;
    private String height;
    private String lengthUnit;
    private String widthUnit;
    private String heightUnit;
    
    /**
     * Physical properties
     */
    private String consistsOf;
    private String physicalDescription;
    
    /**
     * Images
     */
    private String mainImage;
    
    /**
     * Metadata
     */
    public String identifier;
    private String label;
    private String commentary;
    
}