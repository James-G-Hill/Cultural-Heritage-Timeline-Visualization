package org.jghill.timelinevisualizerqueries;

import java.util.Date;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;

/**
 * An abstract class representing generic queries.
 * 
 * @author JGHill
 */
public abstract class QueryShell {
    
    private String queryName = "Untitled";
    private Date lastRunDate;
    
    public String getQueryName() {
        return queryName;
    }
    
    public void setQueryName(String name) {
        queryName = name;
    }
    
    public Date getLastRunDate() {
        return lastRunDate;
    }
    
    public void setLastRunDate(Date lastRun) {
        lastRunDate = lastRun;
    }
    
    /**
     * An abstract query to be filled by the actual code for sending &
     * capturing the data.
     * 
     * @return the collection of entities from a query.
     */
    abstract public EntitiesCollection run();
    
}