package MinecraftVesions.pv1214;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fabric {

	private JFrame frmWhichFabricVersion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fabric window = new fabric();
					window.frmWhichFabricVersion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public fabric() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWhichFabricVersion = new JFrame();
		frmWhichFabricVersion.setTitle("Which Fabric version do you want?");
		frmWhichFabricVersion.setBounds(100, 100, 450, 300);
		frmWhichFabricVersion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWhichFabricVersion.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		frmWhichFabricVersion.getContentPane().add(scrollPane);
		
		JButton button = new JButton("0.16.10");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MinecraftVesions.pv1214.fab.one.main(null);
				frmWhichFabricVersion.dispose();
			}
		});
		scrollPane.setViewportView(button);
	}

}
