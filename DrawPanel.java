// ------Import Dynamic Data Structure(LinkedList)------
import java.util.LinkedList;

// ------Import Color------
import java.awt.Color;
import java.awt.Graphics;

// ------Import Layout Manager------
import java.awt.BorderLayout;

// ------Import Mouse Event Handler------
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 

// ------Import JLabel------
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * DrawPanel
 * Description: DrawPanel for SuperPaint.
 *              Instantiates all shapes in subclasses
 * April 16 2016
 * @author Matthew Wong
 * @version 1.0
 */

public class DrawPanel extends JPanel {
    // ------Instance Variables------
    private LinkedList<MyShape> shapeObjects = new LinkedList<MyShape>(); // LinkedList to store shape objects
    private LinkedList<MyShape> deletedShapeObjects = new LinkedList<MyShape>(); // LinkedList to store "deleted shapes"
    private int currentShapeType; // 0 - Line, 1 - Oval, 2 - Rectangle
    private MyShape currentShapeObject;
    private Color currentShapeColor;
    private boolean currentShapeFilled;
    private final JLabel statusLabel;
    
    // ------Magic Numbers------
    static final int LINE = 1;
    static final int OVAL = 2;
    static final int RECTANGLE = 3;
    
    static final boolean FILLED = false;
    static final boolean UNFILLED = true;
    
    // ------Constructor------
    public DrawPanel(JLabel jLabel) {
        
        setLayout(new BorderLayout(5, 5));
        currentShapeType = LINE;
        currentShapeObject = null;
        currentShapeColor = Color.RED;
        currentShapeFilled = FILLED;
        setBackground(Color.WHITE);
        
        // Mouse Event Handler
        addMouseListener(new MouseClickHandler());
        addMouseMotionListener(new MouseClickHandler());
        statusLabel = jLabel;
    } // End DrawPanel
    
    // ------paintComponent------
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw shapes in shapeObjects linkedList if not null
        for (MyShape shape : shapeObjects) {
            if (shape != null) {
                shape.draw(g);
            }
        }
        // Draw current shape if not null
        if (currentShapeObject != null) {
            currentShapeObject.draw(g);
        }
    } // End paintComponent
    
    // ------Accessor Methods------
    public void changeCurrentShapeType(int shape) {
        currentShapeType = shape;
    }
    
    public void changeCurrentShapeColor(Color color) {
        currentShapeColor = color;
    }
    
    public void changeCurrentShapeFilled(boolean fill) {
        currentShapeFilled = fill;
    }
    
    // ------Undo/Redo Method------
    public void clearLastShape() {
        // check if shapeObjects is empty before add/delete
        if (shapeObjects.size() > 0) {
            deletedShapeObjects.addFirst(shapeObjects.getFirst());
            shapeObjects.removeFirst();
            repaint();
        }
    }
    public void redoLastShape() {
        // Check if deletedShapeObjects is empty before add/delete
        if (deletedShapeObjects.size() > 0) {
            shapeObjects.addFirst(deletedShapeObjects.getFirst());
            deletedShapeObjects.removeFirst();
            repaint();
        }
    }
    public void clearDrawing() {
        // check if shapeObjects is empty before delete
        if (shapeObjects.size() > 0) {
            shapeObjects.clear();
        }
        // check if deletedShapeObject is empty before delete
        if (deletedShapeObjects.size() > 0) {
            deletedShapeObjects.clear();
        }
        repaint();
    }
    
    // ------Mouse Handler------
    private class MouseClickHandler extends MouseAdapter {
        
        
        public void mousePressed(MouseEvent event) {
            // Set currentShape to designated shape
            if(currentShapeType == LINE) {
                currentShapeObject = new MyLine(event.getX(), event.getX(), event.getY(), event.getY(), currentShapeColor);
            } else if(currentShapeType == OVAL) {
                currentShapeObject = new MyOval(event.getX(), event.getX(), event.getY(), event.getY(), currentShapeColor, currentShapeFilled);
            } else if(currentShapeType == RECTANGLE) {
                currentShapeObject = new MyRectangle(event.getX(), event.getX(), event.getY(), event.getY(), currentShapeColor, currentShapeFilled);
            }
        } // End method mousePressed
        
        public void mouseReleased(MouseEvent event) {
            // Set final coordinates to mouse released point
            currentShapeObject.setX2(event.getX());
            currentShapeObject.setY2(event.getY());
            shapeObjects.addFirst(currentShapeObject); // Add shape to shapeObjects list
            currentShapeObject = null; // Set currentShapeObject to null;
            repaint(); // Call paintComponent method to draw new shape;
        } // end method mouseReleased
        
        public void mouseDragged(MouseEvent event) {
            // set currentShapeObject X2 and Y2
            currentShapeObject.setX2(event.getX());
            currentShapeObject.setY2(event.getY());
            repaint();
            statusLabel.setText(String.format("Dragged at [%d, %d]", event.getX(), event.getY()));
        } // end method mouseDragged
                                  
        public void mouseMoved(MouseEvent event) {
            
            statusLabel.setText(String.format("Dragged at [%d, %d]", event.getX(), event.getY()));
        } // end method mouseMoved
    } // end MouseClickHandler class 
}
        
        
        
        
        
    
    
    