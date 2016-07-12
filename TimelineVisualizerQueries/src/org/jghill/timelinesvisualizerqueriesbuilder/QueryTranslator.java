package org.jghill.timelinesvisualizerqueriesbuilder;

import org.jghill.timelinevisualizerqueries.Query;

/**
 * An interface to describe a tool for translating QuerySettings to Queries.
 * 
 * @author JGHill
 */
public interface QueryTranslator {
    
    public Query translate(QuerySettings settings);
    
}