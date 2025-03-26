package MinecraftVesions.pv1214.nomodsel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import importimport.CommandExecutorGUI;

public class ExecuteCommandApp {
    static String workingDirectory = null;
    static String TheCommand = "no command set yet"; // Make TheCommand a class-level variable

    private static String uuidCode;
    private static String accessToken;
    private static String width = "854";
    private static String height = "480";
    private static String username;

    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("download_path.txt");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            workingDirectory = bufferedReader.readLine();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            bufferedReader.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        // Creating the main frame (window)
        JFrame iframe = new JFrame("Code Input GUI");
        iframe.setSize(500, 260); // Setting window size
        iframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closing app when window is closed
        iframe.setLayout(new FlowLayout()); // Setting layout manager

        // Creating a label to prompt the user
        JLabel labelinput1 = new JLabel("Enter your uuid code:");
        JLabel labelinput2 = new JLabel("Enter your accessToken code:");
        JLabel labelinput3 = new JLabel("Enter what width of minecraft you want it to open at (the default is 854):");
        JLabel labelinput4 = new JLabel("Enter what height of minecraft you want it to open at (the default is 480):");
        JLabel labelinput5 = new JLabel("Enter your Username for minecraft:");

        // Creating a text field for user input
        iframe.add(labelinput1);
        JTextField textuuid = new JTextField(20); // 20-character wide text field
        iframe.add(textuuid);
        iframe.add(labelinput2);
        JTextField textaccessToken = new JTextField(20); // 20-character wide text field
        iframe.add(textaccessToken);
        iframe.add(labelinput3);
        JTextField textwidth = new JTextField(5); // 5-character wide text field
        iframe.add(textwidth);
        iframe.add(labelinput4);
        JTextField textheight = new JTextField(5); // 5-character wide text field
        iframe.add(textheight);
        iframe.add(labelinput5);
        JTextField textusername = new JTextField(20); // 20-character wide text field
        iframe.add(textusername);

        // Creating a button to confirm the input
        JButton onebutton = new JButton("Submit");
        iframe.add(onebutton);

        // Adding action listener to handle button clicks
        onebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieving the text input from the user
                uuidCode = textuuid.getText();
                accessToken = textaccessToken.getText();
                width = textwidth.getText();
                height = textheight.getText();
                username = textusername.getText();

                // Displaying the entered code and storing it in a variable
                JOptionPane.showMessageDialog(iframe, "uuid entered: " + uuidCode);
                System.out.println("your uuid is stored as: " + uuidCode); // Printing it to the console
                JOptionPane.showMessageDialog(iframe, "accessToken entered: " + accessToken);
                System.out.println("your accessToken is stored as: " + accessToken);
                JOptionPane.showMessageDialog(iframe, "width of minecraft entered: " + width);
                System.out.println("The width of minecraft is stored as: " + width);
                JOptionPane.showMessageDialog(iframe, "height of minecraft entered: " + height);
                System.out.println("The height of minecraft is stored as: " + height);
                JOptionPane.showMessageDialog(iframe, "username entered: " + username);
                System.out.println("your username is stored as: " + username); // Printing it to the console

                iframe.setVisible(true);
            }
        });

        System.out.println("The working directory is:" + workingDirectory + "\\Minecraft-Vanilla.Minecraft.1.21.4\\AT\\instances\\Minecraft\\");
        workingDirectory = workingDirectory + "\\Minecraft-Vanilla.Minecraft.1.21.4\\AT\\";
        System.out.println("The workingDirectory String is set to:" + workingDirectory);

        JLabel commandLabel = new JLabel(TheCommand, SwingConstants.CENTER);
        commandLabel.setFont(new Font("Arial", Font.BOLD, 16));
        iframe.add(commandLabel);
        JPanel buttonPanel = new JPanel();
        iframe.add(buttonPanel);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update TheCommand here
                TheCommand = workingDirectory + "runtimes\\minecraft\\java-runtime-delta\\windows-x64\\java-runtime-delta\\bin\\java.exe -Xmx4096M -XX:MetaspaceSize=256M -Duser.language=en -Duser.country=US -Dlog4j.configurationFile=" + workingDirectory + "assets\\log_configs\\client-1.21.2.xml -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=32M -XX:HeapDumpPath=MojangTricksIntelDriversForPerformance_javaw.exe_minecraft.exe.heapdump -Xss1M -Djava.library.path=" + workingDirectory + "temp\\natives -Djna.tmpdir=" + workingDirectory + "temp\\natives -Dorg.lwjgl.system.SharedLibraryExtractPath=" + workingDirectory + "temp\\natives -Dio.netty.native.workdir=" + workingDirectory + "temp\\natives -Dminecraft.launcher.brand=ATLauncher -Dminecraft.launcher.version=3.4.38.2 -cp " + workingDirectory + "libraries\\com\\fasterxml\\jackson\\core\\jackson-annotations\\2.13.4\\jackson-annotations-2.13.4.jar;" + workingDirectory + "libraries\\com\\fasterxml\\jackson\\core\\jackson-core\\2.13.4\\jackson-core-2.13.4.jar;" + workingDirectory + "libraries\\com\\fasterxml\\jackson\\core\\jackson-databind\\2.13.4.2\\jackson-databind-2.13.4.2.jar;" + workingDirectory + "libraries\\com\\github\\oshi\\oshi-core\\6.6.5\\oshi-core-6.6.5.jar;" + workingDirectory + "libraries\\com\\github\\stephenc\\jcip\\jcip-annotations\\1.0-1\\jcip-annotations-1.0-1.jar;" + workingDirectory + "libraries\\com\\google\\code\\gson\\gson\\2.11.0\\gson-2.11.0.jar;" + workingDirectory + "libraries\\com\\google\\guava\\failureaccess\\1.0.2\\failureaccess-1.0.2.jar;" + workingDirectory + "libraries\\com\\google\\guava\\guava\\33.3.1-jre\\guava-33.3.1-jre.jar;" + workingDirectory + "libraries\\com\\ibm\\icu\\icu4j\\76.1\\icu4j-76.1.jar;" + workingDirectory + "libraries\\com\\microsoft\\azure\\msal4j\\1.17.2\\msal4j-1.17.2.jar;" + workingDirectory + "libraries\\com\\mojang\\authlib\\6.0.57\\authlib-6.0.57.jar;" + workingDirectory + "libraries\\com\\mojang\\blocklist\\1.0.10\\blocklist-1.0.10.jar;" + workingDirectory + "libraries\\com\\mojang\\brigadier\\1.3.10\\brigadier-1.3.10.jar;" + workingDirectory + "libraries\\com\\mojang\\datafixerupper\\8.0.16\\datafixerupper-8.0.16.jar;" + workingDirectory + "libraries\\com\\mojang\\jtracy\\1.0.29\\jtracy-1.0.29.jar;" + workingDirectory + "libraries\\com\\mojang\\jtracy\\1.0.29\\jtracy-1.0.29-natives-windows.jar;" + workingDirectory + "libraries\\com\\mojang\\logging\\1.5.10\\logging-1.5.10.jar;" + workingDirectory + "libraries\\com\\mojang\\patchy\\2.2.10\\patchy-2.2.10.jar;" + workingDirectory + "libraries\\com\\mojang\\text2speech\\1.17.9\\text2speech-1.17.9.jar;" + workingDirectory + "libraries\\com\\nimbusds\\content-type\\2.3\\content-type-2.3.jar;" + workingDirectory + "libraries\\com\\nimbusds\\lang-tag\\1.7\\lang-tag-1.7.jar;" + workingDirectory + "libraries\\com\\nimbusds\\nimbus-jose-jwt\\9.40\\nimbus-jose-jwt-9.40.jar;" + workingDirectory + "libraries\\com\\nimbusds\\oauth2-oidc-sdk\\11.18\\oauth2-oidc-sdk-11.18.jar;" + workingDirectory + "libraries\\commons-codec\\commons-codec\\1.17.1\\commons-codec-1.17.1.jar;" + workingDirectory + "libraries\\commons-io\\commons-io\\2.17.0\\commons-io-2.17.0.jar;" + workingDirectory + "libraries\\commons-logging\\commons-logging\\1.3.4\\commons-logging-1.3.4.jar;" + workingDirectory + "libraries\\io\\netty\\netty-buffer\\4.1.115.Final\\netty-buffer-4.1.115.Final.jar;" + workingDirectory + "libraries\\io\\netty\\netty-codec\\4.1.115.Final\\netty-codec-4.1.115.Final.jar;" + workingDirectory + "libraries\\io\\netty\\netty-common\\4.1.115.Final\\netty-common-4.1.115.Final.jar;" + workingDirectory + "libraries\\io\\netty\\netty-handler\\4.1.115.Final\\netty-handler-4.1.115.Final.jar;" + workingDirectory + "libraries\\io\\netty\\netty-resolver\\4.1.115.Final\\netty-resolver-4.1.115.Final.jar;" + workingDirectory + "libraries\\io\\netty\\netty-transport-classes-epoll\\4.1.115.Final\\netty-transport-classes-epoll-4.1.115.Final.jar;" + workingDirectory + "libraries\\io\\netty\\netty-transport-native-unix-common\\4.1.115.Final\\netty-transport-native-unix-common-4.1.115.Final.jar;" + workingDirectory + "libraries\\io\\netty\\netty-transport\\4.1.115.Final\\netty-transport-4.1.115.Final.jar;" + workingDirectory + "libraries\\it\\unimi\\dsi\\fastutil\\8.5.15\\fastutil-8.5.15.jar;" + workingDirectory + "libraries\\net\\java\\dev\\jna\\jna-platform\\5.15.0\\jna-platform-5.15.0.jar;" + workingDirectory + "libraries\\net\\java\\dev\\jna\\jna\\5.15.0\\jna-5.15.0.jar;" + workingDirectory + "libraries\\net\\minidev\\accessors-smart\\2.5.1\\accessors-smart-2.5.1.jar;" + workingDirectory + "libraries\\net\\minidev\\json-smart\\2.5.1\\json-smart-2.5.1.jar;" + workingDirectory + "libraries\\net\\sf\\jopt-simple\\jopt-simple\\5.0.4\\jopt-simple-5.0.4.jar;" + workingDirectory + "libraries\\org\\apache\\commons\\commons-compress\\1.27.1\\commons-compress-1.27.1.jar;" + workingDirectory + "libraries\\org\\apache\\commons\\commons-lang3\\3.17.0\\commons-lang3-3.17.0.jar;" + workingDirectory + "libraries\\org\\apache\\httpcomponents\\httpclient\\4.5.14\\httpclient-4.5.14.jar;" + workingDirectory + "libraries\\org\\apache\\httpcomponents\\httpcore\\4.4.16\\httpcore-4.4.16.jar;" + workingDirectory + "libraries\\org\\apache\\logging\\log4j\\log4j-api\\2.24.1\\log4j-api-2.24.1.jar;" + workingDirectory + "libraries\\org\\apache\\logging\\log4j\\log4j-core\\2.24.1\\log4j-core-2.24.1.jar;" + workingDirectory + "libraries\\org\\apache\\logging\\log4j\\log4j-slf4j2-impl\\2.24.1\\log4j-slf4j2-impl-2.24.1.jar;" + workingDirectory + "libraries\\org\\jcraft\\jorbis\\0.0.17\\jorbis-0.0.17.jar;" + workingDirectory + "libraries\\org\\joml\\joml\\1.10.8\\joml-1.10.8.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-freetype\\3.3.3\\lwjgl-freetype-3.3.3.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-freetype\\3.3.3\\lwjgl-freetype-3.3.3-natives-windows.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-freetype\\3.3.3\\lwjgl-freetype-3.3.3-natives-windows-arm64.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-freetype\\3.3.3\\lwjgl-freetype-3.3.3-natives-windows-x86.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-glfw\\3.3.3\\lwjgl-glfw-3.3.3.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-glfw\\3.3.3\\lwjgl-glfw-3.3.3-natives-windows.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-glfw\\3.3.3\\lwjgl-glfw-3.3.3-natives-windows-arm64.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-glfw\\3.3.3\\lwjgl-glfw-3.3.3-natives-windows-x86.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-jemalloc\\3.3.3\\lwjgl-jemalloc-3.3.3.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-jemalloc\\3.3.3\\lwjgl-jemalloc-3.3.3-natives-windows.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-jemalloc\\3.3.3\\lwjgl-jemalloc-3.3.3-natives-windows-arm64.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-jemalloc\\3.3.3\\lwjgl-jemalloc-3.3.3-natives-windows-x86.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-openal\\3.3.3\\lwjgl-openal-3.3.3.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-openal\\3.3.3\\lwjgl-openal-3.3.3-natives-windows.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-openal\\3.3.3\\lwjgl-openal-3.3.3-natives-windows-arm64.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-openal\\3.3.3\\lwjgl-openal-3.3.3-natives-windows-x86.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-opengl\\3.3.3\\lwjgl-opengl-3.3.3.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-opengl\\3.3.3\\lwjgl-opengl-3.3.3-natives-windows.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-opengl\\3.3.3\\lwjgl-opengl-3.3.3-natives-windows-arm64.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-opengl\\3.3.3\\lwjgl-opengl-3.3.3-natives-windows-x86.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-stb\\3.3.3\\lwjgl-stb-3.3.3.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-stb\\3.3.3\\lwjgl-stb-3.3.3-natives-windows.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-stb\\3.3.3\\lwjgl-stb-3.3.3-natives-windows-arm64.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-stb\\3.3.3\\lwjgl-stb-3.3.3-natives-windows-x86.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-tinyfd\\3.3.3\\lwjgl-tinyfd-3.3.3.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-tinyfd\\3.3.3\\lwjgl-tinyfd-3.3.3-natives-windows.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-tinyfd\\3.3.3\\lwjgl-tinyfd-3.3.3-natives-windows-arm64.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl-tinyfd\\3.3.3\\lwjgl-tinyfd-3.3.3-natives-windows-x86.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl\\3.3.3\\lwjgl-3.3.3.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl\\3.3.3\\lwjgl-3.3.3-natives-windows.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl\\3.3.3\\lwjgl-3.3.3-natives-windows-arm64.jar;" + workingDirectory + "libraries\\org\\lwjgl\\lwjgl\\3.3.3\\lwjgl-3.3.3-natives-windows-x86.jar;" + workingDirectory + "libraries\\org\\lz4\\lz4-java\\1.8.0\\lz4-java-1.8.0.jar;" + workingDirectory + "libraries\\org\\ow2\\asm\\asm\\9.6\\asm-9.6.jar;" + workingDirectory + "libraries\\org\\slf4j\\slf4j-api\\2.0.16\\slf4j-api-2.0.16.jar;" + workingDirectory + "libraries\\net\\minecraft\\client\\1.21.4\\client-1.21.4.jar net.minecraft.client.main.Main --username " + username + " --version 1.21.4 --gameDir " + workingDirectory + "instances\\Minecraft --assetsDir " + workingDirectory + "assets --assetIndex 19 --uuid " + uuidCode + " --accessToken " + accessToken + " --userType msa --versionType release --width=" + width + " --height=" + height;
                commandLabel.setText(TheCommand);
                JOptionPane.showMessageDialog(iframe, "Command refreshed!");
            }
        });
        buttonPanel.add(refreshButton);

        JButton copyButton = new JButton("Copy to Clipboard and open the Command executer");
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(TheCommand);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                System.out.println("Command copied to clipboard as:" + TheCommand);
                JOptionPane.showMessageDialog(iframe, "Command copied to clipboard!");
                CommandExecutorGUI.main(null);
                JOptionPane.showMessageDialog(iframe, "The working directory is:" + workingDirectory);
                System.out.println("Opened the Command Executor. I have got the code for this from:https://github.com/CodePearly/Java-Command-Executor");
                
            }
        });
        buttonPanel.add(copyButton);

        // Making the frame visible
        iframe.setVisible(true);
    }
}