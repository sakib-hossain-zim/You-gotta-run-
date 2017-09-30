package com.main;

import java.awt.*;

/**
 * Created by Sakib Hossain on 29/09/2017.
 */





    /**
     * Created by Sakib Hossain on 29/09/2017.
     */
    public class FastEnemy extends GameObject {

        private Handler handler;


        public FastEnemy(int x, int y, Identity id, Handler handler){
            super(x,y,id);

            this.handler = handler;

            velX = 2;
            velY = 9;



        }
        @Override
        public void tick() {

            x+=velX;
            y+=velY;


            if(y <=0 || y >= Game.HEIGHT-32) velY *= -1;    //helps to keep the enemy on the screen

            if(x<=0|| x >= Game.WIDTH-16) velX *= -1;


            handler.addObject(new Trail(x,y,Identity.Trail, Color.cyan,16,16,0.02f,handler));

        }

        @Override
        public void render(Graphics g) {

            g.setColor(Color.CYAN);
            g.fillRect(x,y,16,16);

        }

        @Override
        public Rectangle getBounds() {

            return new Rectangle(x,y,16,16);


        }
    }


