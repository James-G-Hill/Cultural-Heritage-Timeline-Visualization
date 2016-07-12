package org.jghill.timelinesvisualizerqueriesbuilder;

import java.util.Date;

/**
 * An object for holding settings for queries that can be passed from the
 * CollectionTopComponent to the QueryBuilder.
 * 
 * @author JGHill
 */
public class QuerySettings {
    
    public final boolean acquisitionDateCheck;
    public final boolean consistsOfCheck;
    public final boolean creationDateCheck;
    public final boolean foundLocationCheck;
    public final boolean hasImageCheck;
    public final boolean lengthCheck;
    public final boolean originCheck;
    public final boolean thicknessCheck;
    public final boolean widthCheck;
        
//        LengthUnitComboBox;
//        ThicknessUnitComboBox;
//        WidthUnitComboBox;
        
    public final Date acquisitionEndDate;
    public final Date acquisitionStartDate;
    public final Date creationEndDate;
    public final Date creationStartDate;
        
    public final String consistsOf;
    public final String locationFound;
    public final String locationOrigin;
    
    public final Double lengthLower;
    public final Double lengthUpper;
    public final Double thicknessLower;
    public final Double thicknessUpper;
    public final Double widthLower;
    public final Double widthUpper;
    
    public QuerySettings(
            boolean acquisitionDateCheck,
            boolean consistsOfCheck,
            boolean creationDateCheck,
            boolean foundLocationCheck,
            boolean hasImageCheck,
            boolean lengthCheck,
            boolean originCheck,
            boolean thicknessCheck,
            boolean widthCheck,
            Date acquisitionEndDate,
            Date acquisitionStartDate,
            Date creationEndDate,
            Date creationStartDate,
            String consistsOf,
            String locationFound,
            String locationOrigin,
            Double lengthLower,
            Double lengthUpper,
            Double thicknessLower,
            Double thicknessUpper,
            Double widthLower,
            Double widthUpper) {
        
        this.acquisitionDateCheck = acquisitionDateCheck;
        this.consistsOfCheck = consistsOfCheck;
        this.creationDateCheck = creationDateCheck;
        this.foundLocationCheck = foundLocationCheck;
        this.hasImageCheck = hasImageCheck;
        this.lengthCheck = lengthCheck;
        this.originCheck = originCheck;
        this.thicknessCheck = thicknessCheck;
        this.widthCheck = widthCheck;
        this.acquisitionEndDate = acquisitionEndDate;
        this.acquisitionStartDate = acquisitionStartDate;
        this.creationEndDate = creationEndDate;
        this.creationStartDate = creationStartDate;
        this.consistsOf = consistsOf;
        this.locationFound = locationFound;
        this.locationOrigin = locationOrigin;
        this.lengthLower = lengthLower;
        this.lengthUpper = lengthUpper;
        this.thicknessLower = thicknessLower;
        this.thicknessUpper = thicknessUpper;
        this.widthLower = widthLower;
        this.widthUpper = widthUpper;
    }
    
}