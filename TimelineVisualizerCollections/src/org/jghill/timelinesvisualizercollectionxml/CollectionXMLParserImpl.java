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
        name = path.evaluate("/collection/information/name", doc);
        notes = path.evaluate("/collection/information/notes", doc);
        
        // Setup the Queries.
        QueriesCollection queries = new QueriesCollection();
        int queriesCount;
        queriesCount = Integer.parseInt(path.evaluate("count(/collection/queries/query)", doc));
        for (int i = 1; i <= queriesCount; i++) {
            String queryName = path.evaluate("/collection/queries/query[" + i + "]/name", doc);
            String queryType = path.evaluate("/collection/queries/query[" + i + "]/type", doc);
            if (queryType.equalsIgnoreCase("sparql endpoint")) {
                String queryString = path.evaluate("/collection/queries/query[" + i + "]/querystring", doc);
                String address = path.evaluate("/collection/queries/query[" + i + "]/address", doc);
                String cidoc = path.evaluate("/collection/queries/query[" + i + "]/cidoc", doc);
                int limit = Integer.parseInt(path.evaluate("/collection/queries/query[" + i + "]/limit", doc));
                QueryShell query  = new SPARQLQueryShell(
                        queryString,
                        address,
                        cidoc,
                        queryName,
                        10
                );
                queries.addQuery(query);
            }
        }
        
        // Setup the Entities.
        EntitiesCollection entities = new EntitiesCollection("Entities");
        int entitiesCount;
        entitiesCount = Integer.parseInt(path.evaluate("count(/collection/entities/entity)", doc));
        for (int i = 1; i <= entitiesCount; i++) {
            String identifier = path.evaluate("/collection/entities/entity[" + i + "]/identifier", doc);
            String entityName = path.evaluate("/collection/entities/entity[" + i + "]/name", doc);
            String query = path.evaluate("/collection/entities/entity[" + i + "]/query", doc);
            String source = path.evaluate("/collection/entities/entity[" + i + "]/source", doc);
            String consists = path.evaluate("/collection/entities/entity[" + i + "]/consists", doc);
            String creator = path.evaluate("/collection/entities/entity[" + i + "]/creator", doc);
            String curatorial = path.evaluate("/collection/entities/entity[" + i + "]/curatorial", doc);
            String depicts = path.evaluate("/collection/entities/entity[" + i + "]/depicts", doc);
            String description = path.evaluate("/collection/entities/entity[" + i + "]/description", doc);
            String image = path.evaluate("/collection/entities/entity[" + i + "]/image", doc);
            String object = path.evaluate("/collection/entities/entity[" + i + "]/object", doc);
            String technique = path.evaluate("/collection/entities/entity[" + i + "]/technique", doc);
            String type = path.evaluate("/collection/entities/entity[" + i + "]/type", doc);
            String year = path.evaluate("/collection/entities/entity[" + i + "]/year", doc);
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