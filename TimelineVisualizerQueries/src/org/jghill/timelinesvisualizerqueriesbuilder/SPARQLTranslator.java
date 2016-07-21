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
    private static final String ECRM = "crm: <http://www.cidoc-crm.org/cidoc-crm/> ";
    
    private static final String PREFIX = "PREFIX ";
    private static final String SELECTDISTINCT = "SELECT DISTINCT ";
    private static final String WHERE = "WHERE { ";
    private static final String END = "} ";
    private static final String LIMIT = "LIMIT ";
    
    private static final String OBJECT = "?object ";
    private static final String IDENTIFIER = "?identifier ";
    private static final String TITLE = "?title ";
    private static final String IMAGE = "?image ";
    private static final String IMAGENOTE = "?imageNote ";
    private static final String KEEPER = "?keeper ";
    private static final String DESCRIPTION = "?description ";
    private static final String BEGIN = "?begin ";
    private static final String FINAL = "?final ";
    private static final String PRODUCTION = "?production ";
    private static final String CONSISTS = "?consists ";
    private static final String SPAN = "?span ";
    
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
                IDENTIFIER +
                TITLE +
                KEEPER;
//                DESCRIPTION +
//                BEGIN +
//                FINAL
    }
    
    /**
     * Builds the where clause.
     */
    private String whereClause() {
        String where = "";
        where += getIdentifier();
        where += getTitle();
//        where += getDescription();
        where += getKeeper();
//        where += getImage();
//        where += getDates();
        return where;
    }
    
    /**
     * The identifier of the object.
     */
    private String getIdentifier() {
        return OBJECT + "crm:P1_is_identified_by " + IDENTIFIER + ". ";
    }
    
    /**
     * The name of the object.
     */
    private String getTitle() {
        return OBJECT + "crm:P102_has_title " + TITLE + ". ";
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
        image += OBJECT + "bmo:PX_has_main_representation" + IMAGE + ". ";
        image += IMAGE + "crm:P3_has_note " + IMAGENOTE + ". ";
        return image;
    }
    
    /**
     * Returns the dates.
     */
    private String getDates() {
        String dates = "";
        dates += OBJECT + "crm:P108i_was_produced_by " + PRODUCTION + ". ";
        dates += PRODUCTION + "crm:P9_consists_of " + CONSISTS + ". ";
        dates += CONSISTS + "crm:P4_has_time-span " + SPAN + ". ";
        dates += SPAN + "crm:P82a_begin_of_the_begin " + BEGIN + ". ";
        dates += SPAN + "crm:P82b_end_of_the_end " + FINAL + ". ";
        return dates;
    }
    
    /**
     * Builds the LIMIT part of expression.
     */
    private String limit() {
        return LIMIT + settings.limit;
    }
    
}