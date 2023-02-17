package com.mycompany.game;
/**
 * @author Doaa Mahdy Mohamed
 * @LastModification 2023 - 2 -17
 */
public class Player 
{
   private String name;
   private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public boolean getMove(int x,int y,Board b)
    {
       return b.update(x, y, symbol);
    }
   
}
