package org.howard.edu.lsp.midterm.question5;

/**
 * Represents a music track with streamable functionalities.
 */
public class Music implements Streamable {
    private String title;
    
    /**
     * Constructs a Music object with the specified title.
     *
     * @param title title of track
     */
    public Music(String title) {
        this.title = title;
    }
    
    @Override
    public void play() {
        System.out.println("Playing music: " + title);
    }
    
    @Override
    public void pause() {
        System.out.println("Paused music: " + title);
    }
    
    @Override
    public void stop() {
        System.out.println("Stopped music: " + title);
    }
    
    /**
     * Adds track to playlist.
     *
     * @param playlistName name of  playlist
     */
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to " + playlistName + " playlist");
    }
}
