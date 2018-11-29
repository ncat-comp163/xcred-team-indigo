/** imports used for the program. */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;

/** Interactive game of connect four. The program completes a single
game of connect four, then outputs the winner.
@author lmmcmahan@aggies.ncat
@author kascott5@aggies.ncat.edu
@author jcthomas1@aggies.ncat.edu*/
public class connectFour {
   JFrame frame;
   JPanel panel;
   final int rowTiles = 6;
   final int colTiles = 7;
   static int[][] grid = new int[6][7];
   int row, col, rowSelected, colSelected = 0;
   int pTurn = 0;
   boolean win = false;
   JButton[][] button = new JButton[rowTiles][colTiles];
   JLabel whoWon;
   GridLayout myGrid = new GridLayout(7,7);
   final ImageIcon c0 = new ImageIcon("GreyCircle.png");
   final ImageIcon c1 = new ImageIcon("RedCircle.png");
   final ImageIcon c2 = new ImageIcon("YellowCircle.png");
         
    /** constructor of program which shows visual of board, applies action
    listener to button presses within grid, makes the program visible to user. */
   public connectFour() {
      frame = new JFrame("Connect Four");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      panel = new JPanel();
      panel.setLayout(myGrid);
      whoWon = new JLabel("");
   
      //-1 are empty slots not allowed to go in (nothing is under them)
      //0 are empty slots allowed to fill, either bottom most or already a piece under them
      //1 for player1, 2 for player2
      for (int x = rowTiles - 2; x >= 0; x--) {
         for (int y = colTiles - 1; y >= 0; y--) {
            grid[x][y] = -1;
         }
      }
    
      for (row = 0; row <= rowTiles - 1; row++) {
         for (col = 0; col <= colTiles - 1; col++) {
            button[row][col] = new JButton(c0);
            button[row][col].addActionListener(new buttonListener());
            panel.add(button[row][col]);
         }
      }
    
      panel.add(whoWon);
      frame.setContentPane(panel);
      frame.pack();
      frame.setVisible(true);
   }
	   
    /** ActionListener for the buttons in the program. This checks to
    see if a player wins after each move. When player wins program outputs
    a message stating the winner.*/
   class buttonListener implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         for (row = rowTiles-1; row >= 0; row--) {
            for (col = colTiles-1; col >= 0; col--) {
               if (button[row][col] == event.getSource()) {
                  if (pTurn % 2 == 0 && grid[row][col] == 0) {
                     button[row][col].setIcon(c1);
                     grid[row][col] = 1;
                     try {
                        grid[row-1][col] = 0;
                     }
                     catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Reached top of column");
                     }
                     if (checkWin()) {
                        System.out.println("player 1 win");
                        whoWon.setText("Player 1 wins");
                        for (int x = rowTiles - 1; x >=0; x--) {
                           for (int y = colTiles - 1; y >= 0; y--) {
                              grid[x][y] = -1;
                           }
                        }
                     }
                     pTurn = pTurn + 1;
                     break;
                  }
                  if (pTurn % 2 == 1 && grid[row][col] == 0) {
                     button[row][col].setIcon(c2);
                     grid[row][col] = 2;
                     try {
                        grid[row-1][col] = 0;
                     }
                     catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Reached top of column");
                     }
                     if (checkWin()) {
                        System.out.println("player 2 win");
                        whoWon.setText("Player 2 wins");
                        for (int x = rowTiles - 1; x >=0; x--) {
                           for (int y = colTiles - 1; y >= 0; y--) {
                              grid[x][y] = -1;
                           }
                        }
                     }
                     pTurn = pTurn + 1;
                     break;
                  }
               }
            }
         }
      }
   }
	 
       
	 /** Method below checks to see if there are four of the same piece 
    in the various dircetions avalibale to win in connect four.
    @return win someone succesfully achieved a connect four.*/
   public boolean checkWin() {
      // check for a horizontal win
      for (int x=0; x<6; x++) {
         for (int y=0; y<4; y++) {
            if (grid[x][y] != 0 && grid[x][y] != -1 &&
                   grid[x][y] == grid[x][y+1] &&
                   grid[x][y] == grid[x][y+2] &&
                   grid[x][y] == grid[x][y+3]) {
               win = true;
            }
         }
      }
      // check for a vertical win
      for (int x=0; x<3; x++) {
         for (int y=0; y<7; y++) {
            if (grid[x][y] != 0 && grid[x][y] != -1 &&
                   grid[x][y] == grid[x+1][y] &&
                   grid[x][y] == grid[x+2][y] &&
                   grid[x][y] == grid[x+3][y]) {
               win = true;
            }
         }
      }
      // check for a diagonal win (positive slope)
      for (int x=0; x<3; x++) {
         for (int y=0; y<4; y++) {
            if (grid[x][y] != 0 && grid[x][y] != -1 &&
                   grid[x][y] == grid[x+1][y+1] &&
                   grid[x][y] == grid[x+2][y+2] &&
                   grid[x][y] == grid[x+3][y+3]) {
               win = true;
            }
         }
      }
      // check for a diagonal win (negative slope)
      for (int x=3; x<6; x++) {
         for (int y=0; y<4; y++) {
            if (grid[x][y] != 0 && grid[x][y] != -1 &&
                   grid[x][y] == grid[x-1][y+1] &&
                   grid[x][y] == grid[x-2][y+2] &&
                   grid[x][y] == grid[x-3][y+3]) {
               win = true;
            }
         }
      }
      return win;
   }
	    
   /** Main method of program. Creates object of class.
   @param args string array.*/
   public static void main(String[] args) {
      new connectFour();
   }
}
