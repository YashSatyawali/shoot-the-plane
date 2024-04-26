package com.FirstOwnGame.main;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
    public  GameFrame(){

        Board board = new Board();
        setSize(1400,820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("shoot");
        setLocationRelativeTo(null);
        add(board);
        setVisible(true);
        
    }

        
    public static void main(String[] args) {
        new GameFrame();
    }
}
