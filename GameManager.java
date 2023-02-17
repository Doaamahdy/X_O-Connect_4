package com.mycompany.game;
import java.util.Scanner;

/**
 * @author Doaa Mahdy Mohamed
 * @LastModification 2023 - 2 -17
 */
public class GameManager {
    private int turn = 0;
    private Player[] players;
    private Board board;

  
    public GameManager(Player[] players, Board board) {
        this.players = players;
        this.board = board;
        Scanner in = new Scanner(System.in);
        System.out.print("Entet the name of Player1 : ");
        String name = in.nextLine();
        System.out.print("Entet the name of Player2 : ");
        String name2 = in.nextLine();
        players[0] = new Player(name,'X');
        players[1] = new Player(name,'O');
    }
    
    
    public void play_game()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Hi Ya User:)\n1- X_O game\n2- connect4 game\n>>>>");
        int ch = in.nextInt();
        int x = 0;
        int y = 0;
        char player;
        X_O_Board b1 = new X_O_Board();
        Connect4_Board b2 = new Connect4_Board();
        while(true)
        {
        
        switch(ch)
        {
            
            case 1:
                this.board = b1;
                board.displayBoard();
                player = players[turn%2].getSymbol();
                System.out.print( player+": Enter the number of column,row to play: ");
                x = in.nextInt();
                y = in.nextInt();
                break;
            case 2: 
                this.board = b2;
                board.displayBoard();
                player = players[turn%2].getSymbol();
                System.out.print( player+": Enter the number of column to play: ");
                y = in.nextInt();
                break;
        }
        
          if(players[turn%2].getMove(x, y, board))
          {
              turn++;
          }
        
        if(board.is_winner('X' ))
        {
           board.displayBoard();
           System.out.println(players[0].getName() + " Won the game:)");
           break;
        }
        else if(board.is_winner('O' ))
        {
           board.displayBoard();
           System.out.println(players[1].getName() + " Won the game:)");
           break;
        }
        else if(board.is_draw())
        {
            board.displayBoard();
            System.out.println("Tie");
            break;
        }
    }
  }
    
}
