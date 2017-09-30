package com.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Sakib Hossain on 29/09/2017.
 */
public class KeyInput extends KeyAdapter {


    private Handler handler;


    public KeyInput(Handler handler){
        this.handler = handler;
    }


    public void keyPressed(KeyEvent e){

        int key = e.getKeyCode();     //shows and prints the number of the key we pressed

        for(int i=0; i<handler.gameObjects.size();i++){
            GameObject temp = handler.gameObjects.get(i);

            if(temp.getId()== Identity.Player){
                if(key == KeyEvent.VK_W)
                    temp.setVelY(-5);
                if(key == KeyEvent.VK_S)
                    temp.setVelY(5);
                if(key == KeyEvent.VK_A)
                    temp.setVelX(-5);
                if(key == KeyEvent.VK_D)
                    temp.setVelX(5);

            }


        }

    }

    public void keyReleased(KeyEvent e){

        int key = e.getKeyCode();


        for(int i=0; i<handler.gameObjects.size();i++){
            GameObject temp = handler.gameObjects.get(i);


        if(temp.getId()== Identity.Player){
            if(key == KeyEvent.VK_W)
                temp.setVelY(0);
            if(key == KeyEvent.VK_S)
                temp.setVelY(0);
            if(key == KeyEvent.VK_A)
                temp.setVelX(0);
            if(key == KeyEvent.VK_D)
                temp.setVelX(0);

        }


    }

    if (key == KeyEvent.VK_ESCAPE)
        System.exit(1);



    }


}
