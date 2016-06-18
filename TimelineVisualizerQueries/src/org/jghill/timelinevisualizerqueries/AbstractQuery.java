package org.jghill.timelinevisualizerqueries;

import java.util.Date;

/**
 * An abstract class representing generic queries.
 * 
 * @author JGHill
 */
public abstract class AbstractQuery {
    
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
    
}