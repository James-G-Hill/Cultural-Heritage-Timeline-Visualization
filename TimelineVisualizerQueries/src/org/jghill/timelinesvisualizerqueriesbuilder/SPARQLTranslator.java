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
    
    private final String BMO = "bmo: <http://collection.britishmuseum.org/id/ontology/>";
    private final String ECRM = "ecrm: <http://erlangen-crm.org/current/> ";
    
    private final String PREFIX = "PREFIX ";
    private final String SELECTDISTINCT = "SELECT DISTINCT ";
    private final String WHERE = "WHERE { ";
    private final String END = "} ";
    private final String LIMIT = "LIMIT ";
    
    private final String OBJECT = "?object ";
    private final String IDENTIFIER = "?identifier ";
    private final String TITLE = "?title";
    private final String IMAGE = "?image ";
    private final String IMAGENOTE = "?imageNote ";
    private final String OWNER = "?owner ";
    private final String DESCRIPTION = "?description ";
    private final String BEGIN = "?begin ";
    private final String FINAL = "?final ";
    private final String PRODUCTION = "?production ";
    private final String CONSISTS = "?consists ";
    private final String SPAN = "?span ";
    
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
                PREFIX + ECRM;
    }
    
    /**
     * Builds the SELECT part of the expression.
     */
    private String select() {
        return
                SELECTDISTINCT +
                OBJECT +
                OWNER +
                DESCRIPTION +
                BEGIN +
                FINAL;
    }
    
    /**
     * Builds the where clause.
     */
    private String whereClause() {
        String where = "";
        where += getIdentifier();
        where += getTitle();
        where += getDescription();
        where += getOwner();
        where += getImage();
        where += getDates();
        return where;
    }
    
    /**
     * The identifier of the object.
     */
    private String getIdentifier() {
        return OBJECT + "ecrm:P1_is_identified_by" + IDENTIFIER + ". ";
    }
    
    /**
     * The name of the object.
     */
    private String getTitle() {
        return OBJECT + "ecrm:P102_has_title" + TITLE + ". ";
    }
    
    /**
     * Line for obtaining an object description.
     */
    private String getDescription() {
        return OBJECT + "bmo:PX_physical_description " + DESCRIPTION + ". ";
    }
    
    /**
     * Line for obtaining the objects current owner.
     */
    private String getOwner() {
        return OBJECT + "ecrm:P52_has_current_owner " + OWNER + ". ";
    }
    
    /**
     * Returns the image address and note.
     */
    private String getImage() {
        String image = "";
        image += OBJECT + "bmo:PX_has_main_representation" + IMAGE + ". ";
        image += IMAGE + "ecrm:P3_has_note " + IMAGENOTE + ". ";
        return image;
    }
    
    /**
     * Returns the dates.
     */
    private String getDates() {
        String dates = "";
        dates += OBJECT + "ecrm:P108i_was_produced_by " + PRODUCTION + ". ";
        dates += PRODUCTION + "ecrm:P9_consists_of " + CONSISTS + ". ";
        dates += CONSISTS + "ecrm:P4_has_time-span " + SPAN + ". ";
        dates += SPAN + "ecrm:P82a_begin_of_the_begin " + BEGIN + ". ";
        dates += SPAN + "ecrm:P82b_end_of_the_end " + FINAL + ". ";
        return dates;
    }
    
    /**
     * Builds the LIMIT part of expression.
     */
    private String limit() {
        return LIMIT + settings.limit;
    }
    
}