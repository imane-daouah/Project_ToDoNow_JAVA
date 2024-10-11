package Presentation;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AfficherUneSéance extends JFrame {
	 
	private static final long serialVersionUID = 1L;

	public AfficherUneSéance() {
        setTitle("DO NOW : Details D'Une Séance ");
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
        btnFermer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        northPanel.add(btnReviens);
        northPanel.add(btnMenu);
        northPanel.add(btnFermer);

        // Center panel for form
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(253, 235, 191));
        
        
        
        JLabel lblDescription = new JLabel("_Détails de Cette Séance:_");
        lblDescription.setFont(new Font("Arial", Font.BOLD, 15));
        JTextArea txtDescription = new JTextArea();
        txtDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel lblDateAjout = new JLabel("Date Début:");
        lblDateAjout.setFont(new Font("Arial", Font.BOLD, 15));
        SpringLayout sl_centerPanel = new SpringLayout();
        sl_centerPanel.putConstraint(SpringLayout.NORTH, txtDescription, 34, SpringLayout.NORTH, lblDateAjout);
        sl_centerPanel.putConstraint(SpringLayout.WEST, txtDescription, 110, SpringLayout.EAST, lblDateAjout);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, txtDescription, -261, SpringLayout.SOUTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, txtDescription, -415, SpringLayout.EAST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, lblDateAjout, 52, SpringLayout.SOUTH, lblDescription);
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblDateAjout, 30, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblDateAjout, -237, SpringLayout.SOUTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, lblDateAjout, -720, SpringLayout.EAST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblDescription, 10, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, lblDescription, -673, SpringLayout.EAST, centerPanel);
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
        
        JButton btnVoirLesTaches = new JButton("Voir Les Taches De Cette Liste");
        sl_centerPanel.putConstraint(SpringLayout.NORTH, btnVoirLesTaches, 91, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, btnVoirLesTaches, -74, SpringLayout.NORTH, txtDescription);
        sl_centerPanel.putConstraint(SpringLayout.WEST, btnVoirLesTaches, 63, SpringLayout.EAST, lblDescription);
        sl_centerPanel.putConstraint(SpringLayout.EAST, btnVoirLesTaches, 360, SpringLayout.EAST, lblDescription);
        btnVoirLesTaches.setBackground(new Color(154, 215, 237));
        centerPanel.add(btnVoirLesTaches);
        
        ImageIcon supprimerIcon = new ImageIcon("supprimer.png");
        JButton btnSupprimer = new JButton(supprimerIcon);
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
        
        JLabel lblDateAjout_1 = new JLabel("Date Fin:");
        sl_centerPanel.putConstraint(SpringLayout.NORTH, lblDateAjout_1, 37, SpringLayout.SOUTH, lblDateAjout);
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblDateAjout_1, 0, SpringLayout.WEST, lblDateAjout);
        lblDateAjout_1.setFont(new Font("Arial", Font.BOLD, 15));
        centerPanel.add(lblDateAjout_1);
        
        JTextArea txtDescription_1 = new JTextArea();
        sl_centerPanel.putConstraint(SpringLayout.NORTH, btnSupprimer, 104, SpringLayout.SOUTH, txtDescription_1);
        sl_centerPanel.putConstraint(SpringLayout.WEST, txtDescription_1, 179, SpringLayout.EAST, lblDateAjout_1);
        sl_centerPanel.putConstraint(SpringLayout.EAST, txtDescription_1, -415, SpringLayout.EAST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, txtDescription_1, -1, SpringLayout.NORTH, lblDateAjout_1);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, txtDescription_1, 29, SpringLayout.NORTH, lblDateAjout_1);
        txtDescription_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerPanel.add(txtDescription_1);
        getContentPane().add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
        btnMenu.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
            	dispose();
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
        btnReviens.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
            	dispose();
            	FenetreListe attacher= new FenetreListe();
				attacher.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
    }

    public static void main(String[] args) {
        new AfficherUneSéance();
    }
}
