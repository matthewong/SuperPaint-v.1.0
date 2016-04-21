import java.awt.Color;
import java.awt.Graphics;
//The line class extends from the shape class 
public class MyLine extends MyShape {
    //Instead of having its own default constructor, it calls the shape class constructor or the "super"
    public MyLine() {
        super();
    }
    //Instead of having its own constructor, it passes in arguments and calls the shape constructor to set the instance variabales
    public MyLine( int x1, int x2, int y1, int y2, Color color ) {
        super( x1, x2, y1, y2, color );
    }
    //Define the draw method to set the color and draw the line according to the coordinates
    public void draw( Graphics g ) {
        
        g.setColor( getColor() );
        g.drawLine( getX1(), getY1(), getX2(), getY2() );
        
    }
}
    