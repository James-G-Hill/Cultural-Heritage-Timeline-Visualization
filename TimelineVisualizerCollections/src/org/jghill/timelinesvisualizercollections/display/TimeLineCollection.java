package org.jghill.timelinesvisualizercollections.display;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Comparator.comparingInt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jghill.timelinevisualizerentities.ManMadeObject;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/**
 * Filters a collection of objects to a set of TimeLines.
 * 
 * @author JGHill
 */
public class TimeLineCollection {
    
    private final String none = "None";
    private final String query = "Query";
    private final String source = "Source";
    private final String depicts = "Depicts";
    private final String material = "Material";
    private final String type = "Type";
    private final String technique = "Technique";
    private final String creator = "Creator";
    
    private final int MAX_CATEGORIES = 4;
    
    private final List<Color> colors = Colours.getColours();
    private final CollectionDisplayPanel cdp;
    
    private TimeLine[] timeLines;
    
    private final TreeMap<String, List<String>> filters;
    private List<String> filterList;
    
    /**
     * Constructor.
     */
    public TimeLineCollection(CollectionDisplayPanel cdp) {
        this.cdp = cdp;
        filters = new TreeMap<>();
    }
    
    /**
     * 
     * @param collection 
     */
    public void createFilters(ManMadeObject[] collection) {
        
        createInitialFilter();
        for (ManMadeObject object: collection) {
            if (object.getTimeSpan() != null) {
                if (!filters.get(query).contains(object.getQueryName())) {
                    filters.get(query).add(object.getQueryName());
                }
                if (!filters.get(source).contains(object.getSourceName())) {
                    filters.get(source).add(object.getSourceName());
                }
                if (!filters.get(depicts).contains(object.getDepicts())) {
                    filters.get(depicts).add(object.getDepicts());
                }
                if (!filters.get(material).contains(object.getConsists())) {
                    filters.get(material).add(object.getConsists());
                }
                if (!filters.get(type).contains(object.getType())) {
                    filters.get(type).add(object.getType());
                }
                if (!filters.get(technique).contains(object.getTechnique())) {
                    filters.get(technique).add(object.getTechnique());
                }
                if (!filters.get(creator).contains(object.getCreator())) {
                    filters.get(creator).add(object.getCreator());
                }
            }
        }
        
        filterList = new ArrayList<>();
        filterList.add(none);
        filters.forEach((k,v)->{
            if (v.size() > 1) {
                filterList.add(k);
            }
        });
        
    }
    
    
    /**
     * Create TimeLines from a set of objects.
     * 
     * @param collection of objects.
     * @return an array of TimeLines.
     */
    public void createTimeLines(
            ManMadeObject[] collection,
            String filter
    ) {
        Collections.shuffle(colors);
        runFilter(collection, filter);
    }
    
    /**
     * Filters the results.
     */
    private void runFilter(
            ManMadeObject[] collection,
            String filter
    ) {
        TreeMap<String, List<ManMadeObject>> categories = new TreeMap<>();
        
        for (ManMadeObject object: collection) {
            if (object.getTimeSpan() != null) {
                String result;
                switch(filter) {
                    case query :
                        result = object.getQueryName();
                        break;
                    case source :
                        result = object.getSourceName();
                        break;
                    case depicts :
                        result = object.getDepicts();
                        break;
                    case material :
                        result = object.getConsists();
                        break;
                    case type :
                        result = object.getType();
                        break;
                    case technique :
                        result = object.getTechnique();
                        break;
                    case creator :
                        result = object.getCreator();
                        break;
                    case none :
                        result = "General";
                        break;
                    default :
                        result = "General";
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
        
        timeLines = createTimeLineArray(categories);
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
        if (categoriesCount <= MAX_CATEGORIES) {
            timeline = new TimeLine[categoriesCount];
        } else {
            timeline = new TimeLine[MAX_CATEGORIES];
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
        ArrayList<ManMadeObject> other = new ArrayList<>();
        
        for (Map.Entry<String, List<ManMadeObject>> entry: categories.entrySet()) {
            if (count < MAX_CATEGORIES - 1) {
                timeLines[count] = new TimeLine(
                        entry.getKey(),
                        entry.getValue().toArray(new ManMadeObject[entry.getValue().size()]),
                        colors.get(count),
                        cdp
                );
            } else {
                other.addAll(entry.getValue());
            }
            count++;
        }
        
        if (count >= (MAX_CATEGORIES - 1) && !other.isEmpty()) {
            timeLines[MAX_CATEGORIES - 1] = new TimeLine(
                    "Other",
                    other.toArray(new ManMadeObject[other.size()]),
                    colors.get(MAX_CATEGORIES - 1),
                    cdp
            );
        }
        
    }
    
    /**
     * Returns the man made objects associated with the given name.
     * 
     * @param timelineName the name of the TimeLine to return objects from.
     * @return the objects associated with the TimeLine.
     */
    public ManMadeObject[] getTimeLineObjects(String timelineName) {
        ManMadeObject[] objects = null;
        if (timelineName.equalsIgnoreCase("None")) {
            objects = getAllTimeLineObjects();
        } else {
            for (TimeLine timeline : timeLines) {
                if (timeline.getName().equalsIgnoreCase(timelineName)) {
                    objects = timeline.getEntities();
                }
            }
        }
        return objects;
    }
    
    /**
     * Returns the man made objects associated with the given name.
     * 
     * @param timelineName the name of the TimeLine to return objects from.
     * @return the objects associated with the TimeLine.
     */
    public ManMadeObject[] getAllTimeLineObjects() {
        List<ManMadeObject> objectList = new ArrayList<>();
        for (TimeLine timeline : timeLines) {
            objectList.addAll(Arrays.asList(timeline.getEntities()));
        }
        return objectList.toArray(new ManMadeObject[0]);
    }
    
    /**
     * Return an array of the TimeLines.
     * 
     * @return an array of TimeLines.
     */
    public TimeLine[] getTimeLines() {
        return timeLines;
    }
    
    /**
     * Returns an array of names of the TimeLines.
     * 
     * @return the names of the TimeLines.
     */
    private String[] getTimeLinesNames() {
        String[] timeLineNames;
        timeLineNames = new String[timeLines.length + 1];
        timeLineNames[0] = "None";
        for (int i = 1; i < timeLineNames.length; i++) {
            timeLineNames[i] = timeLines[i-1].getName();
        }
        return timeLineNames;
    }
    
    /**
     * Get a count of the timeLines in this collection.
     * 
     * @return a count of TimeLines.
     */
    public int getCount() {
        return timeLines.length;
    }
    
    /**
     * Returns the comboBox model for the filters.
     * 
     * @return the comboBox model.
     */
    public ComboBoxModel getFilterComboBoxModel() {
        return new DefaultComboBoxModel(filterList.toArray());
    }
    
    /**
     * Returns the comboBox model for the parameters.
     * 
     * @return the comboBox model.
     */
    public ComboBoxModel getCategoryComboBoxModel() {
        return new DefaultComboBoxModel(getTimeLinesNames());
    }
    
    /**
     * Clears the filter.
     */
    private void createInitialFilter() {
        filters.clear();
        filters.put(none, new ArrayList<>());
        filters.put(query, new ArrayList<>());
        filters.put(source, new ArrayList<>());
        filters.put(depicts, new ArrayList<>());
        filters.put(material, new ArrayList<>());
        filters.put(type, new ArrayList<>());
        filters.put(technique, new ArrayList<>());
        filters.put(creator, new ArrayList<>());
    }
    
}