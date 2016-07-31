package org.jghill.timelinevisualizerentities;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * An abstraction of a physical object for subclasses that represent real
 * objects.
 * 
 * @author JamesGHill
 */
public abstract class PhysicalThing extends Entities {
    
    private static final int MAX_DIMENSION = 100;
    private static final int YEAR_LENGTH = 4;
    
    private final Integer beginYear;
    private final Integer finalYear;
    
    private String creationDate;
    private String acquisitionDate;
    
    private String length;
    private String width;
    private String height;
    private String lengthUnit;
    private String widthUnit;
    private String heightUnit;
    
    private String consistsOf;
    private String physicalDescription;
    
    protected URL imageURL;
    protected String fileLocation;
    protected BufferedImage image;
    protected BufferedImage thumb;
    
    private String label;
    private String commentary;

    public PhysicalThing(
            String name,
            String identifier,
            String imageString,
            String beginYear,
            String finalYear
    ) {
        super(name, identifier);
        this.imageURL = createURL(imageString);
        this.beginYear = createYear(beginYear);
        this.finalYear = createYear(finalYear);
    }
    
    /**
     * Creates a URL from the returned String.
     * 
     * @param text the URL text from the query results.
     * @return a URL object.
     */
    private URL createURL(String text) {
        URL temp = null;
        try {
            if (!text.isEmpty()) {
                temp = new URL(text);
            }
        } catch(MalformedURLException ex) {
            temp = null;
        }
        return temp;
    }
    
    /**
     * Creates a year as int from a 4 character String or returns a -1.
     * 
     * @param yearText the String to be transformed.
     * @return the year or a -1.
     */
    private Integer createYear(String yearText) {
        if (yearStringIsInt(yearText)) {
            return Integer.parseInt(yearText);
        } else {
            return extractYearFromString(yearText);
        }
    }
    
    /**
     * Checks if a string is a year.
     * 
     * @param yearText the string to check.
     * @return true if the text can convert to a year.
     */
    private boolean yearStringIsInt(String yearText) {
        if (yearText.length() == 4) {
            for(int i = 0; i < yearText.length(); i++) {
               if (!Character.isDigit(yearText.charAt(i))) {
                   return false;
               }
            }
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Attempts to extract a 4-digit year from a String; otherwise returns a
     * null.
     * 
     * @param yearText the String to extract from.
     * @return an integer year.
     */
    private Integer extractYearFromString(String yearText) {
        int digitCount = 0;
        for(int i = 0; i < yearText.length(); i++) {
            if (Character.isDigit(yearText.charAt(i))) {
                digitCount++;
                if (digitCount == YEAR_LENGTH) {
                    int j = i + 1;
                    return Integer.parseInt(yearText.substring(j - digitCount, j));
                }
            } else {
                digitCount = 0;
            }
        }
        return null;
    }
    
    /**
     * Checks if the image has already been loaded.  If loaded return the image,
     * otherwise attempt to load the image then return it, otherwise return
     * null.
     * 
     * @return the Image related to this Thing or a null.
     */
    public BufferedImage getImage() {
        if (image == null) {
            if(imageURL == null) {
                return null;
            } else {
                try {
                    image = (BufferedImage) ImageIO.read(imageURL);
                    return image;
                } catch(IOException ex) {
                    return null;
                }
            }
        } else {
            return image;
        }
    }
    
    /**
     * Creates a thumbnail image from an existing image.
     * 
     * @return the thumbnail image.
     */
    public BufferedImage getThumb() {
        if (thumb == null) {
            if (image != null) {
            
                int x = image.getWidth();
                int y = image.getHeight();
                double ratio = ((double) x) / y;
                
                int w = MAX_DIMENSION;
                int h = MAX_DIMENSION;
                
                if(x > MAX_DIMENSION || y > MAX_DIMENSION) {
                    w = (int) Math.min(MAX_DIMENSION, ratio * MAX_DIMENSION);
                    h = (int) Math.min(MAX_DIMENSION, MAX_DIMENSION / ratio);
                }
                
                BufferedImage reSize;
                reSize = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = reSize.createGraphics();

                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2.drawImage(image, 0, 0, w, h, null);
                g2.dispose();

                thumb = reSize;
                
                return thumb;
            } else {
                return null;
            }
        } else {
            return thumb;
        }
    }
    
    public URL getImageURL() {
        return imageURL;
    }
    
    public int getTimeBegin() {
        return beginYear;
    }
    
    public int getTimeFinal() {
        return finalYear;
    }
    
}