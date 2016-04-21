
/**
 * SuperPaint Test Class
 * Description: SuperPaint Assigment
 *              Instantiates GUI
 * 
 * April 16 2016
 * @author Matthew Wong
 * @version 1.0
 */              

import javax.swing.JFrame;
 
public class SuperPaint 
{
   public static void main( String args[] )
   { 
      DrawFrame drawFrame = new DrawFrame(); // New DrawFrame object
      drawFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); // Set Program to shutdown when frame closses
      drawFrame.setSize( 600, 500 ); // Set frame size
      drawFrame.setVisible( true ); // Display frame
   }
} 