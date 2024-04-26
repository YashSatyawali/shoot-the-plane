package com.FirstOwnGame.main;

import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.FirstOwnGame.main.spirits.Enemy;
import com.FirstOwnGame.main.spirits.Missile;

public class Board extends JPanel{
    
    BufferedImage Background;
    Enemy enemy;
    Missile missile;
    Timer timer;
    int points =0;
    boolean shot;

    public Board(){
        setSize(1500,820);
        loadBackground();
        enemy = new Enemy();
        missile = new Missile();
        gameLoop();
        setFocusable(true);
        bindEvents();

    }
    
    public void gameSituation(Graphics pen){
        if(shot = true && missile.y <= 50)
        pen.setFont(new Font("times",Font.BOLD, 60));
        pen.setColor(Color.cyan);
        pen.drawString("Points: "+points, 1080, 50);
        if(collide()){
            points += 1;
            missile.y = 700;
            missile.yspeed =0;
            missile.x = 600;
            // pen.setFont(new Font("times",Font.BOLD, 30));
            // pen.setColor(Color.cyan);
            // pen.drawString(""+points, 1100, 50);
            shot = false;
            
        }
        else if(!collide() && shot == true){
            pen.setFont(new Font("times",Font.BOLD, 80));
            pen.setColor(Color.RED);
            pen.drawString("Game Over", 1200/2, 820/2);
            timer.stop();
        }
    }

    public boolean collide(){
        int xDis = Math.abs(missile.x - enemy.x);
        int yDis = Math.abs(missile.y - enemy.y);
        int maxH = Math.max(missile.h, enemy.h);
        int maxW = Math.max(missile.w , enemy.w);
        
        return xDis <= maxW && yDis <= maxH;
    }       

    public void bindEvents(){
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    missile.mspeed = 20;
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    missile.mspeed = -20;
                }
                else if(e.getKeyCode()== KeyEvent.VK_SPACE){
                    missile.yspeed = -20;
                    shot = true;
                }
                throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                missile.mspeed = 0;
                // if(collide()){
                //     missile.yspeed = 0;
                // }
                throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
            }
            
        });
    }

    private void gameLoop(){
        timer = new Timer(50, (e)->repaint());
        timer.start();
    }

    public void loadBackground(){
        try {
            Background = ImageIO.read(Board.class.getResource("gamebackground.jpeg"));
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("Image not found");
            System.exit(1);
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics pen){
        super.paintComponent(pen);
        pen.drawImage(Background, 0, 0, null);
       // Graphics2D enemy = (enemy)pen;
       // pen.rotate(Math.toRadians(180));
        enemy.draw(pen);
        enemy.move();
        missile.draw(pen);
        missile.move();
        missile.upmove();
        gameSituation(pen);
    }
}
