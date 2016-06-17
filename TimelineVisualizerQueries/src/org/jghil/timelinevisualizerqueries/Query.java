package org.jghil.timelinevisualizerqueries;

import java.util.Date;

/**
 * An abstract class representing generic queries.
 * 
 * @author JGHill
 */
public abstract class Query {
    
    private String queryName;
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
    
}