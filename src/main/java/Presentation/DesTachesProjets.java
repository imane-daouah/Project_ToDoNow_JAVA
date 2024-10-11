package Presentation;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
public class DesTachesProjets extends JFrame {
	 
    private static final long serialVersionUID = 1L;
    private JPanel panelProjets;
    private JTextField searchField;
    private JComboBox<String> comboBoxFiltre;

    public DesTachesProjets() {
    	getContentPane().setBackground(new Color(253, 235, 191));
        setTitle("DO Now : Les Taches De Ce Projet");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeUI();
    }

    private void initializeUI() {
        getContentPane().setLayout(new BorderLayout());

        // North Panel for filters, search, menu, and close
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(253, 235, 191));
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));

        JLabel labelFiltrer = new JLabel("Filtrer:");
        northPanel.add(labelFiltrer);

        String[] filtres = { "Catégorie", "Etat", "Date" };
        comboBoxFiltre = new JComboBox<>(filtres);
        northPanel.add(comboBoxFiltre);
        JButton searchButton = new JButton("Rechercher");
        searchButton.setBackground(new Color(154, 215, 237));
        northPanel.add(searchButton);

        searchField = new JTextField(20);
        northPanel.add(searchField);

        JButton addButton = new JButton("Creé Une Tache");
        addButton.setBackground(new Color(154, 215, 237));
        addButton.addActionListener(e -> ajouterProjet());
        northPanel.add(addButton);

        JButton impButton = new JButton("Importer Une Tache");
        impButton.setBackground(new Color(154, 215, 237));
        impButton.addActionListener(e -> ImporterTache());
        northPanel.add(impButton);
        
        JButton menuButton = new JButton("Menu");
        menuButton.setBackground(new Color(51, 187, 88));
        menuButton.addActionListener(e -> ouvrirDashboard());
        northPanel.add(menuButton);

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
        JButton closeButton = new JButton("Fermer");
        closeButton.setBackground(new Color(255, 62, 62));
        closeButton.addActionListener(e -> dispose());
        northPanel.add(closeButton);

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
        for (int i = 1; i <= 5; i++) {
            JPanel projectPanel = new JPanel(new BorderLayout());
            projectPanel.setBorder(BorderFactory.createTitledBorder("Tache " + i));
            projectPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            projectPanel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(DesTachesProjets.this, "Ouvrir les détails De Cette Tache");
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

            panelProjets.add(projectPanel);
        }
    }

    

	private void ajouterProjet() {
		dispose();
        CreéUnProjet creerProjet = new CreéUnProjet();
        creerProjet.setVisible(true);
    }

    private void modifierProjet() {
    	dispose();
        ModifierProjet modifierProjet = new ModifierProjet();
        modifierProjet.setVisible(true);
    }
    private void ImporterTache() {
    	dispose();
		importerTache creer = new importerTache();
        creer.setVisible(true);
    }


  

    private void ouvrirDashboard() {
    	dispose();
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DesTachesProjets().setVisible(true);
        });
    }
}
