package com.main;

import java.awt.*;

/**
 * Created by Sakib Hossain on 29/09/2017.
 */
public class HUD {


    public static int LIFE_SPAN = 100;
    private int greenValue = 255;
    private int score = 0;
    private int level = 1;



    public void tick(){



        LIFE_SPAN = Game.clamp(LIFE_SPAN,0,100);

        greenValue = Game.clamp(greenValue,0,255);
        greenValue = LIFE_SPAN*2;
        score++;

    }


    public void render(Graphics g){

        g.setColor(Color.gray);
        g.fillRect(15,15,200,32);


        g.setColor(new Color(75,greenValue,0));
        g.fillRect(15,15,LIFE_SPAN*2,32);

        g.setColor(Color.white);
        g.drawRect(15,15,200,32);

        g.drawString("Score: "+ score, 10,64);
        g.drawString("Level: "+ level, 10,80);


    }

    public void score(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }
}
