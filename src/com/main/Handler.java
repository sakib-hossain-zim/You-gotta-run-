package com.main;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Sakib Hossain on 29/09/2017.
 */
public class Handler {     //this class loops through all our objects and updates them


    LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();

    public void tick(){    //updates all teh game Objects

        for(int i = 0; i<gameObjects.size();i++){
            GameObject temp = gameObjects.get(i);

            temp.tick();

        }

    }

    public void render(Graphics g){   //updates all the game Objects

        for(int i=0;i<gameObjects.size();i++){
            GameObject temp = gameObjects.get(i);

            temp.render(g);

        }

    }

    public void addObject(GameObject obj){
        this.gameObjects.add(obj);
    }

    public void removeObject(GameObject obj){
        this.gameObjects.remove(obj);
    }
}
