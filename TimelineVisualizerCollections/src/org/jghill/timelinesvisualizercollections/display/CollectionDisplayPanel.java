package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Comparator.comparingInt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import static org.jghill.timelinesvisualizercollections.display.CollectionDisplayUtilities.*;
import org.jghill.timelinesvisualizercollections.gui.CollectionTopComponent;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/**
 * A Panel for displaying the results.
 * @author JGHill
 */
public class CollectionDisplayPanel extends JPanel implements ItemListener {
    
    private final static int INDENT = 10;
    
    private ManMadeObject[] collection;
    private TimeLine[] timelines;
    private int[] dateArray;
    
    private CollectionTopComponent tc;
    private JComboBox<String> firstFilter;
    
    private Calendar earliest;
    private Calendar latest;
    
    private Calendar start;
    private Calendar end;
    
    private int interval;
    private int intervalsCount;
    
    private final Color[] colors = {Color.magenta, Color.orange, Color.pink, Color.lightGray};
    
    public CollectionDisplayPanel() {
        setUp();
    }
    
    /**
     * Sets the initial settings when constructed.
     */
    private void setUp() {
        this.setLayout(null);
//        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
    
    /**
     * Sets the Collection that this panel will display.
     * @param collection that will be displayed.
     */
    public void setArray(ManMadeObject[] collection) {
        tc = (CollectionTopComponent) this.getParent().getParent().getParent();
        firstFilter = tc.getFirstFilter();
        clear();
        this.collection = collection;
        calculateTimePeriod();
        createTimeLines();
        
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
     * Creates all timelines for this collection display panel.
     */
    private void createTimeLines() {
        String choice = (String) firstFilter.getSelectedItem();
        if (choice.equalsIgnoreCase("None")) {
            noFilter();
        } else {
            runFilter(choice);
        }
        revalidate();
        repaint();
    }
    
    /**
     * Creates timeline when there is no filter selected.
     */
    private void noFilter() {
        TimeLine tm = new TimeLine("General", collection, Color.RED, this);
        timelines = new TimeLine[1];
        timelines[0] = tm;
        this.add(timelines[0]);
    }
    
    private void runFilter(String filter) {
        
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
     * @param categories
     * @return an array of TimeLines.
     */
    private TimeLine[] createTimeLineArray(TreeMap<String, List<ManMadeObject>> categories) {
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
     * @param categories a list of categories.
     * @return a sorted TreeMap of categories.
     */
    private TreeMap<String, List<ManMadeObject>> sortCategories(TreeMap<String, List<ManMadeObject>> categories) {
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
     * @param categories that can be passed into TimeLines.
     */
    private void assignTimeLines(TreeMap<String, List<ManMadeObject>> categories) {
        int count = 0;
        ArrayList<ManMadeObject> other = new ArrayList<>();
        for(Map.Entry<String, List<ManMadeObject>> entry: categories.entrySet()) {
            if (count < 3) {
                timelines[count] = new TimeLine(
                        entry.getKey(),
                        entry.getValue().toArray(new ManMadeObject[entry.getValue().size()]),
                        colors[count],
                        this
                );
            } else {
                other.addAll(entry.getValue());
            }
            count++;
        }
        if (count > 2) {
            timelines[3] = new TimeLine(
                    "Other",
                    (ManMadeObject[]) other.toArray(),
                    colors[3],
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
    }
    
    /**
     * Places the TimeLines onto the panel.
     */
    protected void paintTimeLines() {
        if (timelines != null) {
            int tlCount = 0;
            for(TimeLine tm : timelines) {
                tm.setBounds(INDENT, INDENT + (INDENT * tlCount) + (200 * tlCount), this.getWidth() - (INDENT * 2), 200);
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
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            this.removeAll();
            timelines = null;
            createTimeLines();
        }
    }
    
}