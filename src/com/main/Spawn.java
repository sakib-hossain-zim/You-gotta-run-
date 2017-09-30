package com.main;

import java.util.Random;

/**
 * Created by Sakib Hossain on 29/09/2017.
 */
public class Spawn {

    private Handler handler;
    private HUD hud;
    private int scorekeep = 0;
    private Random r = new Random();

    public Spawn(Handler handler,HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){

        scorekeep++;

        if(scorekeep>= 200) {
            scorekeep = 0;
            hud.setLevel(hud.getLevel() + 1);

               if(hud.getLevel() ==2 ){

                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Identity.BasicEnemy, handler));

        } else if (hud.getLevel()==3){
                   handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Identity.BasicEnemy, handler));

               }
               else if (hud.getLevel() == 4){
                   handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), Identity.FastEnemy, handler));

               }

               }



    }
}
