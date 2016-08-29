package org.jghill.timelinevisualizersourcesxml;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.jghill.timelinevisualizersources.SPARQLEndpoint;
import org.jghill.timelinevisualizersources.Source;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * An implementation of the Source Manager XML parser.
 * 
 * @author JGHill
 */
public class SourceManagerXMLParserImpl implements SourceManagerXMLParser {
    
    private final Document doc;
    private final DocumentBuilder builder;
    private final XPath path;
    
    /**
     * The Constructor.
     * 
     * @param f the file name.
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException 
     */
    public SourceManagerXMLParserImpl(File f) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        doc = builder.parse(f);
        XPathFactory xFactory = XPathFactory.newInstance();
        path = xFactory.newXPath();
    }
    
    @Override
    public List<Source> parseSources() throws XPathExpressionException {
        List<Source> sources = new LinkedList<>();
        int sourcesCount;
        sourcesCount = Integer.parseInt(
                path.evaluate("count(/manager/source)", doc)
        );
        for (int i = 1; i <= sourcesCount; i++) {
            String type = path.evaluate("/manager/source[" + i + "]/type", doc);
            if (type.equalsIgnoreCase("SPARQL Endpoint")) {
                String name = path.evaluate("/manager/source[" + i + "]/name", doc);
                String uri = path.evaluate("/manager/source[" + i + "]/uri", doc);
                String cidoc = path.evaluate("/manager/source[" + i + "]/cidoc", doc);
                Source s = new SPARQLEndpoint(
                        name,
                        uri,
                        cidoc
                );
                sources.add(s);
            }
            
        }
        return sources;
    }
    
}