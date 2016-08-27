package org.jghill.timelinevisualizersourcesxml;

import org.jghill.timelinevisualizersources.Source;

/**
 * An interface for XML parsing the Source Manager information.
 * 
 * @author JGHill
 */
public interface SourceManagerXMLParser {
    
    /**
     * A method for parsing Sources from an xml file.
     * 
     * @return an array of the Sources.
     */
    public Source[] parseSources();
    
}