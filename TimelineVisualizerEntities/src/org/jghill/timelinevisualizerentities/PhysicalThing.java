package org.jghill.timelinevisualizerentities;

import java.awt.Image;
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
    
    private final String timeBegin;
    private final String timeFinal;
    
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
    
    private String label;
    private String commentary;

    public PhysicalThing(
            String name,
            String identifier,
            String image,
            String timeBegin,
            String timeFinal
    ) {
        super(name, identifier);
        this.imageURL = createURL(image);
        this.timeBegin = timeBegin;
        this.timeFinal = timeFinal;
    }
    
    /**
     * Creates a URL from the returned String.
     * 
     * @param text the URL text from the query results.
     * @return a URL object.
     */
    private URL createURL(String text) {
        URL temp;
        try {
            temp = new URL(text);
        } catch(MalformedURLException ex) {
            temp = null;
        }
        return temp;
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
                    image = ImageIO.read(imageURL);
                } catch(IOException ex) {
                    return null;
                }
                return image;
            }
        } else {
            return image;
        }
    }
    
    public String getTimeBegin() {
        return timeBegin;
    }
    
    public String getTimeFinal() {
        return timeFinal;
    }
}