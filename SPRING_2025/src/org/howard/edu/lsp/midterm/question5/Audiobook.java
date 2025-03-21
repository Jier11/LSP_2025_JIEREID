package org.howard.edu.lsp.midterm.question5;

/**
 * Represents an audiobook with streamable functionalities.
 */
public class Audiobook implements Streamable {
    private String title;
    
    /**
     * Constructs an Audiobook object with the specified title.
     *
     * @param title title of audiobook
     */
    public Audiobook(String title) {
        this.title = title;
    }
    
    @Override
    public void play() {
        System.out.println("Playing audiobook: " + title);
    }
    
    @Override
    public void pause() {
        System.out.println("Paused audiobook: " + title);
    }
    
    @Override
    public void stop() {
        System.out.println("Stopped audiobook: " + title);
    }
    
    /**
     * Sets playback speed for audiobook.
     *
     * @param speed the playback speed 
     */
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + title + " " + speed + "x");
    }
}
