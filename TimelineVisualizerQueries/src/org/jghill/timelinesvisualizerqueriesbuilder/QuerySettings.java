package org.jghill.timelinesvisualizerqueriesbuilder;

import org.jghill.timelinevisualizersources.Source;

/**
 * An object for holding settings for queries.
 * 
 * @author JGHill
 */
public class QuerySettings {
    
    public final Source source;
    public final String queryName;
    
    public final String creationStartDate;
    public final String creationEndDate;
    
    public final boolean hasNameCheck;
    public final String name;
    
    public final boolean hasIdentifierCheck;
    public final String identifier;
    
    public final boolean hasDepictionCheck;
    public final String depiction;
    
    public final boolean hasConsistsCheck;
    public final String consists;
    
    public final boolean hasTypeCheck;
    public final String type;
    
    public final boolean hasTechniqueCheck;
    public final String technique;
    
    public final boolean hasCreatorCheck;
    public final String creator;
    
    public final boolean hasLimitCheck;
    public final String limit;
    
    public final boolean hasImageCheck;
    
    public QuerySettings(
            
            Source source,
            String queryName,
            
            String creationStartDate,
            String creationEndDate,
            
            boolean hasNameCheck,
            String name,
            
            boolean hasIdentifierCheck,
            String identifier,
            
            boolean hasDepictionCheck,
            String depiction,
            
            boolean hasConsistsCheck,
            String consists,
            
            boolean hasTypeCheck,
            String type,
            
            boolean hasTechniqueCheck,
            String technique,
            
            boolean hasCreatorCheck,
            String creator,
            
            boolean hasLimitCheck,
            String limit,
            
            boolean hasImageCheck
            
    ) {
        this.source = source;
        this.queryName = queryName;
        
        this.creationStartDate = creationStartDate;
        this.creationEndDate = creationEndDate;
        
        this.hasNameCheck = hasNameCheck;
        this.name = name;
        
        this.hasIdentifierCheck = hasIdentifierCheck;
        this.identifier = identifier;
        
        this.hasDepictionCheck = hasDepictionCheck;
        this.depiction = depiction;
        
        this.hasConsistsCheck = hasConsistsCheck;
        this.consists = consists;
        
        this.hasTypeCheck = hasTypeCheck;
        this.type = type;
        
        this.hasTechniqueCheck = hasTechniqueCheck;
        this.technique = technique;
        
        this.hasCreatorCheck = hasCreatorCheck;
        this.creator = creator;
        
        this.hasLimitCheck = hasLimitCheck;
        this.limit = limit;
        
        this.hasImageCheck = hasImageCheck;
    }
    
}