package org.jghill.timelinesvisualizercollectionxml;

import javax.xml.xpath.XPathExpressionException;
import org.jghill.timelinesvisualizercollections.Collection;

/**
 * A parser for collections.
 * 
 * @author JGHill
 */
public interface CollectionXMLParser {
    
    /**
     * A method for parsing Collections from XML files.
     * 
     * @return a Collection.
     */
    public Collection parseCollection() throws XPathExpressionException;
    
}