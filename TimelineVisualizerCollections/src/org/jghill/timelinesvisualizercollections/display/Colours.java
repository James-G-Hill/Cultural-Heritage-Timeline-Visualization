package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * An object for containing colours for the TimeLine.
 * 
 * @author JGHill
 */
public final class Colours {
    
    private static final List<Color> COLORS = new ArrayList<>();
    
    private static final Color PINK = new Color(255, 220, 220);
    private static final Color GREEN = new Color(220, 255, 220);
    private static final Color BLUE = new Color(220, 220, 255);
    private static final Color ORANGE = new Color(255, 230, 210);
    private static final Color PURPLE = new Color(255, 190, 255);
    private static final Color YELLOW = new Color(255, 255, 190);
    
    /**
     * A getter for the list of colours.
     * 
     * @return the list of colours.
     */
    public static List<Color> getColours() {
        COLORS.add(PINK);
        COLORS.add(GREEN);
        COLORS.add(BLUE);
        COLORS.add(ORANGE);
        COLORS.add(PURPLE);
        COLORS.add(YELLOW);
        return COLORS;
    }
    
}