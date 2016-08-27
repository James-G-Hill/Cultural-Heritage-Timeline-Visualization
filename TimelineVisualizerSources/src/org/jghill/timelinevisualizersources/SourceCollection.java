package org.jghill.timelinevisualizersources;

import java.util.SortedSet;
import java.util.TreeSet;
import javax.xml.parsers.ParserConfigurationException;
import org.jghill.timelinevisualizersourcesxml.SourceManagerXMLWriter;
import org.jghill.timelinevisualizersourcesxml.SourceManagerXMLWriterImpl;
import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

/**
 * A singleton pattern holding a collections of sources.
 * 
 * @author JGHill
 */
public class SourceCollection implements Lookup.Provider {
    
    private static final SortedSet<Source> SOURCES = new TreeSet<>();
    private static final SourceCollection COLLECTION = new SourceCollection();
    
    private static final InstanceContent IC = new InstanceContent();
    private static final Lookup LOOKUP = new AbstractLookup(IC);
    
    private static SourceManagerXMLWriter xmlWriter;
    
    /**
     * Returns the single instance of this singleton pattern.
     * 
     * @return this SourceCollection.
     */
    public static SourceCollection getInstance() {
        return COLLECTION;
    }
    
    /**
     * Return the entire collection.
     * 
     * @return the source collection.
     */
    public static SortedSet<Source> getSourceCollectionSet() {
        return SOURCES;
    }
    
    /**
     * Add a source to the collection.
     * 
     * @param source The new source to be added.
     */
    public static void addSource(Source source) {
        SOURCES.add(source);
        IC.add(source);
        saveXML();
    }
    
    /**
     * Delete a source from the collection & return 'true' to confirm.
     * 
     * @param source The source to be deleted.
     */
    public static void deleteSource(Source source) {
        SOURCES.remove(source);
        IC.remove(source);
        saveXML();
    }
    
    /**
     * Returns the number of sources in the SourceCollection.
     * 
     * @return the size of the collection.
     */
    public static int getSize() {
        return SOURCES.size();
    }
    
    /**
     * Returns the collection as an array.
     * 
     * @return the collection in array form.
     */
    public static Source[] collectionToArray() {
        Source[] sources = new Source[SOURCES.size()];
        sources = SOURCES.toArray(sources);
        return sources;
    }

    @Override
    public Lookup getLookup() {
        return LOOKUP;
    }
    
    /**
     * Saves the Source Collection as an XML document.
     */
    private static void saveXML() {
        try {
            xmlWriter = new SourceManagerXMLWriterImpl();
            xmlWriter.build();
            xmlWriter.print();
        } catch (ParserConfigurationException ex) {}
    }
    
}