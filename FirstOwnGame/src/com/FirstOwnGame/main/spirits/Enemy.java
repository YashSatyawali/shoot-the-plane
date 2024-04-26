 package com.FirstOwnGame.main.spirits;

import javax.swing.ImageIcon;

public class Enemy extends Spirite{

    public Enemy(){
        x = 600;
        y = 5;
        h = 330;
        w = 150;

        image = new ImageIcon(Enemy.class.getResource("enemyplanecropped.gif"));
    }

    public void move(){
        
        if(x <= 100 || x>=1200){
           espeed *= -1;
        }
        
         x += espeed;
    }

}
