package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * An object for containing colours for the TimeLine.
 * 
 * @author JGHill
 */
public class Colours {
    
    private final List<Color> colors = new ArrayList<>();
    
    private final Color pink = new Color(255, 220, 220);
    private final Color green = new Color(220, 255, 220);
    private final Color blue = new Color(220, 220, 255);
    private final Color orange = new Color(255, 230, 210);
    private final Color purple = new Color(255, 190, 255);
    private final Color yellow = new Color(255, 255, 190);
    
    /**
     * Constructor.
     */
    public void Colours() {
        colors.add(pink);
        colors.add(green);
        colors.add(blue);
        colors.add(orange);
        colors.add(purple);
        colors.add(yellow);
    }
    
    /**
     * A getter for the list of colours.
     * 
     * @return the list of colours.
     */
    public List<Color> getColours() {
        return colors;
    }
    
}