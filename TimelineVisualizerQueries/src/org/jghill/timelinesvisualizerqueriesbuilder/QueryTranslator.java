package org.jghill.timelinesvisualizerqueriesbuilder;

import org.jghill.timelinevisualizerqueries.QueryShell;

/**
 * An interface to describe a tool for translating QuerySettings to Queries.
 * 
 * @author JGHill
 */
public interface QueryTranslator {
    
    public QueryShell translate(QuerySettings settings);
    
}