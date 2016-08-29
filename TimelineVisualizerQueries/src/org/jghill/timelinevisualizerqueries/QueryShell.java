package org.jghill.timelinevisualizerqueries;

import java.util.Date;
import org.jghill.timelinevisualizerentitiescollection.EntitiesCollection;

/**
 * An abstract class representing generic queries.
 * 
 * @author JGHill
 */
public abstract class QueryShell implements Comparable {
    
    private String queryName = "Untitled";
    private Date lastRunDate;
    
    /**
     * @return The type of the query.
     */
    public abstract String getQueryType();
    
    /**
     * Returns the name of the query.
     * 
     * @return the query name.
     */
    public String getQueryName() {
        return queryName;
    }
    
    /**
     * Sets the name of the query.
     * 
     * @param name of the query.
     */
    public void setQueryName(String name) {
        queryName = name;
    }
    
    /**
     * Returns the last run date.
     * 
     * @return the last run date.
     */
    public Date getLastRunDate() {
        return lastRunDate;
    }
    
    /**
     * Sets the last run date.
     * 
     * @param lastRun of the query.
     */
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
    
    @Override
    public int compareTo(Object o) {
        QueryShell query = (QueryShell) o;
        return queryName.compareTo(query.getQueryName());
    }
    
}