import java.util.Scanner;
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

public class main {
	private static void mainop() {
		// Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Display the options to the user
        System.out.println("Please choose a minecraft version:");
        System.out.println("1. 1.21.4");
        System.out.println("2. Other");

        // Read the user's input
        System.out.print("Enter your choice (1 - 2): ");
        int choice = scanner.nextInt();

        // Determine the output based on the user's choice
        if (choice == 1) {
            System.out.println("You choose minecraft version 1.21.4");
            v1214();
        } else if (choice == 2) {
            System.out.println("You choose Option 2.");
        } else {
            System.out.println("You did not choose a valid option.");
        }

        // Close the scanner
        scanner.close();

	} 
    public static void main(String[] args) {
    	mainop();
    	
    	Scanner scanner = new Scanner(System.in);
    	try {
            System.out.println("Press Enter to exit...");
            if (scanner.hasNextLine()) { // Check if there is input to read
                scanner.nextLine(); // Waits for the user to press Enter
            }
            System.out.println("Goodbye!");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close(); // Close the scanner
        }
    	}
    private static void v1214() {
    	Scanner scanner = new Scanner(System.in);

        // Display the options to the user
        System.out.println("Please choose if you want modded minecraft for 1.21.4:");
        System.out.println("1. no mods (just vanilla minecraft)");
        System.out.println("2. Fabric");

        // Read the user's input
        System.out.print("Enter your choice (1 - 2): ");
        int choice = scanner.nextInt();

        // Determine the output based on the user's choice
        if (choice == 1) {
            System.out.println("You choose minecraft with out mods (just vanilla minecraft)");
            v1214nomod();
        } else if (choice == 2) {
            System.out.println("You choose Option 2.");
        } else {
            System.out.println("You did not choose a valid option.");
        }

        // Close the scanner
        scanner.close();

    }
    private static void v1214nomod() {
    	JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Save Location");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String saveDirectory = fileChooser.getSelectedFile().getAbsolutePath();
            String saveFilePath = saveDirectory + "/Vanilla.Minecraft.1.21.4.zip";
            System.out.println("Starting Download of Minecraft 1.21.4");
            downloadFilev1214nomod(saveFilePath);
            
        } else {
            JOptionPane.showMessageDialog(null, "Download cancelled.", "Cancelled", JOptionPane.WARNING_MESSAGE);
        }
    }
    private static void downloadFilev1214nomod(String saveFilePath) {
    	JFrame framedownload = new JFrame("downloading...");
        framedownload.setResizable(false);
        framedownload.setType(Type.UTILITY);
        framedownload.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framedownload.setSize(10, 0);

        // Ensure the frame stays on top
        framedownload.setAlwaysOnTop(true);
        framedownload.setVisible(true);
        
        String fileURL = "https://github.com/CodePearly/Minecraft/archive/refs/heads/Vanilla.Minecraft.1.21.4.zip";
        System.out.println("Downloading minecraft from:" + fileURL);
        try (BufferedInputStream in = new BufferedInputStream(new URL(fileURL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(saveFilePath)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            framedownload.setVisible(false);
            JOptionPane.showMessageDialog(null, "Minecraft 1.21.4 downloaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Minecraft 1.21.4 downloaded successfully!");
            saveFilePathToFilev1214nomod(saveFilePath); // Save the file path to a text file
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
    private static void saveFilePathToFilev1214nomod(String saveFilePath) {
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
    private static String readZipFilePath() {
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
}
