package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import static java.util.Comparator.comparingInt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JPanel;
import static org.jghill.timelinesvisualizercollections.display.CollectionDisplayUtilities.*;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A Panel for displaying the results.
 * 
 * @author JGHill
 */
public class CollectionDisplayPanel extends JPanel implements ChangeListener {
    
    private final static int INDENT = 0;
    
    private int SIZE;
    private final static int MIN_SIZE = 1000;
    private final static int MAX_SIZE = 10000;
    
    private JSlider zoom;
    
    private ManMadeObject[] collection;
    private TimeLine[] timelines;
    private int[] dateArray;
    
    private String filter;
    
    private Calendar earliest;
    private Calendar latest;
    
    private Calendar start;
    private Calendar end;
    
    private int interval;
    private int intervalsCount;
    
    private final Color pink = new Color(255, 220, 220);
    private final Color green = new Color(220, 255, 220);
    private final Color blue = new Color(220, 220, 255);
    private final Color orange = new Color(255, 230, 210);
    private final Color purple = new Color(255, 190, 255);
    private final Color yellow = new Color(255, 255, 190);
    
    private final List<Color> colors = new ArrayList<>();
    
    /**
     * The constructor.
     */
    public CollectionDisplayPanel() {
        setUp();
    }
    
    /**
     * Sets the initial settings when constructed.
     */
    private void setUp() {
        SIZE = MIN_SIZE;
        this.setLayout(null);
        colors.add(pink);
        colors.add(green);
        colors.add(blue);
        colors.add(orange);
        colors.add(purple);
        colors.add(yellow);
    }
    
    /**
     * Sets the slider for this object.
     * 
     * @param zoom the slider.
     */
    public void setSlider(JSlider zoom) {
        this.zoom = zoom;
        this.zoom.addChangeListener(this);
    }
    
    /**
     * Sets the Collection that this panel will display.
     * 
     * @param collection that will be displayed.
     * @return the TimeLine array produced by this method.
     */
    public TimeLine[] setArray(ManMadeObject[] collection, String filter) {
        this.filter = filter;
        clear();
        this.collection = collection;
        calculateTimePeriod();
        runFilter();
        revalidate();
        repaint();
        return timelines;
    }
    
    /**
     * Calculates the time period for this collection display panel.
     */
    private void calculateTimePeriod() {
        earliest = calculateEarliest(collection);
        latest = calculateLatest(collection);
        interval = calculateInterval(earliest, latest);
        start = getStart(earliest, interval);
        end = getEnd(latest, interval);
        intervalsCount = countIntervals(start, end, interval);
        dateArray = getArrayOfDates(start, interval, intervalsCount);
    }
    
    /**
     * Filters the results.
     */
    private void runFilter() {
        
        TreeMap<String, List<ManMadeObject>> categories = new TreeMap<>();
        
        for(ManMadeObject object: collection) {
            String result;
            switch(filter) {
                case "Query" :
                    result = object.getQueryName();
                    break;
                case "Source" :
                    result = object.getSourceName();
                    break;
                case "Material" :
                    result = object.getConsists();
                    break;
                case "Type" :
                    result = object.getType();
                    break;
                case "Technique" :
                    result = object.getTechnique();
                    break;
                case "None" :
                    result = "General";
                    break;
                default :
                    result = "";
                    break;
            }
            if (categories.containsKey(result)) {
                List<ManMadeObject> set = categories.get(result);
                set.add(object);
            } else {
                List<ManMadeObject> list = new ArrayList<>();
                list.add(object);
                categories.putIfAbsent(result, list);
            }
        }
        
        timelines = createTimeLineArray(categories);
        categories = sortCategories(categories);
        assignTimeLines(categories);
        
    }
    
    /**
     * Creates a TimeLine array based on the number of categories, capping the
     * number if it is over 4.
     * 
     * @param categories
     * @return an array of TimeLines.
     */
    private TimeLine[] createTimeLineArray(
            TreeMap<String, List<ManMadeObject>> categories
    ) {
        TimeLine[] timeline;
        int categoriesCount = categories.size();
        if (categoriesCount < 5) {
            timeline = new TimeLine[categoriesCount];
        } else {
            timeline = new TimeLine[4];
        }
        return timeline;
    }
    
    /**
     * Sorts the TimeLines by their length.
     * 
     * @param categories a list of categories.
     * @return a sorted TreeMap of categories.
     */
    private TreeMap<String, List<ManMadeObject>> sortCategories(
            TreeMap<String, List<ManMadeObject>> categories
    ) {
        Map<String, List<ManMadeObject>> sorted;
        sorted = categories.entrySet().stream()
                .sorted(comparingByValue(comparingInt(List::size)))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {throw new AssertionError();},
                        LinkedHashMap::new
                ));
        TreeMap<String, List<ManMadeObject>> objectTree;
        objectTree = new TreeMap<>(sorted);
        return objectTree;
    }
    
    /**
     * Creates all TimeLines from the passed categories.
     * 
     * @param categories that can be passed into TimeLines.
     */
    private void assignTimeLines(
            TreeMap<String, List<ManMadeObject>> categories
    ) {    
        int count = 0;
        Collections.shuffle(colors);
        ArrayList<ManMadeObject> other = new ArrayList<>();
        
        for(Map.Entry<String, List<ManMadeObject>> entry: categories.entrySet()) {
            if (count < 3) {
                timelines[count] = new TimeLine(
                        entry.getKey(),
                        entry.getValue().toArray(new ManMadeObject[entry.getValue().size()]),
                        colors.get(count),
                        this
                );
            } else {
                other.addAll(entry.getValue());
            }
            count++;
        }
        
        if (count >= 3 && !other.isEmpty()) {
            timelines[3] = new TimeLine(
                    "Other",
                    other.toArray(new ManMadeObject[other.size()]),
                    colors.get(3),
                    this
            );
        }
        
        for(TimeLine tm : timelines) {
            this.add(tm);
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintTimeLines();
        this.setPreferredSize(new Dimension(SIZE, timelines.length * 200));
        revalidate();
    }
    
    /**
     * Places the TimeLines onto the panel.
     */
    protected void paintTimeLines() {
        if (timelines != null) {
            int tlCount = 0;
            for(TimeLine tm : timelines) {
                tm.setBounds(
                        INDENT,
                        INDENT + (INDENT * tlCount) + (200 * tlCount),
                        this.getWidth() - (INDENT * 2),
                        200
                );
                tlCount++;
            }
        }
    }
    
    /**
     * @return the dateArray.
     */
    public int[] getDateArray() {
        return dateArray;
    }
    
    /**
     * @return start.
     */
    public Integer returnStart() {
        if (start != null) {
            return start.get(Calendar.YEAR);
        } else {
            return null;
        }
    }
    
    /**
     * @return end.
     */
    public Integer returnEnd() {
        if (end != null) {
            return end.get(Calendar.YEAR);
        } else {
            return null;
        }
    }
    
    /**
     * Clears this panel.
     */
    public void clear() {
        this.collection = null;
        this.dateArray = null;
        this.removeAll();
        timelines = null;
        this.revalidate();
        this.repaint();
    }
    
    /**
     * Returns the man made objects associated with the given name.
     * 
     * @param timelineName the name of the TimeLine to return objects from.
     * @return the objects associated with the TimeLine.
     */
    public ManMadeObject[] getTimeLine(String timelineName) {
        ManMadeObject[] objects = null;
        for (TimeLine timeline : timelines) {
            if (timeline.getName().equalsIgnoreCase(timelineName)) {
                objects = timeline.getEntities();
            }
        }
        return objects;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (source.getValueIsAdjusting()) {
            int val = source.getValue() * 10;
            if (val >= MIN_SIZE && val <= MAX_SIZE) {
                SIZE = val;
                calculateTimePeriod();
                repaint();
            }
        }
    }
    
}