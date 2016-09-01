package org.jghill.timelinevisualizersourcesxml;

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
import org.jghill.timelinevisualizersources.SPARQLEndpoint;
import org.jghill.timelinevisualizersources.Source;
import org.jghill.timelinevisualizersources.SourceCollection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * An implementation of the Source Manager XML writer.
 * 
 * @author JGHill
 */
public class SourceManagerXMLWriterImpl implements SourceManagerXMLWriter {
    
    final private DocumentBuilder builder;
    private Document doc;
    
    /**
     * Constructor.
     * 
     * @throws ParserConfigurationException 
     */
    public SourceManagerXMLWriterImpl() throws ParserConfigurationException {
        builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }
    
    @Override
    public void build() {
        doc = builder.newDocument();
        Element rootElement = doc.createElement("manager");
        doc.appendChild(rootElement);
        createSourceList(rootElement);
    }
    
    @Override
    public void print() {
        Transformer trans;
        try {
            trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source =  new DOMSource(doc);
            StreamResult file = new StreamResult(new File("release/Data/Source Manager/Source Manager.xml"));
            trans.transform(source, file);
        } catch (TransformerException ex) {}
    }
    
    /**
     * Loops through the list of sources assigning xml to the root element.
     * 
     * @param rootElement to assign sources to.
     */
    private void createSourceList(Element rootElement) {
        Source[] sources = SourceCollection.collectionToArray();
        for (Source source : sources) {
            rootElement.appendChild(createSource(source));
        }
    }
    
    /**
     * Creates an xml implementation of the source.
     * 
     * @param source to be transformed to xml.
     * @return the xml version of the source.
     */
    private Element createSource(Source source) {
        Element e = doc.createElement("source");
        e.appendChild(createTextElement("name", "" + source.getSourceName()));
        e.appendChild(createTextElement("type", "" + source.getSourceType()));
        if (source instanceof SPARQLEndpoint) {
            e.appendChild(createTextElement("uri", "" + ((SPARQLEndpoint) source).getWebAddress()));
            e.appendChild(createTextElement("cidoc", "" + ((SPARQLEndpoint) source).getCIDOCAddress()));
        }
        return e;
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
    
}