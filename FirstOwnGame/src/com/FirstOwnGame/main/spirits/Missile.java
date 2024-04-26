package com.FirstOwnGame.main.spirits;

import javax.swing.ImageIcon;

//import com.FirstOwnGame.main.Board;

public class Missile extends Spirite{
     //Board collide;
    public Missile(){
        x = 600;
        y = 700;
        w = 10;
        h = 200;

        image = new ImageIcon(Missile.class.getResource("missilecropped.gif"));
    }

    public void move(){
        
        if(x<=100)x = 120;
        else if (x>=1200) x =1180;
            
            x+=mspeed;
        
    }

    public void upmove(){
       // if(collide.collide())y = 500;

        y = y+yspeed;
    }
}