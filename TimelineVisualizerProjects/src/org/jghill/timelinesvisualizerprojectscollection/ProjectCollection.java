package org.jghill.timelinesvisualizerprojectscollection;

import java.util.SortedSet;
import java.util.TreeSet;
import org.jghill.timelinesvisualizerprojects.Project;

/**
 * A collection for holding projects.
 * 
 * @author JGHill
 */
public class ProjectCollection {
    
    private final SortedSet<Project> collection;
    
    public ProjectCollection() {
        collection = new TreeSet<>();
    }
    
    /**
     * A method for adding projects to the collection.
     * 
     * @param proj the project to be added.
     */
    public void addProject(Project proj) {
        collection.add(proj);
    }
    
}