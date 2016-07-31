package org.jghill.timelinesvisualizerqueriesbuilder;

import java.util.Date;
import org.jghill.timelinevisualizersources.Source;

/**
 * An object for holding settings for queries that can be passed from the
 * CollectionTopComponent to the QueryBuilder.
 * 
 * @author JGHill
 */
public class QuerySettings {
    
    public final Source theSource;
    public final String name;
    
    public final boolean acquisitionDateCheck;
    public final boolean consistsOfCheck;
    public final boolean creationDateCheck;
    public final boolean hasImageCheck;
    public final boolean lengthCheck;
    public final boolean originCheck;
    public final boolean thicknessCheck;
    public final boolean widthCheck;
        
    public final String lengthUnit;
    public final String thicknessUnit;
    public final String widthUnit;
        
    public final Date acquisitionEndDate;
    public final Date acquisitionStartDate;
    public final Date creationEndDate;
    public final Date creationStartDate;
        
    public final String consistsOf;
    public final String locationOrigin;
    
    public final String lengthLower;
    public final String lengthUpper;
    public final String thicknessLower;
    public final String thicknessUpper;
    public final String widthLower;
    public final String widthUpper;
    
    public final String limit;
    
    public QuerySettings(
            Source theSource,
            String name,
            boolean acquisitionDateCheck,
            boolean consistsOfCheck,
            boolean creationDateCheck,
            boolean hasImageCheck,
            boolean lengthCheck,
            boolean originCheck,
            boolean thicknessCheck,
            boolean widthCheck,
            String lengthUnit,
            String thicknessUnit,
            String widthUnit,
            Date acquisitionEndDate,
            Date acquisitionStartDate,
            Date creationEndDate,
            Date creationStartDate,
            String consistsOf,
            String locationOrigin,
            String lengthLower,
            String lengthUpper,
            String thicknessLower,
            String thicknessUpper,
            String widthLower,
            String widthUpper,
            String limit) {
        
        this.theSource = theSource;
        this.name = name;
        this.acquisitionDateCheck = acquisitionDateCheck;
        this.consistsOfCheck = consistsOfCheck;
        this.creationDateCheck = creationDateCheck;
        this.hasImageCheck = hasImageCheck;
        this.lengthCheck = lengthCheck;
        this.originCheck = originCheck;
        this.thicknessCheck = thicknessCheck;
        this.widthCheck = widthCheck;
        this.lengthUnit = lengthUnit;
        this.thicknessUnit = thicknessUnit;
        this.widthUnit = widthUnit;
        this.acquisitionEndDate = acquisitionEndDate;
        this.acquisitionStartDate = acquisitionStartDate;
        this.creationEndDate = creationEndDate;
        this.creationStartDate = creationStartDate;
        this.consistsOf = consistsOf;
        this.locationOrigin = locationOrigin;
        this.lengthLower = lengthLower;
        this.lengthUpper = lengthUpper;
        this.thicknessLower = thicknessLower;
        this.thicknessUpper = thicknessUpper;
        this.widthLower = widthLower;
        this.widthUpper = widthUpper;
        this.limit = limit;
    }
    
}