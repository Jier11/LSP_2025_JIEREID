package org.howard.edu.lsp.midterm.question5;

/**
 * Driver for streamable.java
 */
public class StreamingServiceDriver {
    public static void main(String[] args) {
        Streamable music = new Music("Still a Friend - Incognito");
        Streamable movie = new Movie("Avengers End Game");
        Streamable audiobook = new Audiobook("A Promised Land – Barack Obama");
        System.out.println("Testing common behaviors for all media types:\n");
        System.out.println("Testing Music:");
        music.play();
        music.pause();
        music.stop();
        System.out.println();
        System.out.println("Testing Movie:");
        movie.play();
        movie.pause();
        movie.stop();
        System.out.println();
        System.out.println("Testing Audiobook:");
        audiobook.play();
        audiobook.pause();
        audiobook.stop();
        System.out.println();
        ((Movie) movie).rewind(30);
        System.out.println();
        ((Audiobook) audiobook).setPlaybackSpeed(1.5);
        System.out.println();
        ((Music) music).addToPlaylist("Favorites");
        System.out.println();
    }
}
