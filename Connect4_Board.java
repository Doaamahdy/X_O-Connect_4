package com.mycompany.game;
/**
 * @author Doaa Mahdy Mohamed
 * @LastModification 2023 - 2 -17
 */
public class Connect4_Board extends Board {

    Connect4_Board()
    {
    row = 6;
    col = 7;
    grid = new char[row+6][col+6];
    for(int i = 0;i < row + 6;i++){
           for(int j = 0;j < col+6;j++)
           {
               grid[i][j] = ' ';   
           }
        }
    }
    @Override
    public boolean update(int x, int y, char symbol) 
    {
        if((y > 7 || y <= 0))
            return false;
        
        for(int i = 0;i < 7; i++)
        {
            if(grid[i][y] != 'O'&&grid[i][y] != 'X')
            {
                grid[i][y] = symbol;
                return true;
            }
        }
       return false;
    }

    @Override
    public void displayBoard() {
        System.out.println("\n  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | " );
        System.out.println("..................................");
        for(int i = row;i>=0;i--){
           for(int j = 0;j <= col;j++)
           {
               System.out.print(grid[i][j] + " | ");
           }
           System.out.println("\n..................................");
        }
    
    }
    

    @Override
    boolean is_winner(char symbol) {
        for(int i = 0;i<row;i++)
        {
            for(int j = 0;j<col;j++)
            {
                if(grid[i][j] == grid[i][j+1] && grid[i][j+1] == grid[i][j+2] && grid[i][j+2] == grid[i][j+3] && grid[i][j] == symbol)
                    return true;
                else if(grid[i][j] == grid[i+1][j] && grid[i+1][j] == grid[i+2][j] && grid[i+2][j] == grid[i+3][j] && grid[i][j] == symbol)
                    return true;
                else if(grid[i][j] == grid[i+1][j+1] && grid[i+1][j+1] == grid[i+2][j+2] && grid[i+2][j+2] == grid[i+3][j+3] && grid[i][j] == symbol)
                    return true;
                if(j >= 4)
                {
                if(grid[i][j] == grid[i+1][j-1] && grid[i+1][j-1] == grid[i+2][j-2] && grid[i+2][j-2] == grid[i+3][j-3] && grid[i][j] == symbol)
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    boolean is_draw() {
       boolean isFull = true;
       boolean win1 = is_winner('X');
       boolean win2 = is_winner('O');
       for(int i = 1;i <=6;i++)
       {
           for(int j = 1;j<=7;j++)
           {
               if(grid[i][j] != 'X' && grid[i][j] != 'O'  )
                   isFull = false;
           }
       }
       return isFull && !(win1 || win2);
    }
    
}
