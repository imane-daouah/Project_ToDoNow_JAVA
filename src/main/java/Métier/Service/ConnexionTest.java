package Métier.Service;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Profile;

public class ConnexionTest extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String TOKENS_DIRECTORY_PATH = System.getProperty("user.home") + "/.tokens"; // Tokens directory
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private JTextField emailField;

    public ConnexionTest() {
        setTitle("Connexion via Google");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(253, 235, 191));
        initializeUI();
    }

    private void initializeUI() {
        getContentPane().setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(253, 235, 191));
        GridBagConstraints gbc = new GridBagConstraints();

        emailField = new JTextField(20);
        JButton connectButton = new JButton("Connect");

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 5, 10);
        panel.add(emailField, gbc);

        gbc.insets = new Insets(5, 10, 10, 10);
        connectButton.addActionListener(e -> {
            try {
                performGoogleSignIn();  // Perform the sign-in without passing email directly
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error during authentication: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(connectButton, gbc);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    private void performGoogleSignIn() throws IOException {
        // Load client secrets
        GoogleClientSecrets secrets = GoogleClientSecrets.load(JSON_FACTORY,
            new InputStreamReader(ConnexionTest.class.getResourceAsStream("/client_secrets.json")));

        // Define required scopes
        List<String> scopes = Arrays.asList(
            "https://www.googleapis.com/auth/gmail.readonly",
            "https://www.googleapis.com/auth/userinfo.email"
        );

        // Build flow and trigger user authorization request
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
            new NetHttpTransport(), JSON_FACTORY, secrets, scopes)
            .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
            .setAccessType("offline")
            .build();

        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");

        // Construct the Gmail service
        Gmail service = new Gmail.Builder(new NetHttpTransport(), JSON_FACTORY, credential)
            .setApplicationName("Connexion Test")
            .build();

        // Fetch the user profile
        Profile profile = service.users().getProfile("me").execute();
        JOptionPane.showMessageDialog(this, "You are logged in as: " + profile.getEmailAddress());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConnexionTest frame = new ConnexionTest();
            frame.setVisible(true);
        });
    }
}
