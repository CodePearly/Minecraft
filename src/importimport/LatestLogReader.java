package importimport;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class LatestLogReader extends JFrame {

    private JTextArea logTextArea;
    private JButton startButton;

    public LatestLogReader() {
        setTitle("Latest Log Reader");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        logTextArea = new JTextArea();
        logTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(logTextArea);
        scrollPane.setPreferredSize(new Dimension(580, 300));

        startButton = new JButton("Start Reading Log");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> readLog()).start();
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(startButton, BorderLayout.SOUTH);

        add(panel);
    }

    private void readLog() {
        String downloadPathFile = "download_path.txt";
        File logFile;

        try (BufferedReader pathReader = new BufferedReader(new FileReader(downloadPathFile))) {
            String logFilePath = pathReader.readLine();

            if (logFilePath == null || logFilePath.isEmpty()) {
                logTextArea.append("The file 'download_path.txt' is empty or invalid.\n");
                return;
            }

            logFile = new File(logFilePath + "\\minecraft_PearlYapper3193-1.21.4-Offline\\AT\\logs\\latest.log");

            if (!logFile.exists() || !logFile.getName().equals("latest.log")) {
                logTextArea.append("The file 'latest.log' does not exist in the specified directory.\n");
                return;
            }

            logTextArea.append("Reading from latest.log located at: " + logFile.getAbsolutePath() + "\n");

            BufferedReader logReader = new BufferedReader(new FileReader(logFile));

            while (logReader.readLine() != null) {}

            String line;
            while (true) {
                if ((line = logReader.readLine()) != null) {
                    logTextArea.append(line + "\n");
                    logTextArea.setCaretPosition(logTextArea.getDocument().getLength());
                } else {
                    Thread.sleep(500);
                }
            }
        } catch (IOException | InterruptedException e) {
            logTextArea.append(e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LatestLogReader().setVisible(true);
        });
    }
}