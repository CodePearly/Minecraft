import javax.swing.JButton;
import javax.swing.JFrame;
import MinecraftVesions.v1214;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class MinecraftVersion {
    public static void main(String[] args) {
        // Create a frame
        JFrame frmWhichMinecraftVersion = new JFrame("Main Class");
        frmWhichMinecraftVersion.setTitle("Which Minecraft Version Do you want?");
        frmWhichMinecraftVersion.setSize(389, 88);
        frmWhichMinecraftVersion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frmWhichMinecraftVersion.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
                
                JScrollPane scrollPane = new JScrollPane();
                frmWhichMinecraftVersion.getContentPane().add(scrollPane);
                
                JButton button = new JButton("1.21.4");
                scrollPane.setViewportView(button);
                
                button.addActionListener(e -> {
                    // Open the v1214 class window
                	System.out.println("Opening Mod/Vanilla Minecraft 1.21.4 Choser");
                    new v1214(); // Instantiate and display the v1214 class

                    // Close the current frame
                    frmWhichMinecraftVersion.dispose();
                });
                
        frmWhichMinecraftVersion.setVisible(true);
    }
}
