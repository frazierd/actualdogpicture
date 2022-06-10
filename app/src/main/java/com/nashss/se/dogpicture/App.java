package com.nashss.se.dogpicture;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.nashss.se.dogpicture.http.DogImageUrlFetcher;
import com.nashss.se.dogpicture.ui.ImageFrame;

/**
 * The starting point for the dogpicture application.
 */
public class App {
    public static void main(String[] args) {
        // The code passed into the invokeAndWait method will
        // produce a graphical user interface
        //
        // As you can see from all the exceptions,
        // a lot could go wrong in this code.

        try {
            SwingUtilities.invokeAndWait(() -> {
                try {
                    DogImageUrlFetcher fetcher = new DogImageUrlFetcher();
                    ImageFrame frame;
                    frame = new ImageFrame(fetcher.fetch());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                } catch (IOException | InterruptedException | ExecutionException e) {
                    System.err.println(String.format("ERROR: %s", e.getMessage()));
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException | InvocationTargetException e) {
            System.err.println(String.format("ERROR: %s", e.getMessage()));
            e.printStackTrace();
        }
    }
}