package com.mycompany.game;

import java.util.Scanner;

/**
 * @author Doaa Mahdy Mohamed
 * @LastModification 2023 - 2 -17
 */
public class X_O_Board extends Board {

    X_O_Board()
    {
        row = 3;
        col = 3;
        grid = new char [3][3];
        for(int i = 0;i<row;i++)
        {
            for(int j = 0;j<col;j++)
                grid[i][j] = ' ';
        }
    }
    @Override
    boolean update(int x, int y, char symbol) {
        if( (x > 3 || x <1) || (y > 3 || y <1))
            return false;
        if(grid[x-1][y-1] == 'X' || grid[x-1][y-1] == 'O')
            return false;
        grid[x-1][y-1] = symbol;
        return true;
    }

    @Override
    void displayBoard() {
        System.out.println("\n  1    2     3 ");
        for(int i = 0;i<row;i++)
        {
            System.out.print(i+1);
            for(int j = 0;j<col;j++)
            {
               System.out.print(" "+grid[i][j]);
               if( j != 2)
                   System.out.print("  | ");
            }
           if(i != 2) System.out.println("\n ................");
        }
        System.out.println("\n");
    }

    @Override
    boolean is_winner(char symbol) 
    {
        boolean checkWin = false;
        for(int i = 0;i<3;i++)
        {
            if(grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] == symbol)
                return true;
            if(grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] == symbol)
                return true;
        }
        if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] == symbol)
            return true;
        if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] == symbol)
            return true;
        
        return false;
    }

    @Override
    boolean is_draw() {
       boolean isFull = true;
       boolean win1 = is_winner('X');
       boolean win2 = is_winner('O');
       for(int i = 0;i < 3;i++)
       {
           for(int j = 0;j< 3;j++)
           {
               if(grid[i][j] == ' ')
                   return false;
           }
       }
       return isFull && !(win1 || win2);
    }
    
}
