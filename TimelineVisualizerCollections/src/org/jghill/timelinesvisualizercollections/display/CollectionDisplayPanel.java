package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.comparingInt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JPanel;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import javax.swing.JSlider;
import javax.swing.JViewport;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/**
 * A Panel for displaying the results.
 * 
 * @author JGHill
 */
public class CollectionDisplayPanel extends JPanel implements ChangeListener {
    
    private int size;
    private final static int MAX_SIZE = 10000;
    private final static int TIMELINE_HEIGHT = 200;
    
    private JSlider zoom;
    
    private ManMadeObject[] collection;
    private TimeLine[] timelines;
    private int[] dateArray;
    
    private int dateDifference;
    
    private String filter;
    
    private final List<Color> colors = Colours.getColours();
    private ScaleBuilder timeLineBuilder;
    
    private JViewport viewer;
    
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
        setLayout(null);
        timeLineBuilder = new ScaleBuilder();
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
     * @param filter the string to filter by.
     * @return the TimeLine array produced by this method.
     */
    public TimeLine[] setArray(
            ManMadeObject[] collection,
            String filter
    ) {
        clear();
        this.filter = filter;
        this.collection = collection;
        viewer = (JViewport) this.getParent();
        dateArray = timeLineBuilder.createScaleInfo(collection, 1);
        dateDifference = dateArray[dateArray.length-1] - dateArray[0];
        runFilter();
        revalidate();
        repaint();
        return timelines;
    }
    
    /**
     * Filters the results.
     */
    private void runFilter() {
        
        TreeMap<String, List<ManMadeObject>> categories = new TreeMap<>();
        
        for (ManMadeObject object: collection) {
            if (object.getTimeSpan() != null) {
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
        
        for (Map.Entry<String, List<ManMadeObject>> entry: categories.entrySet()) {
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
        
        for (TimeLine tm : timelines) {
            this.add(tm);
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (timelines != null) {
            if (size < viewer.getSize().width) {
                size = viewer.getSize().width;
            }
            modifyScaleZoom();
            paintTimeLines();
            changeSize();
        }
        revalidate();
    }
    
    /**
     * Places the TimeLines onto the panel.
     */
    protected void paintTimeLines() {
        int tlCount = 0;
        for (TimeLine tm : timelines) {
            tm.setBounds(
                    0,
                    tlCount + (TIMELINE_HEIGHT * tlCount),
                    size,
                    TIMELINE_HEIGHT
            );
            tlCount++;
        }
    }
    
    private boolean level1 = false;
    private boolean level2 = true;
    private boolean level3 = true;
    private boolean update;
    
    /**
     * Check the zoom level and modify the scale if necessary.
     */
    private void modifyScaleZoom() {
        int scale = size / viewer.getSize().width;
        if (scale <= 4 && !level1) {
            level1 = true;
            level2 = false;
            level3 = false;
            update = true;
            dateArray = timeLineBuilder.createScaleInfo(collection, 1);
        } else if (scale > 4 && scale <= 40 && !level2) {
            level1 = false;
            level2 = true;
            level3 = false;
            update = true;
            dateArray = timeLineBuilder.createScaleInfo(collection, 10);
        } else if (scale > 40 && !level3) {
            level1 = false;
            level2 = false;
            level3 = true;
            update = true;
            dateArray = timeLineBuilder.createScaleInfo(collection, 100);
        } else {
            update = false;
        }
    }
    
    public boolean getUpdate() {
        return update;
    }
  
    /**
     * Returns the array of dates associated with this display.
     * 
     * @return the dateArray.
     */
    public int[] getDateArray() {
        return dateArray;
    }
    
    /**
     * Clears this panel.
     */
    public void clear() {
        collection = null;
        dateArray = null;
        removeAll();
        timelines = null;
        revalidate();
        repaint();
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
    
    /**
     * Update the scaleZoom level when reacting to the slider changing.
     * 
     * @param e the event that's changed.
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        
        JSlider source = (JSlider) e.getSource();
        
        if (source.getValueIsAdjusting()) {
            
            int viewerWidth = viewer.getSize().width;
            int scaleZoom = viewerWidth + ((source.getValue() * viewerWidth) / 100);
            
            if (scaleZoom >= viewerWidth && scaleZoom <= MAX_SIZE + viewerWidth && dateDifference > 10) {
                
                int position = viewer.getViewPosition().x;
                int halfWidth = viewerWidth / 2;
                int oldCentre = position + halfWidth;
                double ratio = (double) scaleZoom / size;
                int newX = Math.max(0, (int) (Math.round(oldCentre * ratio) - halfWidth));
                size = scaleZoom;
                changeSize();
                
                viewer.setViewPosition(
                        new Point(
                                newX,
                                viewer.getViewPosition().y
                        )
                );
                
                repaint();
                
            }
            
        }
        
    }
    
    /**
     * Changes the size of this panel.
     */
    private void changeSize() {
        this.setPreferredSize(
                new Dimension(
                        size,
                        timelines.length * TIMELINE_HEIGHT
                )
        );
    }
    
}