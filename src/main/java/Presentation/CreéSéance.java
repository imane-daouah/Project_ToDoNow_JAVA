package Presentation;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreéSéance extends JFrame {
 
	private static final long serialVersionUID = 1L;

	public CreéSéance() {
        setTitle("DO NOW : Nouveau Séance ");
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
        
        JLabel lblDescription = new JLabel("Description:");
        lblDescription.setFont(new Font("Arial", Font.BOLD, 15));
        JTextArea txtDescription = new JTextArea();
        txtDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel lblDateAjout = new JLabel("Date De Début");
        lblDateAjout.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel lblImporter = new JLabel("Date De La Fin:");
        lblImporter.setFont(new Font("Arial", Font.BOLD, 15));
        SpringLayout sl_centerPanel = new SpringLayout();
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblDateAjout, -165, SpringLayout.SOUTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, lblDateAjout, 14, SpringLayout.SOUTH, lblDescription);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, lblImporter, 6, SpringLayout.SOUTH, lblDateAjout);
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblImporter, 0, SpringLayout.WEST, lblDescription);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblImporter, 497, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, lblImporter, 374, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblDateAjout, 0, SpringLayout.WEST, lblDescription);
        sl_centerPanel.putConstraint(SpringLayout.EAST, lblDateAjout, 374, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, lblDescription, 0, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, lblDescription, 10, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, lblDescription, 159, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, lblDescription, 334, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, txtDescription, 388, SpringLayout.WEST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, txtDescription, -10, SpringLayout.EAST, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.NORTH, txtDescription, 46, SpringLayout.NORTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, txtDescription, 101, SpringLayout.NORTH, centerPanel);
        centerPanel.setLayout(sl_centerPanel);

        centerPanel.add(lblDescription);
        centerPanel.add(txtDescription);
        centerPanel.add(lblDateAjout);
        centerPanel.add(lblImporter);

        // South panel with bottom buttons
        JPanel southPanel = new JPanel();
        southPanel.setBackground(new Color(255, 255, 255));
        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setBackground(new Color(255, 62, 62));
        JButton btnEnregistrer = new JButton("Enregistrer");
        btnEnregistrer.setBackground(new Color(51, 187, 88));
        southPanel.add(btnSupprimer);
        southPanel.add(btnEnregistrer);

        // Add panels to frame
        getContentPane().add(northPanel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        
        JDateChooser dateChooser = new JDateChooser();
        sl_centerPanel.putConstraint(SpringLayout.NORTH, dateChooser, 139, SpringLayout.SOUTH, txtDescription);
        sl_centerPanel.putConstraint(SpringLayout.WEST, dateChooser, 20, SpringLayout.EAST, lblDateAjout);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, dateChooser, 171, SpringLayout.SOUTH, txtDescription);
        sl_centerPanel.putConstraint(SpringLayout.EAST, dateChooser, -159, SpringLayout.EAST, centerPanel);
        centerPanel.add(dateChooser);
        
        JDateChooser dateChooser_1 = new JDateChooser();
        sl_centerPanel.putConstraint(SpringLayout.NORTH, dateChooser_1, -95, SpringLayout.SOUTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.WEST, dateChooser_1, 20, SpringLayout.EAST, lblImporter);
        sl_centerPanel.putConstraint(SpringLayout.SOUTH, dateChooser_1, -63, SpringLayout.SOUTH, centerPanel);
        sl_centerPanel.putConstraint(SpringLayout.EAST, dateChooser_1, 0, SpringLayout.EAST, dateChooser);
        centerPanel.add(dateChooser_1);
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
            	AttacherSeance attacher= new AttacherSeance();
				attacher.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
    }

    public static void main(String[] args) {
        new CreéSéance();
    }
}
