package Presentation;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;

public class ModifierProjet extends JFrame {

    private static final long serialVersionUID = 1L;
    private final JButton btnAttacher = new JButton("Attacher Une : Tach/Séance/Document");

    public ModifierProjet() {
    	getContentPane().setBackground(new Color(253, 235, 191));
        setTitle("DO NOW : Modifier projet");
        setSize(900, 600);
        setLocationRelativeTo(null); // Center the frame 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initializeUI();
    }

    private void initializeUI() {
        // Panneau principal pour la saisie des données
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(253, 235, 191));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        SpringLayout sl_mainPanel = new SpringLayout();
        mainPanel.setLayout(sl_mainPanel);

        // Labels et champs de saisie
        JLabel lblModifierCatgorie = new JLabel("Modifier Catégorie :");
        sl_mainPanel.putConstraint(SpringLayout.WEST, lblModifierCatgorie, 14, SpringLayout.WEST, mainPanel);
        mainPanel.add(lblModifierCatgorie);
        JComboBox<String> categoryComboBox = new JComboBox<>(new String[]{"Enseignement", "Recherche", "Autre"});
        sl_mainPanel.putConstraint(SpringLayout.NORTH, lblModifierCatgorie, 0, SpringLayout.NORTH, categoryComboBox);
        sl_mainPanel.putConstraint(SpringLayout.EAST, lblModifierCatgorie, -6, SpringLayout.WEST, categoryComboBox);
        sl_mainPanel.putConstraint(SpringLayout.NORTH, categoryComboBox, 55, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.WEST, categoryComboBox, 398, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, categoryComboBox, 84, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, categoryComboBox, 776, SpringLayout.WEST, mainPanel);
        mainPanel.add(categoryComboBox);

        JLabel lblModifierType = new JLabel("Modifier Type :");
        sl_mainPanel.putConstraint(SpringLayout.NORTH, lblModifierType, 37, SpringLayout.SOUTH, lblModifierCatgorie);
        sl_mainPanel.putConstraint(SpringLayout.WEST, lblModifierType, 14, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, lblModifierType, 135, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, lblModifierType, 0, SpringLayout.EAST, lblModifierCatgorie);
        mainPanel.add(lblModifierType);
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Cours", "Séminaire", "Atelier"});
        sl_mainPanel.putConstraint(SpringLayout.NORTH, typeComboBox, 0, SpringLayout.NORTH, lblModifierType);
        sl_mainPanel.putConstraint(SpringLayout.WEST, typeComboBox, 398, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, typeComboBox, 143, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, typeComboBox, 776, SpringLayout.WEST, mainPanel);
        mainPanel.add(typeComboBox);

        JLabel lblModifierDescription = new JLabel("Modifier Description:");
        lblModifierDescription.setVerticalAlignment(SwingConstants.TOP);
        sl_mainPanel.putConstraint(SpringLayout.WEST, lblModifierDescription, 0, SpringLayout.WEST, lblModifierCatgorie);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, lblModifierDescription, 252, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, lblModifierDescription, 392, SpringLayout.WEST, mainPanel);
        mainPanel.add(lblModifierDescription);
        JTextArea descriptionTextArea = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(descriptionTextArea);
        sl_mainPanel.putConstraint(SpringLayout.NORTH, lblModifierDescription, 0, SpringLayout.NORTH, scrollPane);
        sl_mainPanel.putConstraint(SpringLayout.NORTH, scrollPane, 178, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.WEST, scrollPane, 398, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, scrollPane, 252, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, scrollPane, 776, SpringLayout.WEST, mainPanel);
        mainPanel.add(scrollPane);

        JLabel lblModifierDateDe = new JLabel("Modifier Date de départ :");
        lblModifierDateDe.setVerticalAlignment(SwingConstants.TOP);
        sl_mainPanel.putConstraint(SpringLayout.NORTH, lblModifierDateDe, 262, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.WEST, lblModifierDateDe, 10, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, lblModifierDateDe, 336, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, lblModifierDateDe, 388, SpringLayout.WEST, mainPanel);
        mainPanel.add(lblModifierDateDe);

        JLabel lblModifierDateDe_1 = new JLabel("Modifier Date de fin :");
        lblModifierDateDe_1.setVerticalAlignment(SwingConstants.TOP);
        sl_mainPanel.putConstraint(SpringLayout.NORTH, lblModifierDateDe_1, 346, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.WEST, lblModifierDateDe_1, 10, SpringLayout.WEST, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, lblModifierDateDe_1, 420, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, lblModifierDateDe_1, 388, SpringLayout.WEST, mainPanel);
        mainPanel.add(lblModifierDateDe_1);

        // Panneau pour les boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(253, 235, 191));
        btnAttacher.setBackground(new Color(154, 215, 237));
        buttonPanel.add(btnAttacher);
        SpringLayout springLayout = new SpringLayout();
        springLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 430, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, buttonPanel, 0, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, buttonPanel, 876, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, mainPanel, 0, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, mainPanel, 0, SpringLayout.WEST, getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, mainPanel, 430, SpringLayout.NORTH, getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, mainPanel, 786, SpringLayout.WEST, getContentPane());
        getContentPane().setLayout(springLayout);
        getContentPane().add(mainPanel);
        
        JDateChooser dateChooser = new JDateChooser();
        sl_mainPanel.putConstraint(SpringLayout.NORTH, dateChooser, 19, SpringLayout.SOUTH, scrollPane);
        sl_mainPanel.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, categoryComboBox);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, dateChooser, -110, SpringLayout.SOUTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, dateChooser, 271, SpringLayout.EAST, lblModifierDateDe);
        mainPanel.add(dateChooser);
        
        JDateChooser dateChooser_1 = new JDateChooser();
        sl_mainPanel.putConstraint(SpringLayout.NORTH, dateChooser_1, -61, SpringLayout.SOUTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.WEST, dateChooser_1, 0, SpringLayout.WEST, categoryComboBox);
        sl_mainPanel.putConstraint(SpringLayout.SOUTH, dateChooser_1, -32, SpringLayout.SOUTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.EAST, dateChooser_1, 0, SpringLayout.EAST, dateChooser);
        mainPanel.add(dateChooser_1);
        
        JLabel lblNewLabel = new JLabel("_Modifier Le Projet Selectionner_");
        sl_mainPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, mainPanel);
        sl_mainPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblModifierCatgorie);
        sl_mainPanel.putConstraint(SpringLayout.EAST, lblNewLabel, 228, SpringLayout.WEST, mainPanel);
        mainPanel.add(lblNewLabel);
        getContentPane().add(buttonPanel);
        
        btnAttacher.addActionListener(e -> {
            dispose();  // Ferme la fenêtre actuelle
            SwingUtilities.invokeLater(() -> {
            	AttacherElementsProjet attacher= new AttacherElementsProjet();
    			attacher.setVisible(true);  // Ouvre la fenêtre du tableau de bord
            });
        });
        
        JButton saveButton = new JButton("Enregistrer");
        saveButton.setBackground(new Color(51, 187, 88));
        buttonPanel.add(saveButton);
        JButton deleteButton = new JButton("Supprimer");
        deleteButton.setBackground(new Color(255, 62, 62));
        buttonPanel.add(deleteButton);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ModifierProjet().setVisible(true);
        });
    }
} 