package MinecraftVesions.pv1214.fab;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import MinecraftVesions.pv1214.nomods;
import MinecraftVesions.pv1214.nomodsel.ExecuteCommandApp;

public class one {

    public one() {
        // Create a new frame for the "No Mods" window
        System.out.println("This is the one class");
        
    	
    	
    	
    	
    	
    	
    	
    	
    	JFrame one = new JFrame("Fabric 0.16.10 Selected");
        one.setTitle("Download File - Minecraft v1.21.4 with Fabric 0.16.10");
        one.setSize(400, 212);
        one.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Add components
        JLabel lblMessage = new JLabel("Click the button to download the file:", JLabel.CENTER);
        JButton btnDownload = new JButton("Download");

        // Add action listener for the download button
        btnDownload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooseFilePath(); // Call the chooseFilePath method
                ExecuteCommandApp.main(null);
                one.dispose(); // Close the frame after downloading the file
            }
        });

        // Arrange components in the frame
        one.getContentPane().setLayout(null);
        lblMessage.setBounds(50, 10, 300, 20);
        btnDownload.setBounds(150, 50, 100, 30);

        one.getContentPane().add(lblMessage);
        one.getContentPane().add(btnDownload);
        
        JButton btnIHaveAlready = new JButton("I have already downloaded minecraft");
        btnIHaveAlready.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		ExecuteCommandApp.main(null);
        		one.dispose();
        	}
        });
        btnIHaveAlready.setBounds(61, 108, 278, 30);
        one.getContentPane().add(btnIHaveAlready);

        // Make the frame visible
        one.setVisible(true);
    }

    // Method to allow the user to choose the file path
    private void chooseFilePath() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Save Location");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String saveDirectory = fileChooser.getSelectedFile().getAbsolutePath();
            String saveFilePath = saveDirectory + "/Fabric.0.16.10.Minecraft.1.21.4.zip";
            System.out.println("Starting Download of Minecraft 1.21.4");
            downloadFile(saveFilePath);
            
        } else {
            JOptionPane.showMessageDialog(null, "Download cancelled.", "Cancelled", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Method to download a file from a URL
    private void downloadFile(String saveFilePath) {
    	JFrame framedownload = new JFrame("downloading...");
        framedownload.setResizable(false);
        framedownload.setType(Type.UTILITY);
        framedownload.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framedownload.setSize(10, 0);
        
        // Ensure the frame stays on top
        framedownload.setAlwaysOnTop(true);
        framedownload.setVisible(true);
        
        String fileURL = "https://github.com/CodePearly/Minecraft/archive/refs/heads/Fabric.0.16.10.Minecraft.1.21.4.zip";
        System.out.println("Downloading minecraft from:" + fileURL);
        try (BufferedInputStream in = new BufferedInputStream(new URL(fileURL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(saveFilePath)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            framedownload.setVisible(false);
            JOptionPane.showMessageDialog(null, "Minecraft 1.21.4 with Fabric 0.16.10 downloaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Minecraft 1.21.4 with Fabric 0.16.10 downloaded successfully!");
            saveFilePathToFile(saveFilePath); // Save the file path to a text file
            // Read the file path from the text file
            String zipFilePath = readZipFilePath(); 
            if (zipFilePath != null) {
            	System.out.println("Extracting the zip file that was downloaded");
                extractZipFile(zipFilePath); // Extract the ZIP file using the path from the text file
            }
        } catch (IOException e) {
        	framedownload.setVisible(false);
            JOptionPane.showMessageDialog(null, "An error occurred while downloading Minecraft.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("An error occurred while downloading Minecraft.");
            e.printStackTrace();
        }
    }

    // Method to save only the directory path to a text file
    private void saveFilePathToFile(String saveFilePath) {
        try (PrintWriter out = new PrintWriter("download_path.txt")) {
            String directoryPath = saveFilePath.substring(0, saveFilePath.lastIndexOf('/'));
            out.println(directoryPath);
            out.println(saveFilePath);
            System.out.println("Saving the path to the zip file in download_path.txt");
        } catch (IOException e) {
        	System.out.println("An error occurred while saving the file path.");
            JOptionPane.showMessageDialog(null, "An error occurred while saving the file path.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Method to read the ZIP file path from the text file
    private String readZipFilePath() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("download_path.txt"));
            if (lines.size() >= 2) {
                return lines.get(1);
            } else {
            	System.out.println("The file path could not be read from the text file.");
                JOptionPane.showMessageDialog(null, "The file path could not be read from the text file.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file path.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("An error occurred while reading the file path.");
            e.printStackTrace();
            return null;
        }
    }

    // Method to extract the ZIP file
    private void extractZipFile(String zipFilePath) {
    	
    	JFrame framedownload = new JFrame("extracting...");
        framedownload.setResizable(false);
        framedownload.setType(Type.UTILITY);
        framedownload.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framedownload.setSize(10, 0);

        // Ensure the frame stays on top
        framedownload.setAlwaysOnTop(true);
        framedownload.setVisible(true);
    	
    	
    	
        String destDirectory = zipFilePath.substring(0, zipFilePath.lastIndexOf('/'));
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                String filePath = destDirectory + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    extractFile(zipIn, filePath);
                } else {
                    File dir = new File(filePath);
                    dir.mkdirs();
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
            // Show success message after extraction
            framedownload.setVisible(false);
            System.out.println("Successfully extracted zip");
            JOptionPane.showMessageDialog(null, "Successfully extracted zip", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Delete the ZIP file after extraction
            deleteZipFile(zipFilePath);
        } catch (IOException e) {
        	framedownload.setVisible(false);
            JOptionPane.showMessageDialog(null, "An error occurred while extracting the ZIP file.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("An error occurred while extracting the ZIP file.");
            e.printStackTrace();
        }
    }

    // Helper method to extract a file
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytesIn = new byte[1024];
            int read;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }

    // Method to delete the ZIP file
    private void deleteZipFile(String zipFilePath) {
        File zipFile = new File(zipFilePath);
        if (zipFile.delete()) {
        	System.out.println("ZIP file deleted successfully!");
        	JOptionPane.showMessageDialog(null, "ZIP file deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to delete the ZIP file.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Failed to delete the ZIP file.");
        }
    }

    public static void main(String[] args) {
        new nomods(); // Create an instance of the nomods class to display the frame
    }
}
