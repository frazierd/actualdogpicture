package com.nashss.se.dogpicture.ui;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * A JComponent that will download and display an image at a given URL
 */
public class ImageComponent extends JComponent {
    private BufferedImage image;

    /**
     * Create a new instance of ImageComponent that will display the image
     *   downloaded from the given URL
     * NOTE: The image is downloaded within this constructor
     * @param imageUrl This URL of the image to download and display
     * @throws IOException
     */
    public ImageComponent(URL imageUrl) throws IOException {
        try (InputStream in = imageUrl.openStream()) {
            image = ImageIO.read(in);
        }
    }

    /**
     * This method will be called by swing when it's ready to display the image.
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    /**
     * The width of the component is the width of the image
     */
    public int getWidth() {
        return image.getWidth();
    }

    /**
     * The height of the component is the height of the image
     */
    public int getHeight() {
        return image.getHeight();
    }
}