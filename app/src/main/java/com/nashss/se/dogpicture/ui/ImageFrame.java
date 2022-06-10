
package com.nashss.se.dogpicture.ui;

import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;

/**
 * A JFrame that will contain the image component
 */
public class ImageFrame extends JFrame {
    /**
     * Create a new ImageFrame that will display the image specified by the given url
     * NOTE: Internally, this class delegates displaying the image to an ImageComponent
     * @param imageUrl The URL that points to the image to display
     * @throws IOException
     */
    public ImageFrame(URL imageUrl) throws IOException {
        ImageComponent component = new ImageComponent(imageUrl);

        setSize(component.getWidth(), component.getHeight());
        setTitle("A Dog");

        add(component);
        getContentPane().validate();
        getContentPane().repaint();
    }
}