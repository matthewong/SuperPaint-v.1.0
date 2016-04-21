import java.awt.Color;
import java.awt.Graphics;
//Oval shape inherits qualities from the bounded shape and the shape class
public class MyRectangle extends MyBoundedShape {
    //Oval shape uses the bound shape default constructor hence the super
    public MyRectangle() {
        super();
    }
    //Calls the parent constructor by passing in the appropriate variables
    public MyRectangle( int x1, int x2, int y1, int y2, Color color, boolean clearCheck ) {
        super( x1, x2, y1, y2, color, clearCheck );
    }
    //Defines the draw method to draw an rectangle
    public void draw( Graphics g ) {
        g.setColor( getColor() );
        //Draws an rectangle that isn't filled and outlined black
        if ( getClearCheck() ) {
            g.setColor( getColor() );
            g.drawRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
        //Draws a filled rectangle with the random color
        } else {
            g.fillRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
        }
    }
}
    