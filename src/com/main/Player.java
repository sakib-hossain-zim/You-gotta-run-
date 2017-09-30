package com.main;

import java.awt.*;
import java.util.Random;

/**
 * Created by Sakib Hossain on 29/09/2017.
 */
public class Player extends GameObject {


    Random r = new Random();
    Handler handler;

    public  Player(int x, int y, Identity id,Handler handler){
    super(x,y,id);
        this.handler = handler;





}



    @Override
    public void tick() {

        x +=velX;
        y +=velY;

       x = Game.clamp(x,0,Game.WIDTH-32);
       y = Game.clamp(y,0,Game.HEIGHT-32);

        handler.addObject(new Trail(x,y,Identity.Trail,Color.white,32,32,0.05f,handler));


        collision();

    }


    private void collision(){
        for(int i = 0; i <handler.gameObjects.size();i++){

            GameObject temp = handler.gameObjects.get(i);

            if(temp.getId()==Identity.BasicEnemy|| temp.getId() == Identity.FastEnemy){
                if(getBounds().intersects(temp.getBounds())){

                    HUD.LIFE_SPAN-=2;

                }
            }
        }
    }

    @Override
    public void render(Graphics g) {




        g.setColor(Color.white);

       // g.setColor(Color.white);
        g.fillRect(x,y,32,32);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }


}
