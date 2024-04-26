package com.FirstOwnGame.main.spirits;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public abstract class Spirite {
    public int x;
    public int y;
    public int h;
    public int w;
    public int espeed = 10 ;
    public int mspeed ;
    public int yspeed;
    ImageIcon image;

    public void draw(Graphics pen){
        pen.drawImage(image.getImage(), x, y, w, h, null);
    }
}
