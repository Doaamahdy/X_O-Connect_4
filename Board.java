package com.mycompany.game;
/**
 * @author Doaa Mahdy Mohamed
 * @LastModification 2023 - 2 -17
 */
public abstract class Board {
   protected int row;
   protected int col;
   protected char[][]grid;
   
   abstract boolean update(int x,int y,char symbol);
   abstract void displayBoard();
   abstract boolean is_winner(char symbol);
   abstract boolean is_draw(); 
}
