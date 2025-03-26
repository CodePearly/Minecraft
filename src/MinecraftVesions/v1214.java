package MinecraftVesions; // Fixed typo in the package name

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Import your custom class (nomods) correctly
import MinecraftVesions.pv1214.nomods;

public class v1214 {
    public v1214() {
        // Create a new frame for v1214
        JFrame frmModOrNot = new JFrame("v1.21.4");
        frmModOrNot.setTitle("Mod or Not for 1.21.4");
        frmModOrNot.setSize(339, 120);
        frmModOrNot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a label to display a message
        JLabel lblDoYouWant = new JLabel("Do you want modded Minecraft or not for 1.21.4?", JLabel.CENTER);

        JButton btnNoMods = new JButton("No mods");
        btnNoMods.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new nomods(); // Instantiate and display the nomods class
                
                // Close the current frame
                frmModOrNot.dispose();
            }
        });

        JButton btnFabric = new JButton("Fabric");
        btnFabric.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic for the Fabric button can go here
                System.out.println("Fabric button clicked!");
            }
        });

        JButton btnForge = new JButton("Forge");
        btnForge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic for the Forge button can go here
                System.out.println("Forge button clicked!");
            }
        });

        GroupLayout groupLayout = new GroupLayout(frmModOrNot.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(10)
                            .addComponent(btnNoMods, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addGap(10)
                            .addComponent(btnFabric, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addGap(10)
                            .addComponent(btnForge, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                        .addComponent(lblDoYouWant, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                    .addContainerGap())
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(lblDoYouWant, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnNoMods, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(btnFabric, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(btnForge, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
        );

        frmModOrNot.getContentPane().setLayout(groupLayout);
        frmModOrNot.setVisible(true);
    }

    // Entry point to run the program
    public static void main(String[] args) {
        new v1214();
    }
}
