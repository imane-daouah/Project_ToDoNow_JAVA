package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class DesSéancesProjet extends JFrame {
	 
    private static final long serialVersionUID = 1L;
    private JPanel panelProjets;
    private JTextField searchField;

    public DesSéancesProjet() {
    	getContentPane().setBackground(new Color(253, 235, 191));
        setTitle("DO Now : Les Séances De Cette Projet");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeUI();
    }

    private void initializeUI() {
        getContentPane().setLayout(new BorderLayout());

        // North Panel for filters, search, menu, and close
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        northPanel.setBackground(new Color(253, 235, 191));

        JButton searchButton = new JButton("Rechercher");
        searchButton.setBackground(new Color(154, 215, 237));
        searchButton.addActionListener(e -> rechercherProjet(searchField.getText()));
        northPanel.add(searchButton);

        searchField = new JTextField(20);
        northPanel.add(searchField);

        JButton addButton = new JButton("Creé Une Séance");
        addButton.setBackground(new Color(154, 215, 237));
        addButton.addActionListener(e -> ajouterSeance());
        northPanel.add(addButton);
        
        JButton impButton = new JButton("Importer Une Séance");
        impButton.setBackground(new Color(154, 215, 237));
        impButton.addActionListener(e -> ImporterSeance());
        northPanel.add(impButton);


        JButton menuButton = new JButton("Menu");
        menuButton.setBackground(new Color(51, 187, 88));
        menuButton.addActionListener(e -> ouvrirDashboard());
        northPanel.add(menuButton);

        JButton closeButton = new JButton("Fermer");
        closeButton.setBackground(new Color(255, 62, 62));
        closeButton.addActionListener(e -> dispose());
        northPanel.add(closeButton);

        getContentPane().add(northPanel, BorderLayout.NORTH);
        JButton btnReviens = new JButton("Raviens");
        btnReviens.setBackground(new Color(154, 215, 237));
        northPanel.add(btnReviens);
        
        btnReviens.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
            	ProjetDetail att = new ProjetDetail("Bonjour");
				att.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });

        // Central Panel for project list
        panelProjets = new JPanel();
        panelProjets.setBackground(new Color(253, 235, 191));
        panelProjets.setLayout(new BoxLayout(panelProjets, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(panelProjets);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Populate with dummy data
        populateProjects();
    }

    private void populateProjects() {
        for (int i = 1; i <= 3; i++) {
            JPanel projectPanel = new JPanel(new BorderLayout());
            projectPanel.setBorder(BorderFactory.createTitledBorder("Séance " + i));
            projectPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            projectPanel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(DesSéancesProjet.this, "Ouvrir les détails de la Séance");
                }
            });

            JLabel label = new JLabel(
                    "<html>Catégorie : Enseignement<br>Type : Cours<br>Date Départ : 10-09-2024<br>Date fin : 2-01-2025<br>Description : .................</html>",
                    JLabel.CENTER);
            projectPanel.add(label, BorderLayout.WEST);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            
            ImageIcon modifierIcon = new ImageIcon("modifier.png");
            ImageIcon supprimerIcon = new ImageIcon("supprimer.png");
            ImageIcon ajouterNote = new ImageIcon("clipboard.png");

            JButton editButton = new JButton(modifierIcon);
            JButton deleteButton = new JButton(supprimerIcon);
            JButton AjouterButton = new JButton(ajouterNote);

            buttonPanel.add(editButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(AjouterButton);
            projectPanel.add(buttonPanel, BorderLayout.EAST);

            editButton.addActionListener(e -> modifierProjet());
            deleteButton.addActionListener(e -> supprimerProjet());

            panelProjets.add(projectPanel);
        }
    }

    private Object supprimerProjet() {
		// TODO Auto-generated method stub
		return null;
	}

	private void ajouterSeance() {
		dispose();
        CreéSéance creer = new CreéSéance();
        creer.setVisible(true);
    }
	private void ImporterSeance() {
		dispose();
		importerSéance creer = new importerSéance();
        creer.setVisible(true);
    }

    private void modifierProjet() {
    	dispose();
        ModifierProjet modifierProjet = new ModifierProjet();
        modifierProjet.setVisible(true);
    }

    private void rechercherProjet(String critere) {
        JOptionPane.showMessageDialog(this, "Recherche pour: " + critere);
        panelProjets.removeAll();
        // Similar logic as populateProjects but based on search criteria
        panelProjets.revalidate();
        panelProjets.repaint();
    }

    private void ouvrirDashboard() {
    	dispose();
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        dispose(); // Ferme la fenêtre actuelle
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DesSéancesProjet().setVisible(true);
        });
    }
}