package org.jghill.timelinevisualizersourcesxml;

import java.util.List;
import javax.xml.xpath.XPathExpressionException;
import org.jghill.timelinevisualizersources.Source;

/**
 * An interface for XML parsing the Source Manager information.
 * 
 * @author JGHill
 */
public interface SourceManagerXMLParser {
    
    /**
     * A method for parsing Sources from an XML file.
     * 
     * @return an array of the Sources.
     */
    public List<Source> parseSources() throws XPathExpressionException;
    
}