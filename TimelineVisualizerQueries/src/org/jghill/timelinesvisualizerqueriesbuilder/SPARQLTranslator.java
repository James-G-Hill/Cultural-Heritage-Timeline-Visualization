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
    private SPARQLEndpoint sparql;
    
    private static final String BMO = "bmo: <http://collection.britishmuseum.org/id/ontology/> \n";
    private static final String CRM = "crm: ";
    private static final String EDAN = "edan: <http://edan.si.edu/saam/id/ontologies/> \n";
    private static final String RDF = "rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n";
    private static final String SKOS = "skos: <http://www.w3.org/2004/02/skos/core#> \n";
    private static final String THES = "thes: <http://collection.britishmuseum.org/id/thesauri/> \n";
    private static final String XML = "xsd: <http://www.w3.org/2001/XMLSchema#> \n";
    
    private static final String PREFIX = "PREFIX ";
    private static final String SELECT = "SELECT ";
    private static final String WHERE = "WHERE { ";
    private static final String END = "} ";
    private static final String LIMIT = "LIMIT ";
    private static final String UNION = "UNION ";
    private static final String GROUP_BY = "GROUP BY ";
    
    private static final String OBJECT = "?object ";
    private static final String IDENTIFIER = "?identifier ";
    private static final String NAME = "?name ";
    private static final String DEPICTION = "?depicts ";
    private static final String CONSISTS = "?consists ";
    private static final String TYPE = "?type ";
    private static final String TECHNIQUE = "?technique ";
    private static final String IMAGE = "?image ";
    private static final String DATE = "?date ";
    
    private static final String DEPICTION_SAMPLE = "?depictsSample ";
    private static final String CONSISTS_SAMPLE = "?consistsSample ";
    private static final String TYPE_SAMPLE = "?typeSample ";
    private static final String TECHNIQUE_SAMPLE = "?techniqueSample ";
    private static final String DATE_SAMPLE = "?dateSample ";
    
    private static final String DESCRIPTION = "?description ";
    private static final String CURATORIAL = "?curatorial ";
    
    private static final String PRODUCTION = "?production ";
    private static final String TIME = "?time ";
    
    @Override
    public QueryShell translate(QuerySettings settings) {
        this.settings = settings;
        sparql = (SPARQLEndpoint) settings.source;
        return new SPARQLQueryShell(build(), sparql, settings.queryName);
    }
    
    private String build() {
        return
                prefix() + "\n\n" +
                select() + "\n\n" +
                WHERE + "\n\n" +
                whereClause() + "\n\n" +
                END + "\n\n" +
                groupby() + "\n\n" +
                limit();
    }
    
    /**
     * Builds the PREFIX part of the expression.
     */
    private String prefix() {
        return
                PREFIX + BMO +
                PREFIX + CRM + "<" + sparql.getCIDOCAddress() + "> \n" +
                PREFIX + EDAN +
                PREFIX + RDF +
                PREFIX + SKOS +
                PREFIX + THES +
                PREFIX + XML;
    }
    
    /**
     * Builds the SELECT part of the expression.
     */
    private String select() {
        return
                SELECT +
                IDENTIFIER + "\n" +
                NAME + "\n" +
                "(SAMPLE(" + DEPICTION + ") AS " + DEPICTION_SAMPLE + ") " + "\n" +
                "(SAMPLE(" + CONSISTS + ") AS " + CONSISTS_SAMPLE + ") " + "\n" +
                "(SAMPLE(" + TYPE + ") AS " + TYPE_SAMPLE + ") " + "\n" +
                "(SAMPLE(" + TECHNIQUE + ") AS " + TECHNIQUE_SAMPLE + ") " + "\n" +
                IMAGE +
                "(SAMPLE(" + DATE + ") AS " + DATE_SAMPLE + ") " + "\n" +
                DESCRIPTION + "\n" +
                CURATORIAL + "\n";
    }
    
    /**
     * Builds the where clause.
     */
    private String whereClause() {
        String where = "";
        where += getDates() + "\n";
        where += getIdentifier() + "\n";
        where += getName() + "\n";
        where += getDepiction() + "\n";
        where += getConsists() + "\n";
        where += getType() + "\n";
        where += getTechnique() + "\n";
        where += getDescription() + "\n";
        where += getCuration() + "\n";
        where += getImage();
        return where;
    }
    
    /**
     * The identifier of the object.
     */
    private String getIdentifier() {
        String query = "";
        String triple = OBJECT + "crm:P48_has_preferred_identifier/rdfs:label " + IDENTIFIER;
        query += "{ ";
        query += triple;
        query += " } . \n";
        if (settings.hasIdentifierCheck) {
            query += "FILTER (CONTAINS(LCASE(" + IDENTIFIER + "), \"" + settings.identifier + "\")). \n";
        }
        return query;
    }
    
    /**
     * The name of the object.
     */
    private String getName() {
        String query = "";
        String triple = "";
        triple += "{ " + OBJECT + "rdfs:label " + NAME + " } \n";
        triple += UNION;
        triple += "{ " + OBJECT + "crm:P102_has_title/rdfs:label " + NAME + " } \n";
        if (settings.hasNameCheck) {
            query += triple;
            query += ". \n";
            query += "FILTER (CONTAINS(LCASE(" + NAME + "), \"" + settings.name + "\")). \n"; 
        } else {
            query += "OPTIONAL { ";
            query += triple;
            query += " } . \n";
        }
        return query;
    }
    
    /**
     * The depiction of the object.
     */
    private String getDepiction() {
        String query = "";
        String triple = "";
        triple += "{ " + OBJECT + "crm:P62_depicts/skos:prefLabel " + DEPICTION + " } \n";
        triple += UNION;
        triple += "{ " + OBJECT + "crm:P129_is_about/edan:/skos:prefLabel " + DEPICTION + " } \n";
        if (settings.hasDepictionCheck) {
            query += triple;
            query += " . \n";
            query += "FILTER (CONTAINS(LCASE(" + DEPICTION + "), \"" + settings.depiction + "\")). \n";
        } else {
            query += "OPTIONAL { ";
            query += triple;
            query += " } . \n";
        }
        return query;
    }
    
    /**
     * The material of the object.
     */
    private String getConsists() {
        String query = "";
        String triple = "";
        triple += "{ " + OBJECT + "crm:P45_consists_of/skos:prefLabel " + CONSISTS + " } \n";
        triple += UNION;
        triple += "{ " + OBJECT + "edan:PE_medium_description " + CONSISTS + " } \n";
        if (settings.hasConsistsCheck) {
            query += triple;
            query += " . \n";
            query += "FILTER (CONTAINS(LCASE(" + CONSISTS + "), \"" + settings.consists + "\")). \n";
        } else {
            query += "OPTIONAL { ";
            query += triple;
            query += " } . \n";
        }
        return query;
    }
    
    /**
     * The type of the object.
     */
    private String getType() {
        String query = "";
        String triple = "";
        triple += "{ " + OBJECT + "bmo:PX_object_type/skos:prefLabel " + TYPE + " } \n";
        triple += UNION;
        triple += "{ " + OBJECT + "edan:PE_object_mainclass/skos:prefLabel " + TYPE + " } \n";
        if (settings.hasTypeCheck) {
            query += triple;
            query += " . \n";
            query += "FILTER (CONTAINS(LCASE(" + TYPE + "), \"" + settings.type + "\")). \n";
        } else {
            query += "OPTIONAL { ";
            query += triple;
            query += " } . \n";
        }
        return query;
    }
    
    /**
     * The technique that created the object.
     * 
     * @return the technique query part.
     */
    private String getTechnique() {
        String query = "";
        String triple = PRODUCTION + "crm:P9_consists_of [ crm:P32_used_general_technique [ skos:prefLabel " + TECHNIQUE + " ] ] ";
        if (settings.hasTechniqueCheck) {
            query += "{ ";
            query += triple;
            query += " } . \n";
            query += "FILTER (CONTAINS(LCASE(" + TECHNIQUE + "), \"" + settings.technique + "\")). \n";
        } else {
            query += "OPTIONAL { ";
            query += triple;
            query += " } . \n";
        }
        return query;
    }
    
    /**
     * Returns the image that represents this object.
     * 
     * @return the image url.
     */
    private String getImage() {
        String query = "";
        String triple = OBJECT + "crm:P138i_has_representation " + IMAGE;
        if (settings.hasImageCheck) {
            query += "{ ";
            query += triple;
            query += " } . \n";
        } else {
            query += "OPTIONAL { ";
            query += triple;
            query += " } . \n";
        }
        return query;
    }
    
    /**
     * Returns the dates.
     * 
     * @return the function for returning dates.
     */
    private String getDates() {
        String dates = "";
        
        dates += PRODUCTION + " a crm:E12_Production ";
        dates += "; crm:P108_has_produced " + OBJECT + " . \n";
        dates += "{ " + PRODUCTION + "crm:P9_consists_of [ crm:P4_has_time-span " + TIME + " ] } \n";
        dates += UNION;
        dates += "{ " + PRODUCTION + " crm:P4_has_time-span " + TIME + " } \n";
        dates += TIME + "a crm:E52_Time-Span ; rdfs:label " + DATE + " . \n";
        
        if (!settings.creationStartDate.equals("")) {
            dates += "FILTER (xsd:integer(" + DATE + ") >= " +
                    settings.creationStartDate + ") . \n";
        }
        
        if(!settings.creationEndDate.equals("")) {
            dates += "FILTER (xsd:integer(" + DATE + ") <= " +
                    settings.creationEndDate + ") . \n";
        }
        
        return dates;
    }
    
    /**
     * Line for obtaining an object description.
     * 
     * @return the object description request.
     */
    private String getDescription() {
        return "OPTIONAL { " + OBJECT + "bmo:PX_physical_description " + DESCRIPTION + "}. \n";
    }
    
    /**
     * Line for obtaining a curators comments.
     * 
     * @return the curatorial comment request.
     */
    private String getCuration() {
        return "OPTIONAL { " + OBJECT + "bmo:PX_curatorial_comment " + CURATORIAL + "}. \n";
    }
    
    /**
     * Groups the results by the identifier.
     * 
     * @return the groupby function.
     */
    private String groupby() {
        return GROUP_BY + " \n" +
                IDENTIFIER + " \n" +
                NAME  + " \n" +
                IMAGE + " \n" +
                DESCRIPTION  + " \n" +
                CURATORIAL;
    }
    
    /**
     * Builds the LIMIT part of expression.
     * 
     * @return the limit command.
     */
    private String limit() {
        return LIMIT + settings.limit;
    }
    
}