package org.jghill.timelinesvisualizercollectionxml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jghill.timelinesvisualizercollections.Collection;
import org.jghill.timelinevisualizerentities.Entities;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import org.jghill.timelinevisualizerentities.PhysicalThing;
import org.jghill.timelinevisualizerqueries.QueryShell;
import org.jghill.timelinevisualizerqueries.SPARQLQueryShell;
import org.jghill.timelinevisualizerqueriescollection.QueriesCollection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * An implementation of the collection writer.
 * 
 * @author JGHill
 */
public class CollectionXMLWriterImpl implements CollectionXMLWriter {
    
    private final Collection collection;
    private final ManMadeObject[] entities;
    private final DocumentBuilder builder;
    private Document doc;
    
    /**
     * This is a constructor.
     * 
     * @param collection to be written to XML.
     * @param entities to be written.
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    public CollectionXMLWriterImpl(
            Collection collection,
            ManMadeObject[] entities
    ) throws ParserConfigurationException {
        this.collection = collection;
        this.entities = entities;
        builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }
    
    @Override
    public void build() {
        doc = builder.newDocument();
        Element rootElement = doc.createElement("collection");
        doc.appendChild(rootElement);
        createCollection(rootElement);
    }
    
    @Override
    public void print() {
        Transformer trans;
        try {
            trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source =  new DOMSource(doc);
            StreamResult file = new StreamResult(
                    new File(
                            "Collections/" + collection.getName() + ".xml"
                    )
            );
            trans.transform(source, file);
        } catch (TransformerException ex) {
            System.out.println("Transformer " + ex);
        }
    }
    
    /**
     * Creates a textual Element.
     * 
     * @param name for the element.
     * @param text to be contained with the element.
     * @return the element.
     */
    private Element createTextElement(
            String name,
            String text
    ) {
        Text t = doc.createTextNode(text);
        Element e = doc.createElement(name);
        e.appendChild(t);
        return e;
    }
    
    /**
     * Creates a collection of entities.
     * 
     * @param root element.
     */
    private void createCollection(Element root) {
        root.appendChild(createInfo());
        root.appendChild(createQueries());
        root.appendChild(createEntities());
    }
    
    /**
     * Creates a node for the information about the object.
     * 
     * @return a node containing the info.
     */
    private Element createInfo() {
        Element e = doc.createElement("information");
        e.appendChild(createTextElement("name", "" + collection.getName()));
        e.appendChild(createTextElement("notes", "" + collection.getNotes()));
        return e;
    }
    
    /**
     * Creates a node for containing the queries associated with the object.
     * 
     * @return a node of the queries.
     */
    private Element createQueries() {
        Element e = doc.createElement("queries");
        QueriesCollection queries = collection.getQueriesCollection();
        for (QueryShell query : queries) {
            Element q = doc.createElement("query");
            q.appendChild(createTextElement("name", "" + query.getQueryName()));
            q.appendChild(createTextElement("type", "" + query.getQueryType()));
            if (query.getQueryType().equalsIgnoreCase("sparql endpoint")) {
                SPARQLQueryShell sparql = (SPARQLQueryShell) query;
                q.appendChild(createTextElement("querystring", "" + sparql.getQueryString()));
                q.appendChild(createTextElement("address", "" + sparql.getServiceAddress()));
                q.appendChild(createTextElement("cidoc", "" + sparql.getCIDOCAddress()));
            }
            e.appendChild(q);
        }
        return e;
    }
    
    /**
     * Creates a node representing entities associated with the collection.
     * 
     * @return a node of the Entities.
     */
    private Element createEntities() {
        Element e = doc.createElement("entities");
        for (Entities entity : entities) {
            Element en = doc.createElement("entity");
            en.appendChild(createTextElement("identifier", "" + entity.getIdentifier()));
            en.appendChild(createTextElement("name", "" + entity.getName()));
            en.appendChild(createTextElement("query", "" + entity.getQueryName()));
            en.appendChild(createTextElement("source", "" + entity.getSourceName()));
            if (entity instanceof PhysicalThing) {
                PhysicalThing thing = (PhysicalThing) entity;
                en.appendChild(createTextElement("consists", "" + thing.getConsists()));
                en.appendChild(createTextElement("creator", "" + thing.getCreator()));
                en.appendChild(createTextElement("curatorial", "" + thing.getCuratorial()));
                en.appendChild(createTextElement("depicts", "" + thing.getDepicts()));
                en.appendChild(createTextElement("description", "" + thing.getDescription()));
                if (thing.getImageURL() != null) {
                    en.appendChild(createTextElement("image", "" + thing.getImageURL().toString()));
                }
                en.appendChild(createTextElement("object", "" + thing.getObject()));
                en.appendChild(createTextElement("technique", "" + thing.getTechnique()));
                en.appendChild(createTextElement("type", "" + thing.getType()));
                if (thing.getTimeSpan() != null) {
                    en.appendChild(createTextElement("year", "" + thing.getTimeSpan().toString()));
                }
            }
            e.appendChild(en);
        }
        return e;
    }
    
}