package org.jghill.timelinesvisualizerqueriesbuilder;

import org.jghill.timelinevisualizerqueries.QueryShell;
import org.jghill.timelinevisualizerqueries.SPARQLQueryShell;
import org.jghill.timelinevisualizersources.SPARQLEndpoint;

/**
 * An implementation of QueryTranslator for SPARQL queries.
 * 
 * @author JGHill
 */
public class SPARQLTranslator implements QueryTranslator {

    private QuerySettings settings;
    
    private static final String BMO = "bmo: <http://collection.britishmuseum.org/id/ontology/> ";
    private static final String CRM = "crm: <http://www.cidoc-crm.org/cidoc-crm/> ";
    private static final String RDF = "rdfs: <http://www.w3.org/2000/01/rdf-schema#> ";
    private static final String XML = "xsd: <http://www.w3.org/2001/XMLSchema#> ";
    
    private static final String PREFIX = "PREFIX ";
    private static final String SELECTDISTINCT = "SELECT DISTINCT ";
    private static final String WHERE = "WHERE { ";
    private static final String END = "} ";
    private static final String LIMIT = "LIMIT ";
    
    private static final String OBJECT = "?object ";
    private static final String IDENTIFIER = "?identifier ";
    private static final String TITLE = "?title ";
    private static final String IMAGE = "?image ";
    private static final String KEEPER = "?keeper ";
    private static final String DESCRIPTION = "?description ";
    private static final String BEGIN = "?begin ";
    private static final String FINISH = "?finish ";
    private static final String PRODUCTION = "?production ";
    private static final String TIME = "?time ";
    
    @Override
    public QueryShell translate(QuerySettings settings) {
        this.settings = settings;
        SPARQLEndpoint sparql = (SPARQLEndpoint) settings.theSource;
        String service =  sparql.getWebAddress();
        return new SPARQLQueryShell(build(), service, settings.name);
    }
    
    private String build() {
        return
                prefix() +
                select() +
                WHERE +
                whereClause() +
                END +
                limit();
    }
    
    /**
     * Builds the PREFIX part of the expression.
     */
    private String prefix() {
        return
                PREFIX + BMO +
                PREFIX + CRM +
                PREFIX + RDF +
                PREFIX + XML;
    }
    
    /**
     * Builds the SELECT part of the expression.
     */
    private String select() {
        return
                SELECTDISTINCT +
                IDENTIFIER +
                TITLE +
                IMAGE +
                BEGIN +
                FINISH;
    }
    
    /**
     * Builds the where clause.
     */
    private String whereClause() {
        String where = "";
        where += getIdentifier();
        where += getTitle();
//        where += getDescription();
//        where += getKeeper();
        where += getImage();
        where += getDates();
        return where;
    }
    
    /**
     * The identifier of the object.
     */
    private String getIdentifier() {
        return OBJECT + "crm:P48_has_preferred_identifier/rdfs:label " + IDENTIFIER + ". ";
    }
    
    /**
     * The name of the object.
     */
    private String getTitle() {
        return OBJECT + "crm:P102_has_title/rdfs:label " + TITLE + ". ";
    }
    
    /**
     * Line for obtaining an object description.
     */
    private String getDescription() {
        return OBJECT + "bmo:PX_physical_description " + DESCRIPTION + ". ";
    }
    
    /**
     * Line for obtaining the objects current keeper.
     */
    private String getKeeper() {
        return OBJECT + "crm:P50_has_current_keeper " + KEEPER + ". ";
    }
    
    /**
     * Returns the image address and note.
     */
    private String getImage() {
        String image = "";
        image += "OPTIONAL { " + OBJECT + "crm:P138i_has_representation " + IMAGE + " } . ";
        return image;
    }
    
    /**
     * Returns the dates.
     */
    private String getDates() {
        String dates = "";
        
        dates += PRODUCTION + " a crm:E12_Production ";
        dates += "; crm:P108_has_produced " + OBJECT + " ";
        dates += "; crm:P4_has_time-span " + TIME + ". ";
        
        dates += TIME + "crm:P79_beginning_is_qualified_by " + BEGIN + ". ";
        if (!settings.creationStartDate.equals("")) {
            dates += "FILTER (xsd:integer(" + BEGIN + ") >= " +
                    settings.creationStartDate + ") . ";
        }
        
        dates += TIME + "crm:P80_end_is_qualified_by " + FINISH + ". ";
        if(!settings.creationEndDate.equals("")) {
            dates += "FILTER (xsd:integer(" + FINISH + ") <= " +
                    settings.creationEndDate + ") . ";
        }
        
        return dates;
    }
    
    /**
     * Builds the LIMIT part of expression.
     */
    private String limit() {
        return LIMIT + settings.limit;
    }
    
}