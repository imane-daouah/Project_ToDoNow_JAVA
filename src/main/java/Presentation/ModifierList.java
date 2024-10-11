package Presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
public class ModifierList extends JFrame {
	 
	private static final long serialVersionUID = 1L;

	public ModifierList() {
        setTitle("DO NOW : Modifier Liste ");
        setSize(900, 600);
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // North panel with top buttons
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(255, 255, 255));
        JButton btnReviens = new JButton("Reviens");
        btnReviens.setBackground(new Color(154, 215, 237));
        JButton btnMenu = new JButton("Menu");
        btnMenu.setBackground(new Color(51, 187, 88));
        JButton btnFermer = new JButton("Fermer");
        btnFermer.setBackground(new Color(255, 62, 62));
        btnFermer.setHorizontalAlignment(SwingConstants.LEFT);
        btnFermer.addActionListener(e -> dispose());
        northPanel.add(btnFermer);

        northPanel.add(btnReviens);
        northPanel.add(btnMenu);
        northPanel.add(btnFermer);

        // Center panel for form
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(253, 235, 191));
        
        
        
        JLabel lblDescription = new JLabel("_Modifier La Liste:_");
        lblDescription.setFont(new Font("Arial", Font.BOLD, 15));
        JTextArea txtDescription = new JTextArea();
        txtDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel lblDateAjout = new JLabel(" Modifier Description :");
        lblDateAjout.setFont(new Font("Arial", Font.BOLD, 15));
        SpringLayout sl_centerPanel = new SpringLayout();
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, txtDescription, -98, SpringLayout.SOUTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, lblDateAjout, 52, SpringLayout.SOUTH, lblDescription);
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblDateAjout, 30, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblDateAjout, -237, SpringLayout.SOUTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, lblDateAjout, -720, SpringLayout.EAST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, txtDescription, 152, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, txtDescription, -192, SpringLayout.EAST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblDescription, 10, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, lblDescription, -673, SpringLayout.EAST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, txtDescription, 146, SpringLayout.SOUTH, lblDescription);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblDescription, -377, SpringLayout.SOUTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, lblDescription, 10, SpringLayout.NORTH, centerPanel);
        centerPanel.setLayout(sl_centerPanel);

        centerPanel.add(lblDescription);
        centerPanel.add(txtDescription);
        centerPanel.add(lblDateAjout);

        // South panel with bottom buttons
        JPanel southPanel = new JPanel();
        southPanel.setBackground(new Color(255, 255, 255));

        // Add panels to frame
        getContentPane().add(northPanel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        
        JButton btnVoirLesTaches = new JButton("Modifier Les Taches De Cette Liste");
        sl_centerPanel.putConstraint(SpringLayout.NORTH, btnVoirLesTaches, 131, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, btnVoirLesTaches, 66, SpringLayout.EAST, lblDescription);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, btnVoirLesTaches, -94, SpringLayout.NORTH, txtDescription);
        sl_centerPanel.putConstraint(SpringLayout.EAST, btnVoirLesTaches, 363, SpringLayout.EAST, lblDescription);
        btnVoirLesTaches.setBackground(new Color(154, 215, 237));
        centerPanel.add(btnVoirLesTaches);
        
        ImageIcon supprimerIcon = new ImageIcon("supprimer.png");
        JButton btnSupprimer = new JButton(supprimerIcon);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, btnSupprimer, 31, SpringLayout.SOUTH, txtDescription);
        sl_centerPanel.putConstraint(SpringLayout.WEST, btnSupprimer, 406, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, btnSupprimer, -23, SpringLayout.SOUTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, btnSupprimer, -429, SpringLayout.EAST, centerPanel);
        centerPanel.add(btnSupprimer);
        
        
        
        ImageIcon modifierIcon = new ImageIcon("modifier.png");
        JButton btnModifier = new JButton(modifierIcon);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, btnModifier, 0, SpringLayout.NORTH, btnSupprimer);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, btnModifier, -23, SpringLayout.SOUTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, btnModifier, -6, SpringLayout.WEST, btnSupprimer);
        centerPanel.add(btnModifier);
        
        JLabel lblTuVeux = new JLabel("Tu Veux: ");
        sl_centerPanel.putConstraint(SpringLayout.WEST, btnModifier, 250, SpringLayout.EAST, lblTuVeux);
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblTuVeux, 0, SpringLayout.WEST, lblDateAjout);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblTuVeux, -51, SpringLayout.SOUTH, centerPanel);
        lblTuVeux.setFont(new Font("Arial", Font.BOLD, 15));
        centerPanel.add(lblTuVeux);
        getContentPane().add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
        btnMenu.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
        btnReviens.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
            	FenetreListe attacher= new FenetreListe();
				attacher.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
        btnVoirLesTaches.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
            	DesTachesListe att= new DesTachesListe();
				att.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
    }

    public static void main(String[] args) {
        new ModifierList();
    }
}
