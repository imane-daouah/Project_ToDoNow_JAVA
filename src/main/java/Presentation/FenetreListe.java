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

public class FenetreListe extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel panelProjets;
    private JTextField searchField;

    public FenetreListe() {
    	getContentPane().setBackground(new Color(253, 235, 191));
        setTitle("DO Now : Fenetre Vos Liste");
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

       
        JButton searchButton = new JButton("Rechercher");
        searchButton.setBackground(new Color(154, 215, 237));
        searchButton.addActionListener(e -> rechercherProjet(searchField.getText()));
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        northPanel.add(searchButton);

        searchField = new JTextField(20);
        northPanel.add(searchField);

        getContentPane().add(northPanel, BorderLayout.NORTH);
        
        JButton addButton = new JButton(" Ajouter Une Nouvelle Liste");
        addButton.setBackground(new Color(154, 215, 237));
        addButton.addActionListener(e -> ajouterListe());
        northPanel.add(addButton);
        
        JButton menuButton = new JButton("Menu");
        menuButton.setBackground(new Color(51, 187, 88));
        menuButton.addActionListener(e -> ouvrirDashboard());
        northPanel.add(menuButton);
        
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
            projectPanel.setBorder(BorderFactory.createTitledBorder("Liste " + i));
            projectPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            projectPanel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(FenetreListe.this, "Ouvrir les détails du Liste");
                }
            });

            JLabel label = new JLabel(
                    "<html>Description : .................</html>",
                    JLabel.CENTER);
            projectPanel.add(label, BorderLayout.WEST);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            ImageIcon modifierIcon = new ImageIcon("modifier.png");
            ImageIcon supprimerIcon = new ImageIcon("supprimer.png");
            JButton editButton = new JButton(modifierIcon);
            JButton deleteButton = new JButton(supprimerIcon);
            buttonPanel.add(editButton);
            buttonPanel.add(deleteButton);
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

	private void ajouterListe() {
		dispose();
		CreéUneListe creer = new CreéUneListe();
        creer.setVisible(true);
    }

    private void modifierProjet() {
    	dispose();
        ModifierList modifier = new ModifierList();
        modifier.setVisible(true);
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
            new FenetreListe().setVisible(true);
        });
    }
}
