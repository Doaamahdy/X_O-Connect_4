package com.mycompany.game;
/**
 * @author Doaa Mahdy Mohamed
 * @LastModification 2023 - 2 -17
 */
public class Game {

    public static void main(String[] args) {
        Connect4_Board a = new Connect4_Board();
        Player []p = new Player[2];
       GameManager game = new GameManager(p,a);
       game.play_game();
    }
}
