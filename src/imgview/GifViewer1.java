package imgview;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.awt.Window.Type;

public class GifViewer1 {
    public static void main(String[] args) {
        // Create a JFrame to display the GIF
        JFrame framegif = new JFrame("downloading...");
        framegif.setResizable(false);
        framegif.setType(Type.UTILITY);
        framegif.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framegif.setSize(200, 255);

        // Ensure the frame stays on top
        framegif.setAlwaysOnTop(true);

        // Create a JPanel to hold the components (GIF and text)
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout

        // Load the GIF from within the JAR file
        InputStream gifStream = GifViewer1.class.getResourceAsStream("/imgview/download.gif");
        if (gifStream == null) {
            System.err.println("GIF file not found inside the JAR!");
            return;
        }

        try {
            // Read all bytes from the InputStream
            byte[] gifBytes = readAllBytes(gifStream);
            ImageIcon gifIcon = new ImageIcon(gifBytes);
            JLabel gifLabel = new JLabel(gifIcon);

            // Add the GIF to the panel
            panel.add(gifLabel);

            // Add a text label for "Downloading..."
            JLabel textLabel = new JLabel("Downloading...");
            textLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
            panel.add(textLabel);
            

            // Add the panel to the JFrame
            framegif.getContentPane().add(panel);
            framegif.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Utility method to read all bytes from an InputStream
    private static byte[] readAllBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(data)) != -1) {
            buffer.write(data, 0, bytesRead);
        }
        return buffer.toByteArray();
    }
}
