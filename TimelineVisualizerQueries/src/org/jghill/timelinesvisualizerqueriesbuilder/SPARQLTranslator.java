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
    
    private static final String NAME_SAMPLE = "?nameSample ";
    private static final String DEPICTION_SAMPLE = "?depictsSample ";
    private static final String CONSISTS_SAMPLE = "?consistsSample ";
    private static final String TYPE_SAMPLE = "?typeSample ";
    private static final String TECHNIQUE_SAMPLE = "?techniqueSample ";
    private static final String IMAGE_SAMPLE = "?imageSample ";
    private static final String DATE_SAMPLE = "?dateSample ";
    
    private static final String DESCRIPTION = "?description ";
    private static final String DESCRIPTION_SAMPLE = "?descriptionSample ";
    private static final String CURATORIAL = "?curatorial ";
    private static final String CURATORIAL_SAMPLE = "?curatorialSample ";
    
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
                IDENTIFIER +
                "(SAMPLE(" + NAME + ") AS " + NAME_SAMPLE + ") " +
                "(SAMPLE(" + DEPICTION + ") AS " + DEPICTION_SAMPLE + ") " +
                "(SAMPLE(" + CONSISTS + ") AS " + CONSISTS_SAMPLE + ") " +
                "(SAMPLE(" + TYPE + ") AS " + TYPE_SAMPLE + ") " +
                "(SAMPLE(" + TECHNIQUE + ") AS " + TECHNIQUE_SAMPLE + ") " +
                "(SAMPLE(" + IMAGE + ") AS " + IMAGE_SAMPLE + ") " +
                "(SAMPLE(" + DATE + ") AS " + DATE_SAMPLE + ") " +
                "(SAMPLE(" + DESCRIPTION + ") AS " + DESCRIPTION_SAMPLE + ") " +
                "(SAMPLE(" + CURATORIAL + ") AS " + CURATORIAL_SAMPLE + ") ";
    }
    
    /**
     * Builds the where clause.
     */
    private String whereClause() {
        String where = "";
        where += getDates();
        where += getIdentifier();
        where += getName();
        where += getDepiction();
        where += getConsists();
        where += getType();
        where += getTechnique();
        where += getDescription();
        where += getCuration();
        where += getImage();
        return where;
    }
    
    /**
     * The name of the object.
     */
    private String getName() {
        String query = "";
        String triple = OBJECT + "rdfs:label " + NAME;
        if (settings.hasNameCheck) {
            query += triple;
            query += ". \n";
            query += "FILTER (CONTAINS(LCASE(?name), \"" + settings.name + "\")). \n"; 
        } else {
            query += "OPTIONAL { ";
            query += triple;
            query += " }. \n";
        }
        return query;
    }
    
    /**
     * The identifier of the object.
     */
    private String getIdentifier() {
        String query = "";
        String triple = OBJECT + "crm:P48_has_preferred_identifier/rdfs:label " + IDENTIFIER;
        if (settings.hasIdentifierCheck) {
            query += triple;
            query += ". \n";
            query += "FILTER (CONTAINS(LCASE(" + IDENTIFIER + "), \"" + settings.identifier + "\")). \n";
        } else {
            query += "OPTIONAL { ";
            query += triple;
            query += " }. \n";
        }
        return query;
    }
    
    /**
     * The depiction of the object.
     */
    private String getDepiction() {
        String query = "";
        String triple = OBJECT + "crm:P62_depicts/skos:prefLabel " + DEPICTION;
        if (settings.hasDepictionCheck) {
            query += triple;
            query += ". \n";
            query += "FILTER (CONTAINS(LCASE(" + DEPICTION + "), \"" + settings.depiction + "\")). \n";
        } else {
            query += "OPTIONAL { ";
            query += triple;
            query += " }. \n";
        }
        return query;
    }
    
    /**
     * The material of the object.
     */
    private String getConsists() {
        String query = "";
        String triple = OBJECT + "crm:P45_consists_of/skos:prefLabel " + CONSISTS;
        if (settings.hasConsistsCheck) {
            query += triple;
            query += ". \n";
            query += "FILTER (CONTAINS(LCASE(" + CONSISTS + "), \"" + settings.consists + "\")). \n";
        } else {
            query += "OPTIONAL { ";
            query += triple;
            query += " }. \n";
        }
        return query;
    }
    
    /**
     * The type of the object.
     */
    private String getType() {
        String query = "";
        String triple = OBJECT + "bmo:PX_object_type/skos:prefLabel " + TYPE;
        if (settings.hasTypeCheck) {
            query += triple;
            query += ". \n";
            query += "FILTER (CONTAINS(LCASE(" + TYPE + "), \"" + settings.type + "\")). \n";
        } else {
            query += "OPTIONAL { ";
            query += triple;
            query += " }. \n";
        }
        return query;
    }
    
    /**
     * The technique that created the object.
     */
    private String getTechnique() {
        String query = "";
        String triple = "{ " + PRODUCTION + "crm:P9_consists_of [ crm:P32_used_general_technique/skos:prefLabel " + TECHNIQUE + " ] } \n";
        if (settings.hasTechniqueCheck) {
            query += triple;
            query += ". \n";
            query += "FILTER (CONTAINS(LCASE(" + TECHNIQUE + "), \"" + settings.technique + "\")). \n";
        } else {
            query += "OPTIONAL { ";
            query += triple;
            query += " }. \n";
        }
        return query;
    }
    
    /**
     * Returns the image address and note.
     */
    private String getImage() {
        String image = "";
        image += "OPTIONAL { " + OBJECT + "crm:P138i_has_representation " + IMAGE + " } . \n";
        return image;
    }
    
    /**
     * Returns the dates.
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
     */
    private String getDescription() {
        return "OPTIONAL { " + OBJECT + "bmo:PX_physical_description " + DESCRIPTION + "}. \n";
    }
    
    /**
     * Line for obtaining a curators comments.
     */
    private String getCuration() {
        return "OPTIONAL { " + OBJECT + "bmo:PX_curatorial_comment " + CURATORIAL + "}. \n";
    }
    
    /**
     * Groups the results by the identifier.
     * 
     * @return a string for the group by function.
     */
    private String groupby() {
        return GROUP_BY + IDENTIFIER;
    }
    
    /**
     * Builds the LIMIT part of expression.
     */
    private String limit() {
        return LIMIT + settings.limit + "\n";
    }
    
}