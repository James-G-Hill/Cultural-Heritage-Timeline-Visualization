package org.jghill.timelinesvisualizerqueriesbuilder;

import org.jghill.timelinevisualizerqueries.Query;
import org.jghill.timelinevisualizerqueries.SPARQLQuery;

/**
 * An implementation of QueryTranslator for SPARQL queries.
 * 
 * @author JGHill
 */
public class SPARQLTranslator implements QueryTranslator {

    private QuerySettings settings;
    
    private final String SELECTDISTINCT = "SELECT DISTINCT ";
    private final String WHERE = "WHERE { ";
    private final String END = "} ";
    private final String LIMIT = "LIMIT ";
    
    private final String OBJECT = "?object ";
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
    public Query translate(QuerySettings settings) {
        this.settings = settings;
        Query query = new SPARQLQuery(build(), settings.name);
        return query;
    }
    
    private String build() {
        return
                select() +
                WHERE +
                whereClause() +
                END +
                limit();
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
        where += getDescription();
        where += getOwner();
        where += getDates();
        return where;
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
        dates += SPAN + "ecrm:P82b_end_of_the_end " + END + ". ";
        return dates;
    }
    
    /**
     * Builds the LIMIT part of expression.
     */
    private String limit() {
        return LIMIT + settings.limit;
    }
    
}