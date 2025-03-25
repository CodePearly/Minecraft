import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommandExecutorGUI extends JFrame {

    private JTextField commandField;
    private JTextField directoryField;
    private JTextArea outputArea;

    public CommandExecutorGUI() {
        setTitle("Command Executor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Enter command(s): "));
        commandField = new JTextField();
        inputPanel.add(commandField);

        inputPanel.add(new JLabel("Enter working directory: "));
        directoryField = new JTextField();
        inputPanel.add(directoryField);

        JButton executeButton = new JButton("Execute");
        inputPanel.add(executeButton);

        add(inputPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand();
            }
        });
    }

    private void executeCommand() {
        String command = commandField.getText();
        String workingDirectoryPath = directoryField.getText();
        Path workingDirectory = Paths.get(workingDirectoryPath);

        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(command.split(" "));
            processBuilder.directory(workingDirectory.toFile());

            // Start a new console window
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
            processBuilder.redirectInput(ProcessBuilder.Redirect.INHERIT);

            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            outputArea.setText("Exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            outputArea.setText("Error executing command: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CommandExecutorGUI().setVisible(true);
            }
        });
    }
}
