// --------- Import JFrame/JPanel ---------
import javax.swing.JFrame;
import javax.swing.JPanel;

// --------- Import GUI Items ---------
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;

// --------- Import JFrame/JPanel Layout Managers ---------
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

// --------- Import Events Handlers ---------
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Draw Frame Class
 * Description: DrawFrame for SuperPaint
 *              Instantiates and handles GUI
 * 
 * April 16 2016
 * @author Matthew Wong
 * @version 1.0
 * 
 */
public class DrawFrame extends JFrame {
    
    // ------Instance Variables------
    
    private JPanel menuPanel; // Panel for menu items
    
    // ------Menu Items------
    private JButton undo;
    private JButton redo; 
    private JButton clear;
    
    private JComboBox colorSelection;
    private String colors[] = {"Red", "Green", "Blue", "Orange", "Pink", "Cyan", "Magenta", "Yellow", "Black", "White", "Gray", "Light Gray", "Dark Grey"};
    
    private JComboBox shapeSelection;
    private String shapes[] = {"Line", "Oval", "Rectangle"};
    
    private JCheckBox clearOrNot;
    
    // ------Magic Numbers------
    static final int LINE = 1;
    static final int OVAL = 2;
    static final int RECTANGLE = 3;
    
    private JLabel statusLabel;
    
    private DrawPanel drawPanel;
    
    // ------Constructor------
    public DrawFrame() {
        
        // ------DrawFrame------
        super("SuperPaint v.1.0"); // Set Title
        setLayout(new BorderLayout(5, 5)); // Set Layout Manager
        
        // ------MenuPanel(North)------
        menuPanel = new JPanel(); // Instantiate JPanel
        menuPanel.setLayout(new FlowLayout()); // Set Layout Manager
        
        // Buttons
        ButtonHandler buttonHandler = new ButtonHandler();
        
        undo = new JButton("undo");
        undo.addActionListener(buttonHandler);
        menuPanel.add(undo);
        
        redo = new JButton("redo");
        redo.addActionListener(buttonHandler);
        menuPanel.add(redo);
        
        clear = new JButton("clear");
        clear.addActionListener(buttonHandler);
        menuPanel.add(clear);
        
        // ComboBoxes
        ColorComboBoxHandler colorComboBoxHandler = new ColorComboBoxHandler();
        
        colorSelection = new JComboBox(colors);
        colorSelection.addActionListener(colorComboBoxHandler);
        menuPanel.add(colorSelection);
        
        ShapeComboBoxHandler shapeComboBoxHandler = new ShapeComboBoxHandler();
        
        shapeSelection = new JComboBox(shapes);
        shapeSelection.addActionListener(shapeComboBoxHandler);
        menuPanel.add(shapeSelection);
        
        // CheckBox
        ClearOrNotCheckBoxHandler clearOrNotCheckBoxHandler = new ClearOrNotCheckBoxHandler();
        
        clearOrNot = new JCheckBox("Clear");
        clearOrNot.addItemListener(clearOrNotCheckBoxHandler);
        menuPanel.add(clearOrNot);
        
        add(menuPanel, BorderLayout.NORTH);
        
        // ------StatusLabel(South)------
        statusLabel = new JLabel("Draw Something");
        add(statusLabel, BorderLayout.SOUTH);
        
        // ------DrawPanel(Center)------
        drawPanel = new DrawPanel(statusLabel);
        add(drawPanel, BorderLayout.CENTER);
        
    }
    
    // ------Button Handler------
    private class ButtonHandler implements ActionListener {
        // Handle Button Event
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == undo) {
                drawPanel.clearLastShape();
            } else if (event.getSource() == redo) {
                drawPanel.redoLastShape();
            } else {
                drawPanel.clearDrawing();
            }
        } // End Method actionPerformed
    } // End ButtonHandler
    
    // ------ColorComboBoxHandler------
    private class ColorComboBoxHandler implements ActionListener {
        // Handle Color ComboBox Events
        public void actionPerformed(ActionEvent event) {
            JComboBox<String> colorChooser = (JComboBox<String>)event.getSource();
            String color = (String)colorChooser.getSelectedItem();
            if (color == "Red") {
                drawPanel.changeCurrentShapeColor(Color.RED);
            } else if (color == "Green") {
                drawPanel.changeCurrentShapeColor(Color.GREEN);
            } else if (color == "Blue") {
                drawPanel.changeCurrentShapeColor(Color.BLUE);
            } else if (color == "Orange") {
                drawPanel.changeCurrentShapeColor(Color.ORANGE);
            } else if (color == "Pink") {
                drawPanel.changeCurrentShapeColor(Color.PINK);
            } else if (color == "Cyan") {
                drawPanel.changeCurrentShapeColor(Color.CYAN);
            } else if (color == "Magenta") {
                drawPanel.changeCurrentShapeColor(Color.MAGENTA);
            } else if (color == "Yellow") {
                drawPanel.changeCurrentShapeColor(Color.YELLOW);
            } else if (color == "Black") {
                drawPanel.changeCurrentShapeColor(Color.BLACK);
            } else if (color == "White") {
                drawPanel.changeCurrentShapeColor(Color.WHITE);
            } else if (color == "Gray") {
                drawPanel.changeCurrentShapeColor(Color.GRAY);
            } else if (color == "Light Gray") {
                drawPanel.changeCurrentShapeColor(Color.LIGHT_GRAY);
            } else if (color == "Dark Gray") {
                drawPanel.changeCurrentShapeColor(Color.DARK_GRAY);
            }                
        } // End method actionPerformed
    } // End ColorComboBoxHandler
    
    // ------ShapeComboBoxHandler------
    private class ShapeComboBoxHandler implements ActionListener {
        // Handle Shape ComboBox event
        public void actionPerformed(ActionEvent event) {
            JComboBox<String> shapeSelection = (JComboBox<String>)event.getSource();
            String shape = (String)shapeSelection.getSelectedItem();
            if (shape == "Line") {
                drawPanel.changeCurrentShapeType(LINE);
            } else if (shape == "Oval") {
                drawPanel.changeCurrentShapeType(OVAL);
            } else {
                drawPanel.changeCurrentShapeType(RECTANGLE);
            }
        } // End method actionPerformed
    } // End ShapeComboBoxHandler
    
    // ------ClearOrNotCheckBoxHandler------
    private class ClearOrNotCheckBoxHandler implements ItemListener {
        // Handle CheckBox event
        public void itemStateChanged(ItemEvent event) {
            if (clearOrNot.isSelected() == true) {
                drawPanel.changeCurrentShapeFilled(true);
            } else {
                drawPanel.changeCurrentShapeFilled(false);
            }
        } // End itemStateChanged
    } // End ClearOrNotCheckBoxHandler    
} // End DrawFrame class
                
        
        
        
        
        
        
        
        
        
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

