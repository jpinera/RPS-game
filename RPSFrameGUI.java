// Import the javax.swing and java.awt to create graphical elements
// Import the java.awt.event for event-driven programming (used with Action Listeners)
// Import java.util for the Random class in generating the computer's choice
// Import java.io for FileWriter and PrintWriter to write to a file
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 * Class name/ file name: RPSFrameGUI
 * This class creates the responive/ main frame, initializig the GUI for the Rock-Paper-Scissors 
 * interactive game with the user.
 *
 * @author     Jaren Pinera
 */
 
public class RPSFrameGUI extends JFrame {
   // Declare and initialize the instance variables to be used in the overall frame
   private int WIDTH = 1300;
   private int HEIGHT = 800;
   
   // Declare and initialize JButton components
   private JButton bRock = new JButton("ROCK");
   private JButton bPaper = new JButton("PAPER");
   private JButton bScissors = new JButton("SCISSORS");
   private JButton bHTP = new JButton("  HOW  TO  PLAY  ");
   private JButton bQuit = new JButton("  QUIT  ");
   private JButton bPA = new JButton("  PLAY  AGAIN  ");
   
   // Declare and initialize Image objects using ImageIcon class
   private ImageIcon iRock = new ImageIcon(getClass().getResource("Rock_choiceU.png"));
   private ImageIcon iPaper = new ImageIcon(getClass().getResource("Paper_choiceU.png"));
   private ImageIcon iScissors = new ImageIcon(getClass().getResource("Scissors_choiceU.png"));
   private ImageIcon iRockFlip = new ImageIcon(getClass().getResource("Rock_choiceC.png"));        // Flipped image of Rock
   private ImageIcon iPaperFlip = new ImageIcon(getClass().getResource("Paper_choiceC.png"));      // Flipped image of Paper
   private ImageIcon iScissorsFlip = new ImageIcon(getClass().getResource("Scissors_choiceC.png"));// Flipped image of scissors
   
   // Declare and initialize JLabel components
   private JLabel title = new JLabel("  ROCK - PAPER - SCISSORS  ");
   private JLabel com = new JLabel("  COMPUTER  ");
   private JLabel vs = new JLabel("  vs.  ");
   private JLabel user = new JLabel("  YOU  ");
   private JLabel scoreHead = new JLabel("  SCORE  ");
   private JLabel wins = new JLabel("  You: ");
   private JLabel losses = new JLabel("  Computer: ");
   private JLabel ties = new JLabel("  Ties: ");
   private JLabel gameResult = new JLabel(" ");
   private JLabel choice = new JLabel(" ");
   private JLabel generate = new JLabel(" ");
   private JLabel instruct = new JLabel("  Choose one (ROCK, PAPER, SCISSORS) to play  ");
   
   // Declare an initialize custom Colors
   private Color cGreen = new Color(26, 201, 73);   
   private Color cPurple = new Color(202, 75, 249);
   private Color cDkPurple = new Color(130, 46, 161);
   private Color cYellow = new Color(247, 228, 56);
   private Color cRed = new Color(255, 88, 110);
   private Color cBrtRed = new Color(230, 11, 11);
   private Color cCyan = new Color(81, 234, 239);
   
    
   /**
    * Acts as the constructor for the Responsive/Main frame. The main frame will
    * be used in the driver class to set the "canvas" for Rock-Paper-Scissors (RPS)
    * GUI game. Note: frame is not resizable and program will terminate when frame
    * is closed.
    *
    * @param      none
    * @exception  none
    * @return     none                        
    */  
   public RPSFrameGUI() {   
      // Initialize the frame
	   this.setSize(WIDTH,HEIGHT);
      this.setTitle("JAN - KEN - PO");
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setVisible(true);
      this.setResizable(false);
   }
   
   /**
    * This method initalizes the GUI for the RPS game, placing all of the elements
    * and components in a certain position on the screen. In addition, Action
    * Listeneres are added to the elements (JButtons) that will moniter the 
    * events. 
    *
    * @param      none
    * @exception  none
    * @return     none                        
    */  
   public void initializeGUI() {
      // Create the ActionListener object and add to buttons
      ActionListener ears = new MyListener();
      bRock.addActionListener(ears);
      bPaper.addActionListener(ears);
      bScissors.addActionListener(ears);
      bHTP.addActionListener(ears);
      bPA.addActionListener(ears);
      bQuit.addActionListener(ears);
      
      
      // Create JPanels
      JPanel p = new JPanel();
	   JPanel pTop = new JPanel();
	   JPanel pBottom = new JPanel();
	   JPanel pLeft = new JPanel();
	   JPanel pRight = new JPanel();
      JPanel pCenter = new JPanel();
      JPanel pMidTop = new JPanel();    // Middle Top JPanel: inner JPanel inside pTop JPanel
      JPanel pBotLeft = new JPanel();   // Left Bottom JPanel: inner JPanel inside bottom portion of pLeft JPanel
      JPanel pCenterM = new JPanel();   // Middle Center JPanel: inner JPanel inside middle portion of pCenter JPanel
      
      
      // Set the Jpanel layouts for spacing/ position of objects
      p.setLayout(new BorderLayout());
      pCenter.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 15));
      pLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
      pBotLeft.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 15));
      pCenterM.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 20));
      
      
      // Set the background color of components
      // - JPanels
      pTop.setBackground(cPurple);
      pMidTop.setBackground(Color.white);
      pBotLeft.setBackground(Color.white);
	   pBottom.setBackground(cPurple);	   
	   pLeft.setBackground(cPurple);
      pCenter.setBackground(cPurple);
      pCenterM.setBackground(cPurple);
      // - JButtons
      bRock.setBackground(cRed);
	   bPaper.setBackground(cYellow);
	   bScissors.setBackground(cCyan);
      
      
      // Set the Foreground and Background colors of JLabels
      title.setForeground(Color.black);
      com.setForeground(Color.white);
      vs.setForeground(Color.white);
      user.setForeground(Color.white);
      instruct.setBackground(Color.white);
      gameResult.setBackground(Color.white);
      
      
      // Restrict the size dimensions of certain components
      // - JPanels
      pTop.setPreferredSize(new Dimension(150,175));
	   pLeft.setPreferredSize(new Dimension(250, 125));
      pBotLeft.setPreferredSize(new Dimension(210,225)); // 200 x 215 w/o borders
	   pRight.setPreferredSize(new Dimension(0,75));
	   pBottom.setPreferredSize(new Dimension(150,150));
      pCenterM.setPreferredSize(new Dimension(1050,300));
      // - JButtons
      bRock.setPreferredSize(new Dimension(250,125));
      bPaper.setPreferredSize(new Dimension(250,125));
      bScissors.setPreferredSize(new Dimension(250,125));
      bHTP.setPreferredSize(new Dimension(150,50));
      bPA.setPreferredSize(new Dimension(150,50));
      bQuit.setPreferredSize(new Dimension(150,50));
      // - JLabels
      scoreHead.setPreferredSize(new Dimension(155, 35));
      wins.setPreferredSize(new Dimension(190, 30));
      losses.setPreferredSize(new Dimension(190, 30));
      ties.setPreferredSize(new Dimension(190, 30));
      
      
      // Set specific border sizes for components using the BorderFactory class
      // - JPanels
      pTop.setBorder(BorderFactory.createEmptyBorder(10,10,10, 10));    
      pMidTop.setBorder(BorderFactory.createLineBorder(cDkPurple, 8, false));
      pBotLeft.setBorder(BorderFactory.createLineBorder(cDkPurple, 5, false));
      // - JButtons
      gameResult.setBorder(BorderFactory.createLineBorder(cDkPurple, 5, false));
      bRock.setBorder(BorderFactory.createLineBorder(Color.white, 5, true));
      bPaper.setBorder(BorderFactory.createLineBorder(Color.white, 5, true));
      bScissors.setBorder(BorderFactory.createLineBorder(Color.white, 5, true));
      // - JLabels
      title.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      instruct.setBorder(BorderFactory.createLineBorder(cDkPurple, 5, false));
      
      
      // Set the text Font and size of components
      // - JButtons
      bHTP.setFont(new Font("Fairplay Display", Font.PLAIN, 12));
      bPA.setFont(new Font("Fairplay Display", Font.PLAIN, 12));
      bQuit.setFont(new Font("Fairplay Display", Font.PLAIN, 12));
      bRock.setFont(new Font("Fairplay Display", Font.BOLD, 25));
      bPaper.setFont(new Font("Fairplay Display", Font.BOLD, 25));
      bScissors.setFont(new Font("Fairplay Display", Font.BOLD, 25));
      // - JLabels
      title.setFont(new Font("Montserrat", Font.BOLD, 60));
      com.setFont(new Font("Proxima Nova", Font.BOLD, 30));
      user.setFont(new Font("Proxima Nova", Font.BOLD, 30)); 
      vs.setFont(new Font("Proxima Nova", Font.BOLD, 30));
      scoreHead.setFont(new Font("Proxima Nova", Font.BOLD, 23));
      gameResult.setFont(new Font("Proxima Nova", Font.BOLD, 30));
      wins.setFont(new Font("Proxima Nova", Font.PLAIN, 20));
      losses.setFont(new Font("Proxima Nova", Font.PLAIN, 20));
      ties.setFont(new Font("Proxima Nova", Font.PLAIN, 20));
      instruct.setFont(new Font("Proxima Nova", Font.PLAIN, 25));
      
      
      // Images used as part of the GUI
      // Create Image objects from the ImageIcon objects
      Image rockImg = iRock.getImage();
	   Image paperImg = iPaper.getImage();
	   Image scissorsImg = iScissors.getImage();
      Image rockImgF = iRockFlip.getImage();            // Flipped Rock Image
	   Image paperImgF = iPaperFlip.getImage();          // Flipped Paper Image
	   Image scissorsImgF = iScissorsFlip.getImage();    // Flipped Scissors Image
	   // Scale down images
      Image scaleRock = rockImg.getScaledInstance(250,250, java.awt.Image.SCALE_SMOOTH);
	   Image scalePaper = paperImg.getScaledInstance(250,250, java.awt.Image.SCALE_SMOOTH);
	   Image scaleScissors = scissorsImg.getScaledInstance(250,250, java.awt.Image.SCALE_SMOOTH);
      Image scaleRockF = rockImgF.getScaledInstance(250,250, java.awt.Image.SCALE_SMOOTH);
	   Image scalePaperF = paperImgF.getScaledInstance(250,250, java.awt.Image.SCALE_SMOOTH);
	   Image scaleScissorsF = scissorsImgF.getScaledInstance(250,250, java.awt.Image.SCALE_SMOOTH);
      // Set the ImageIcon to the scaled image
	   iRock = new ImageIcon(scaleRock);
	   iPaper = new ImageIcon(scalePaper);
	   iScissors = new ImageIcon(scaleScissors);
      iRockFlip = new ImageIcon(scaleRockF);
	   iPaperFlip = new ImageIcon(scalePaperF);
	   iScissorsFlip = new ImageIcon(scaleScissorsF);
      
      
      // Set the opacity and visibility of JLabels on opening screen
      instruct.setOpaque(true);
      gameResult.setOpaque(true);
      gameResult.setVisible(false);
      
      
      // Disable JButton(s) from opening screen
      bPA.setEnabled(false);
      
      
      // Adding elements to JPanels:
      // - Top JPanel
      pMidTop.add(title);     // Inner panel inside top panel
      pTop.add(pMidTop);
      
      // - Bottom JPanel
      pBottom.add(Box.createRigidArea(new Dimension(175, 0)));  // empty "containers" and horizontal spaces
      pBottom.add(bRock);
      pBottom.add(Box.createRigidArea(new Dimension(40, 0)));
      pBottom.add(bPaper);
      pBottom.add(Box.createRigidArea(new Dimension(40, 0)));
      pBottom.add(bScissors);
      
      // - Bottom Left JPanel (inner JPanel inside left JPanel)
      pBotLeft.add(Box.createRigidArea(new Dimension(45, 0)));
      pBotLeft.add(scoreHead);
      pBotLeft.add(Box.createRigidArea(new Dimension(10, 0)));
      pBotLeft.add(wins);
      pBotLeft.add(Box.createRigidArea(new Dimension(10, 0)));
      pBotLeft.add(losses);
      pBotLeft.add(Box.createRigidArea(new Dimension(10, 0)));
      pBotLeft.add(ties);
      
      // - Left JPanel
      pLeft.add(bHTP);
      pLeft.add(bPA);
      pLeft.add(bQuit);
      pLeft.add(pBotLeft);
      
      // - Middle Center JPanel (inner JPanel inside Center JPanel)
      pCenterM.add(choice);
      pCenterM.add(gameResult);
      pCenterM.add(generate);
      
      // - Center JPanel
      pCenter.add(Box.createRigidArea(new Dimension(125, 0)));
      pCenter.add(user);
      pCenter.add(Box.createRigidArea(new Dimension(225, 0)));
      pCenter.add(vs);
      pCenter.add(Box.createRigidArea(new Dimension(190, 0)));
      pCenter.add(com);
      pCenter.add(pCenterM);
      pCenter.add(Box.createRigidArea(new Dimension(175, 0)));
      pCenter.add(instruct);
      
      
      // Add all JPanel to main JPanel (Border Layout)
      p.add(pCenter, BorderLayout.CENTER);
      p.add(pTop, BorderLayout.NORTH);
      p.add(pLeft, BorderLayout.WEST);
      p.add(pRight, BorderLayout.EAST);
      p.add(pBottom, BorderLayout.SOUTH);
      
      
      // Add the main JPanel to GUI main frame and set its visibility
      p.setVisible(true);
	   pCenter.setVisible(true);
	   this.add(p);
   }
   
   
   /**
    * Inner class name: MyListener
    * This inner class implements the Action Listener interface, which contains the 
    * actionPerformed() method for event-driven programming.
    *
    * @author     Jaren Pinera
    */
   private class MyListener implements ActionListener{
	   
	   // Declare and initialize the variablesto be used in the ActionListener
	   int gameCount = 0;
      int userChoice = 0;
      int comChoice = 0;
	   int userWins = 0;
	   int userLosses = 0;
	   int userTies = 0;
      String fileUser = "";
      String fileCom = "";
      boolean inGame = false;
      
      // Create a text file to print the results of each game
      File gameResults = new File ("scores.txt");
   
      // Create a Random object for the computer's choice
      Random random = new Random();
      
      
      /**
       * This method creates and determines a driven event, derived from the Action Listener interface. 
       * The events that occur when a user clicks on a JButton include pop-up dialog boxes, pictures 
       * and results of the RPS game. In addition, the method increments counts to keep track of scores and
       * prints/ writes its output to a text file.
       *
       * @param      event       An ActionEvent object from the ActionListener class/interface.
       * @exception  none
       * @return     none                        
       */  
	   public void actionPerformed(ActionEvent event) {
		   try {
				// Create the FileWriter and PrintWriter objects to write to and read in a file
			   FileWriter fw = new FileWriter(gameResults, true); // Don't overwrite file  
			   PrintWriter pw = new PrintWriter(fw);
            
            // Create conditional if statements depending on the button that the user presses
            // - User clicks "How To Play" button
            if (event.getSource() == bHTP) {
               // Set the Dialouge message
				   JOptionPane.showMessageDialog(new JFrame(),
                  "Welcome To ROCK - PAPER - SCISSORS!\nHere is how you play the game:" +
				      "\n1. Choose between Rock, Paper, or Scissors" +
                  "\n        Remember:" +
                  "\n             - ROCK beats SCISSORS" +
                  "\n             - PAPER beats ROCK" +
                  "\n             - SCISSORS beats PAPER" +
				      "\n2. The CPU will then choose between Rock, Paper Scissors" +
				   	"\n3. The results of the game will show and the winner gets a point!" +
				   	"\n     (The total score will be displayed on the bottom left)" +
                  "\n4. To PLAY ANOTHER round: Click the \"Play Again\" button on the left side" +
				   	"\n5. To EXIT the game: Click the \"QUIT\" button on the left side" +
                  "\n     Note: When you quit the game, a text file called \"scores.txt\" will be " + 
                  "generated and display every single game result!" +
                  "\n\n     HAVE FUN!!! :D", "GAME INSTRUCTIONS", 
                  JOptionPane.INFORMATION_MESSAGE);      
            }
            
            // - User hits "Quit" button
            else if (event.getSource() == bQuit) {  
               // Write the final tally of scores in the file and close it 
               pw.println("TOTAL SCORES:\n" + gameCount + " total games...\n\t Your Wins = " + userWins + 
               "\n\t Computer Wins (Your Losses) = " + userLosses + "\n\t Ties = " + userTies + 
               "\n\n====================================================================\n" +
               "====================================================================\n\n");
               pw.close();
               
               // Set the dialouge message towards the user and explain where the text file is 
               JOptionPane.showMessageDialog(new JFrame(),
                  "The results of every game and overall scores are stored/located in the \"scores.txt\" file" +
   			      "\n in the same folder as this GUI.\n\n\tHope you had fun!", 
                  "WAIT... BEFORE YOU GO!!", JOptionPane.INFORMATION_MESSAGE);
               // Close the GUI frame and screen
               System.exit(0);
            }
            
            // - User hits "Play Again" button
            else if (event.getSource() == bPA) {
               // Clear JLabels and reset results/instructions
               choice.setIcon(null);
               generate.setIcon(null);
               gameResult.setText(" ");
               gameResult.setVisible(false);
               instruct.setText("  Choose one (ROCK, PAPER, SCISSORS) to play  ");
               
               // Enable and disable Jbuttons
               // Reset Jbuttons to orginial format, since user wants to play another game
               bRock.setEnabled(true);
               bPaper.setEnabled(true);
               bScissors.setEnabled(true);
               bRock.setBackground(cRed);
         	   bPaper.setBackground(cYellow);
         	   bScissors.setBackground(cCyan);
               bRock.setBorder(BorderFactory.createLineBorder(Color.white, 5, true));
               bPaper.setBorder(BorderFactory.createLineBorder(Color.white, 5, true));
               bScissors.setBorder(BorderFactory.createLineBorder(Color.white, 5, true));
               bPA.setEnabled(false);
            }
            
            // - User clicks a JButton relating to the RPS game (ROCK, PAPER, or SCISSORS JButtons)
            else {
               inGame = true;
            } 
            
            // Create a loop to check for the user's and computer's options in game
            while (inGame) {
               // Make gameResult JLabel visible and increment the number of games played
               gameResult.setVisible(true);
               gameCount++;
               
               // Choice that user picks
               if (event.getSource() == bRock) {             // User clicks Rock JButton
                  userChoice = 1;
                  fileUser = "Rock";
                  choice.setIcon(iRock);
               }
               else if (event.getSource() == bPaper) {       // User clicks Paper JButton
                  userChoice = 2;
                  fileUser = "Paper";
                  choice.setIcon(iPaper);
               } 
               else if (event.getSource() == bScissors) {    // User clicks Scissors JButton
                  userChoice = 3;
                  fileUser = "Scissors";
                  choice.setIcon(iScissors);
               }
               
               // Generate a random choice for the computer
               comChoice = random.nextInt(3) + 1;            // comChoice between 1 - 3
               if (comChoice == 1) {
                  generate.setIcon(iRockFlip);
                  fileCom = "Rock";
               }
               else if (comChoice == 2) {
                  generate.setIcon(iPaperFlip);
                  fileCom = "Paper";
               }
               else if (comChoice == 3) {
                  generate.setIcon(iScissorsFlip);
                  fileCom = "Scissors";
               }
               
               // Write the general information of the game to the scores file
               pw.println("Game #" + gameCount + ":\nYour choice: " + fileUser + 
                  "\nComputer choice: " + fileCom);
                  
               // Check to see who wins
               if ((userChoice == 1 && comChoice == 1) || (userChoice == 2 && comChoice == 2)
                  || (userChoice == 3 && comChoice == 3)) {  // tie
                  // Increment ties and set the gameResult JLabel to appropriate colors/text
                  userTies++;
                  gameResult.setText("  IT'S A TIE !!! :)  ");
                  gameResult.setForeground(Color.black);
                  
                  // Update scoreboard of GUI and write the result of the game to the file
                  ties.setText("  Ties: " + userTies);    
                  pw.println("Result: TIE!");  
               }
               
               else if ((userChoice == 1 && comChoice == 3) || (userChoice == 2 && comChoice == 1)
                  || (userChoice == 3 && comChoice == 2)) {  // user wins
                  // Increment wins and set the gameResult JLabel to appropriate colors/text
                  userWins++;
                  gameResult.setText("  YOU WIN !!! :D  ");                 
                  gameResult.setForeground(cGreen);
                  
                  // Update scoreboard of GUI and write the result of the game to the file
                  wins.setText("  You: " + userWins);
                  pw.println("Result: You Win!");
                  
               }
               
               else {  // computer wins
                  // Increment losses and set the gameResult JLabel to appropriate colors/text
                  userLosses++;
                  gameResult.setText("  YOU LOSE !!! :(  ");
                  gameResult.setForeground(cBrtRed);
                  
                  // Update scoreboard of GUI and write the result of the game to the file
                  losses.setText("  Computer: " + userLosses);
                  pw.println("Result: Computer Wins!");   
               }
               
               
               // Write the updated scores to the file
               pw.println("\t~~ Score: You = " + userWins + " | Com = " + userLosses + "  | Ties = " +
                  userTies + "\n\n====================================================================\n");
               
               
               // After a round of RPS game, disable the RPS user buttons and reset button colors
               // User will need to hit "Play Again" button to start another game
               bPA.setEnabled(true);
               bRock.setEnabled(false);
               bPaper.setEnabled(false);
               bScissors.setEnabled(false);
               bRock.setBackground(Color.gray);
            	bPaper.setBackground(Color.gray);
            	bScissors.setBackground(Color.gray);
               bRock.setBorder(BorderFactory.createEmptyBorder());
               bPaper.setBorder(BorderFactory.createEmptyBorder());
               bScissors.setBorder(BorderFactory.createEmptyBorder());
               
               // Reset instruction text choices for both sides
               instruct.setText("  Click \"PLAY AGAIN\" button to play another game  ");
               userChoice = 0;
               comChoice = 0;
               
               // Break out of loop
               inGame = false;
            }  // while loop
            
            // Close the PrintWriter
            pw.close();
              
         }  // try block
         
         // Catch the IOException
         catch(IOException ioe){
	         System.out.println("Error: Could not write to/ read-in file...");
         }  // catch block
      }  // actionPerformed() method
   }  // inner class MyListener
}  // Class RPSFrameGUI