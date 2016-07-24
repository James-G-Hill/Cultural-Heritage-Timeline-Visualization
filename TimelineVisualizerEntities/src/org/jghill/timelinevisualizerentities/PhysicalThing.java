package org.jghill.timelinevisualizerentities;

import java.util.Date;

/**
 * An abstraction of a physical object for subclasses that represent real
 * objects.
 * 
 * @author JamesGHill
 */
public abstract class PhysicalThing extends Entities {
    
    private final String timeBegin;
    private final String timeFinal;
    
    private String creationDate;
    private String acquisitionDate;
    
    private String length;
    private String width;
    private String height;
    private String lengthUnit;
    private String widthUnit;
    private String heightUnit;
    
    private String consistsOf;
    private String physicalDescription;
    
    protected String image;
    protected String imageNote;
    
    private String label;
    private String commentary;

    public PhysicalThing(
            String name,
            String identifier,
            String image,
            String timeBegin,
            String timeFinal
    ) {
        super(name, identifier);
        this.image = image;
        this.timeBegin = timeBegin;
        this.timeFinal = timeFinal;
    }
    
    public String getImage() {
        return image;
    }
    
    public String getTimeBegin() {
        return timeBegin;
    }
    
    public String getTimeFinal() {
        return timeFinal;
    }
}