/**
 * Class name: RPS
 * This class acts as the main driver class for the Rock, Paper, Scissors GUI.
 *
 * @author     Jaren Pinera
 */
 
public class RPS {
   public static void main(String[ ] arg) {
      // Create the Responsive/Main frame object
      RPSFrameGUI f = new RPSFrameGUI( );
      
      // Call the initializeGUI() method and make the frame visible
      f.initializeGUI( );
      f.setVisible(true);
   }
}