package org.jghill.timelinesvisualizercollectionxml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.jghill.timelinesvisualizercollections.Collection;
import org.jghill.timelinesvisualizercollections.CollectionImpl;
import org.jghill.timelinevisualizerentities.Entities;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;
import org.jghill.timelinevisualizerqueries.QueryShell;
import org.jghill.timelinevisualizerqueries.SPARQLQueryShell;
import org.jghill.timelinevisualizerqueriescollection.QueriesCollection;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * An implementation of the Collection parser.
 * 
 * @author JGHill
 */
public class CollectionXMLParserImpl implements CollectionXMLParser {
    
    private final Document doc;
    private final DocumentBuilder builder;
    private final XPath path;
    
    /**
     * Constructor.
     * 
     * @param f the file to be passed.
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException 
     */
    public CollectionXMLParserImpl(File f) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        doc = builder.parse(f);
        XPathFactory xFactory = XPathFactory.newInstance();
        path = xFactory.newXPath();
    }
    
    @Override
    public Collection parseCollection() throws XPathExpressionException {
        
        // Setup basic collection info.
        String name;
        String notes;
        name = path.evaluate("/information/name", doc);
        notes = path.evaluate("/information/notes", doc);
        
        // Setup the Queries.
        QueriesCollection queries = new QueriesCollection();
        int queriesCount;
        queriesCount = Integer.parseInt(path.evaluate("count(/queries/query)", doc));
        for (int i = 0; i < queriesCount; i++) {
            String queryName = path.evaluate("/queries/query/name", doc);
            String queryType = path.evaluate("/queries/query/type", doc);
            if (queryType.equalsIgnoreCase("sparql endpoint")) {
                String queryString = path.evaluate("/queries/query/querystring", doc);
                String address = path.evaluate("/queries/query/address", doc);
                String cidoc = path.evaluate("/queries/query/cidoc", doc);
                QueryShell query  = new SPARQLQueryShell(
                        queryString,
                        address,
                        cidoc,
                        queryName
                );
                queries.addQuery(query);
            }
        }
        
        // Setup the Entities.
        EntitiesCollection entities = new EntitiesCollection("Entities");
        int entitiesCount;
        entitiesCount = Integer.parseInt(path.evaluate("count(/entities/entity)", doc));
        for (int i = 0; i < entitiesCount; i++) {
            String identifier = path.evaluate("/entities/entity[" + i + "]/identifier", doc);
            String entityName = path.evaluate("/entities/entity[" + i + "]/name", doc);
            String query = path.evaluate("/entities/entity[" + i + "]/query", doc);
            String source = path.evaluate("/entities/entity[" + i + "]/source", doc);
            String consists = path.evaluate("/entities/entity[" + i + "]/consists", doc);
            String creator = path.evaluate("/entities/entity[" + i + "]/creator", doc);
            String curatorial = path.evaluate("/entities/entity[" + i + "]/curatorial", doc);
            String depicts = path.evaluate("/entities/entity[" + i + "]/depicts", doc);
            String description = path.evaluate("/entities/entity[" + i + "]/description", doc);
            String image = path.evaluate("/entities/entity[" + i + "]/image", doc);
            String object = path.evaluate("/entities/entity[" + i + "]/object", doc);
            String technique = path.evaluate("/entities/entity[" + i + "]/technique", doc);
            String type = path.evaluate("/entities/entity[" + i + "]/type", doc);
            String year = path.evaluate("/entities/entity[" + i + "]/year", doc);
            Entities entity = new ManMadeObject(
                    entityName,
                    identifier,
                    source,
                    query,
                    depicts,
                    consists,
                    type,
                    technique,
                    image,
                    year,
                    creator,
                    object,
                    description,
                    curatorial
            );
            entities.addThing(entity);
        }
        
        // Creat the collection.
        Collection collection = new CollectionImpl(
            name,
            entities,
            queries
        );
        collection.setNotes(notes);
        return collection;
        
    }
    
}